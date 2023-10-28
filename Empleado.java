package Objetos1.Ejercicio_18;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Empleado {
	
	private String nombre;
	private String apellido;
	private int CUIL;
	private LocalDate fechaNacimiento;
	private boolean conyugeACargo;
	private boolean hijosACargo;
	private LocalDate fechaInicioRelacionLaboral;
	private Contrato contratoActivo;
	private List<Contrato> contratos;
	
	public Empleado(String nombre, String apellido, int CUIL, LocalDate fechaNacimiento, boolean conyugeACargo, boolean hijosACargo) {
		this.apellido=apellido;
		this.conyugeACargo=conyugeACargo;
		this.CUIL=CUIL;
		this.fechaNacimiento=fechaNacimiento;
		this.hijosACargo=hijosACargo;
		this.nombre=nombre;
		this.fechaInicioRelacionLaboral= LocalDate.now();
		this.contratos = new ArrayList<>();
	}
	
	public boolean compararCUIL(int CUIL) {
		return this.CUIL == CUIL;
	}
	
	private void actualizarContratoActual() {
		Contrato contratoMasActual;
		contratoMasActual = this.contratos.stream()
				.min((contrato1, contrato2) -> Double.compare(contrato1.masReciente(), contrato2.masReciente()))
				.orElse(null);
		if((this.contratoActivo == null)||(this.contratoActivo.masReciente() > contratoMasActual.masReciente())) {
			this.contratoActivo = contratoMasActual;
		}
	}
	
	public void agregarContratoPorHoras(ContratoPorHoras contrato) {
		this.contratos.add(contrato);
		this.actualizarContratoActual();
	}
	
	public boolean contratoVencido() {
		return this.contratoActivo.isVencido();
	}
	
	private double actualizarMontoConyuge(double montoConyuge) {
		if(this.conyugeACargo) {
			return montoConyuge;
		}
		else {
			return 0;
		}
	}
	
	private double actualizarMontoHijos(double montoHijos) {
		if(this.hijosACargo) {
			return montoHijos;
		}
		else {
			return 0;
		}
	}
	
	public void agregarContratoDePlanta(LocalDate fechaInicio, double sueldoMensual, double montoConyuge, double montoHijos) {
		montoConyuge = this.actualizarMontoConyuge(montoConyuge);
		montoHijos = this.actualizarMontoHijos(montoHijos);
		ContratoDePlanta contratoDePlanta = new ContratoDePlanta (this,  fechaInicio,  sueldoMensual, montoConyuge, montoHijos); 
		this.contratos.add(contratoDePlanta);
		this.actualizarContratoActual();
	}
	
	private int calcularAñosDeAntiguedad() {
		return LocalDate.now().getYear()-this.fechaInicioRelacionLaboral.getYear();
		//return LocalDate.now().getYear()-2010;
	}
	
	public ReciboDeSueldo generarReciboDeSueldo() {
		ReciboDeSueldo recibo = new ReciboDeSueldo(this.nombre, this.apellido, this.CUIL,  calcularAñosDeAntiguedad(), this.contratoActivo.calcularMonto());
		return recibo;
	}
}
