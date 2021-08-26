package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CuentaTest {
	
	Cuenta c;
	
	@Before
	public void setUp() {
		c = new Cuenta();
	}
	
	@Test
	public void creacionDeCuentaConParametro() {
		Cuenta c2 = new Cuenta(3100.07);
		assertNotNull(c2);
		assertEquals(3100.07, c2.saldoDisponible(),0);
	}
	
	@Test
	public void creacionDeCuentaTest() {
		assertNotNull(c);
		assertEquals(0, c.saldoDisponible(),0);
	}
	
	@Test
	public void depositoDeDineroTest() {
		c.depositarDinero(100.50);
		assertEquals(100.50, c.saldoDisponible(),0);
	}
	
	@Test
	public void extraerDineroTest() {
		c.depositarDinero(100.00);
		c.retirarDinero(2.50);
		assertEquals(97.50, c.saldoDisponible(),0);
	}
	
	@Test
	public void transferenciaTest() {
		Cuenta c2 = new Cuenta();
		
		c.depositarDinero(1000);
		c.trasferirDineroA(c2, 250);
		
		assertEquals(750, c.saldoDisponible(),0);
		assertEquals(250, c2.saldoDisponible(),0);
	}
	
	
	// Pruebas para verificar el manejo de errores
	
	@Test(expected=Error.class)
	public void saldoInsuficienteTest() {
		c.retirarDinero(1.25);
	}
	
	@Test(expected=Error.class)
	public void depositoDineroNegativoTest() {
		c.depositarDinero(-1000);
	}
	
	@Test(expected=Error.class)
	public void extraccionDineroNegativoTest() {
		c.depositarDinero(1000);
		c.retirarDinero(-10.5);
	}
	
	@Test(expected=Error.class)
	public void saldoInsuficienteParaTransferenciaTest() {
		Cuenta c2 = new Cuenta();
		
		c.depositarDinero(100);
		c.trasferirDineroA(c2,1000);
	}
}
