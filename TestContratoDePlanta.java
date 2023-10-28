package Objetos1.Ejercicio_18;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestContratoDePlanta {
	ContratoDePlanta c1;
	ContratoPorHoras cph1;
	ContratoPorHoras cph2;
	ReciboDeSueldo r1;
	ReciboDeSueldo r2;
	ReciboDeSueldo r3;
	Empleado e1;
	Empleado e2;
	Empleado e3;
	
	@BeforeEach
	public void setUp() {
		e1 = new Empleado("pepe", "lopez", 111, LocalDate.of(2023 ,1 ,9),true, false);
		e2 = new Empleado("pepe2", "lopez2", 222, LocalDate.of(2011 ,1 ,9),false, false);
		e3 = new Empleado("pepe3", "lopez3", 333, LocalDate.of(2000 ,1 ,9),false, true);
		cph1 = new ContratoPorHoras(e1, LocalDate.of(2000 ,1 ,9), LocalDate.of(2024 ,1 ,9), 10, 10);
		cph2 = new ContratoPorHoras(e2, LocalDate.of(2000 ,1 ,9), LocalDate.of(2023 ,10 ,28), 10, 10);
	}
	
	@Test
	public void testContratosVencidos(){
		e1.agregarContratoPorHoras(cph1);
		assertFalse(e1.contratoVencido());
		e2.agregarContratoPorHoras(cph2);
		assertTrue(e2.contratoVencido());
		e3.agregarContratoDePlanta(LocalDate.of(2000 ,1 ,9), 10, 10, 10);
		assertFalse(e3.contratoVencido());
	}
	
	@Test
	public void testGenerarRecibos(){
		e1.agregarContratoPorHoras(cph1);
		e2.agregarContratoPorHoras(cph1);
		e3.agregarContratoDePlanta(LocalDate.of(2000 ,1 ,9), 10, 10, 10);
		r1 = e1.generarReciboDeSueldo();
		r2 = e2.generarReciboDeSueldo();
		r3 = e3.generarReciboDeSueldo();
		
		assertEquals(100,r1.getMonto());
		assertEquals(100,r2.getMonto());
		assertEquals(20,r3.getMonto());
	}
	
	@Test
	public void testVigencia() {
		assertFalse(cph2.isVigente());
		assertTrue(cph2.isVencido());
	}
}
