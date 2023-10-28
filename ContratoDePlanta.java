package Objetos1.Ejercicio_18;
import java.time.LocalDate;

public class ContratoDePlanta extends Contrato{
	
	private double sueldoMensual;
	private double montoConyuge;
	private double montoHijos;
	
	public ContratoDePlanta (Empleado unEmpleado, LocalDate fechaInicio, double sueldoMensual, double montoConyuge, double montoHijos) {
		super(unEmpleado, fechaInicio);
		this.montoConyuge=montoConyuge;
		this.montoHijos=montoHijos;
		this.sueldoMensual=sueldoMensual;
	}

	public boolean isVencido() {
		return false;
	}

	public double calcularMonto() {
		return this.montoConyuge + this.montoHijos + this.sueldoMensual;
	}
	
}
