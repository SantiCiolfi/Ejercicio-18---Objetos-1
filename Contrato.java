package Objetos1.Ejercicio_18;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public abstract class Contrato {
	
	private Empleado empleado;
	private LocalDate fechaInicio;
	
	public Contrato(Empleado unEmpleado, LocalDate fechaInicio) {
		this.empleado = unEmpleado;
		this.fechaInicio = fechaInicio;
	}
	
	public int masReciente() {
		long dias = DAYS.between(LocalDate.now(), this.fechaInicio);
		return Math.toIntExact(dias);
	}
	
	public abstract boolean isVencido();
	public abstract double calcularMonto();
}
