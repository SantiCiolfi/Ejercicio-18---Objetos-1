package Objetos1.Ejercicio_18;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestModulo {
	ModuloDeLiquidacionDeHaberes m;
	Empleado e1;
	Empleado e2;
	ContratoPorHoras cph1;
	ContratoPorHoras cph2;
	ReciboDeSueldo r1;
	
	@BeforeEach
	public void setUp() {
		m = new ModuloDeLiquidacionDeHaberes();
		e1 = new Empleado("pepe", "lopez", 111, LocalDate.of(2023 ,1 ,9),true, false);
		e2 = new Empleado("pepe2", "lopez2", 222, LocalDate.of(2011 ,1 ,9),false, false);
		cph1 = new ContratoPorHoras(e2, LocalDate.of(2000 ,1 ,9), LocalDate.of(2023 ,10 ,28), 10, 10);
		cph2 = new ContratoPorHoras(e1, LocalDate.of(2000 ,1 ,9), LocalDate.of(2024 ,1 ,9), 10, 10);
	}
	
	@Test
	public void testBuscar() {
		m.darDeAltaEmpleadoTest(e1);
		assertEquals(e1,m.buscarEmpleado(111));
		assertNull(m.buscarEmpleado(0));
		m.darDeAltaEmpleadoTest(e2);
		assertEquals(e1,m.buscarEmpleado(111));
	}
	
	@Test
	public void testEmpleadosConContratoVencido() {
		e1.agregarContratoPorHoras(cph1); //vencido
		e2.agregarContratoPorHoras(cph2); //no vencido
		m.darDeAltaEmpleadoTest(e2);
		assertTrue(m.obtenerEmpleadosConContratoVencido().isEmpty());
		m.darDeAltaEmpleadoTest(e1);
		assertTrue(m.obtenerEmpleadosConContratoVencido().contains(e1));
	}
	
	@Test
	public void testGenerarrecibosDeCobro() {
		e1.agregarContratoPorHoras(cph1); //vencido
		e2.agregarContratoPorHoras(cph2); //no vencido
		r1 = e2.generarReciboDeSueldo();
		m.darDeAltaEmpleadoTest(e1);
		assertTrue(m.generarRecibosDeCobro().isEmpty());
		m.darDeAltaEmpleadoTest(e2);
		assertTrue(m.generarRecibosDeCobro().get(0).getCUIL() == r1.getCUIL());
	}
}
