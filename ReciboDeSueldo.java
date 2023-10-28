package Objetos1.Ejercicio_18;

import java.time.LocalDate;

public class ReciboDeSueldo {
	
	private String nombre;
	private String apellido;
	private int CUIL;
	private int añosDeAntiguedad;
	private LocalDate fechaDeCreacion;
	private double monto;
	
	public ReciboDeSueldo(String nombre, String apellido, int CUIL, int añosDeAntiguedad, double monto) {
		this.fechaDeCreacion = LocalDate.now();
		this.apellido = apellido;
		this.añosDeAntiguedad = añosDeAntiguedad;
		this.CUIL = CUIL;
		this.monto = monto + porcentajeDeAntiguedad(monto);
		this.nombre = nombre;
	}
	
	private double calcularPorcentaje() {
		if(this.añosDeAntiguedad > 5) {
			if(this.añosDeAntiguedad > 10) {
				if(this.añosDeAntiguedad > 15) {
					if(this.añosDeAntiguedad > 20) {
						return 1;
					}
					return 0.7;
				}
				return 0.5;
			}
			return 0.3;
		}
		return 0;
	}
	
	private double porcentajeDeAntiguedad(double monto) {
		return this.calcularPorcentaje() * monto;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getCUIL() {
		return CUIL;
	}

	public int getAñosDeAntiguedad() {
		return añosDeAntiguedad;
	}

	public LocalDate getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public double getMonto() {
		return monto;
	}
}
