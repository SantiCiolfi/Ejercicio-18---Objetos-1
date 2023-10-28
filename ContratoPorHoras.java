package Objetos1.Ejercicio_18;
import java.time.LocalDate;

public class ContratoPorHoras extends Contrato{
	
	private LocalDate fechaFin;
	private double valorPorHora;
	private double horasPorMes;
	
	public ContratoPorHoras(Empleado unEmpleado, LocalDate fechaInicio, LocalDate fechaFin, double valorPorHora, double horasPorMes) {
		super(unEmpleado, fechaInicio);
		this.fechaFin=fechaFin;
		this.horasPorMes=horasPorMes;
		this.valorPorHora=valorPorHora;
	}
	
	public boolean isVigente() {
		return this.fechaFin.isAfter(LocalDate.now());
	}

	public boolean isVencido() {
		return !this.isVigente();
	}

	public double calcularMonto() {
		return this.horasPorMes * this.valorPorHora;
	}
}
