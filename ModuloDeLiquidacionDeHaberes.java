package Objetos1.Ejercicio_18;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuloDeLiquidacionDeHaberes {
	
	private List<Empleado> nomina;
	
	public ModuloDeLiquidacionDeHaberes() {
		this.nomina = new ArrayList<>();
	}
	
	public void darDeAltaEmpleadoTest(Empleado empleadoNuevo) {
		this.nomina.add(empleadoNuevo);
	}
	
	public void darDeAltaEmpleado(String nombre, String apellido, int CUIL, LocalDate fechaNacimiento, boolean conyugeACargo, boolean hijosACargo) {
		Empleado empleadoNuevo = new Empleado (nombre, apellido, CUIL, fechaNacimiento, conyugeACargo, hijosACargo);
		this.nomina.add(empleadoNuevo);
	}
	
	public void darDeBajaEmpleado(Empleado empleado) {
		this.nomina.remove(empleado);
	}
	
	public Empleado buscarEmpleado(int CUIL) {
		return this.nomina.stream().filter(empleado -> empleado.compararCUIL(CUIL))
				.findFirst()
				.orElse(null);
	}
	
	public void cargarContratoPorHoras(Empleado unEmpleado, LocalDate fechaInicio, LocalDate fechaFin, double Valor_hora, double horas) {
		ContratoPorHoras contratoPorHoras = new ContratoPorHoras (unEmpleado,  fechaInicio,  fechaFin,  Valor_hora,  horas); 
		unEmpleado.agregarContratoPorHoras(contratoPorHoras);
	}
	
	public void cargarContratoDePlanta(Empleado unEmpleado, LocalDate fechaInicio, double sueldoMensual, double montoConyuge, double montoHijos) {
		unEmpleado.agregarContratoDePlanta(fechaInicio, sueldoMensual, montoConyuge, montoHijos);
	}
	
	public List<Empleado> obtenerEmpleadosConContratoVencido(){
		return this.nomina.stream()
				.filter(empleado -> empleado.contratoVencido())
				.collect(Collectors.toList());
	}
	
	public List<ReciboDeSueldo> generarRecibosDeCobro(){
		return this.nomina.stream().filter(empleado -> !empleado.contratoVencido()).map(empleado -> empleado.generarReciboDeSueldo()).collect(Collectors.toList());
	}
}
