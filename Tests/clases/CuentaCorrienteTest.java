package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CuentaCorrienteTest {
	
	CuentaCorriete c1;
	CuentaCorriete c2;
	
	@Before
	public void setUp() {
		c1 = new CuentaCorriete(1000, 2000);
		c2 = new CuentaCorriete(1000);
	}

	@Test
	public void creacionDeCuentaTest() {
		assertNotNull(c1);
		assertNotNull(c2);
	}
	
	@Test
	public void retirarDineroTest() {
		c2.depositarDinero(500); // saldo disponible 500
		
		c2.retirarDinero(300);
		
		assertEquals(200, c2.saldoDisponible(), 0);
		assertEquals(1000, c2.mostrarDineroExtra(), 0);
		
		c2.retirarDinero(500);;
		
		assertEquals(0, c2.saldoDisponible(), 0);
		assertEquals(700, c2.mostrarDineroExtra(), 0);
		
		
		c2.retirarDinero(700);
		
		assertEquals(0, c2.saldoDisponible(), 0);
		assertEquals(0, c2.mostrarDineroExtra(), 0);
	}
	
	// PRUEBAS PARA MANEJO DE ERRORES
	
	@Test(expected=Error.class)
	public void crearCuentaConDineroNegativoTest() {
		CuentaCorriete c = new CuentaCorriete(-10);
	}
	
	@Test(expected=Error.class)
	public void retirarDineroNegativoTest() {
		CuentaCorriete c = new CuentaCorriete(100, 100);
		c.retirarDinero(-100);
	}
	
	@Test(expected=Error.class)
	public void retirarDineroQueNoExisteTest() {
		CuentaCorriete c = new CuentaCorriete(100);
		c.retirarDinero(200);
	}
	
}
