package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CuentaDeAhorrosTest {
    CuentaDeAhorros cAhorro1;
    CuentaDeAhorros cAhorro2;
	
	
	@Before
	public void setUp() {
		cAhorro1 = new CuentaDeAhorros();  // saldo incial 0
		cAhorro2 = new CuentaDeAhorros(1000);  // saldo inicial 1000
	}
	
	@Test
	public void creacionDeCuentasTest() {
		assertNotNull(cAhorro1);
		assertNotNull(cAhorro2);
	}
	
	@Test
	public void verificacionDeSaldoInicialTest() {
		assertEquals(0, cAhorro1.saldoDisponible(), 0);
		assertEquals(1000, cAhorro2.saldoDisponible(), 0);
	}
	
	@Test
	public void guardarSaldoTest() {
		cAhorro1.depositarDinero(1000);
		cAhorro2.depositarDinero(1500);
		
		cAhorro1.reservarSaldo(1000);
		cAhorro2.reservarSaldo(500);
		
		assertEquals(1000, cAhorro1.cantidadGuardada(), 0); // saldo guardado 1000
		assertEquals(500, cAhorro2.cantidadGuardada(), 0); // saldo guardado 500
		
		assertEquals(0, cAhorro1.saldoDisponible(), 0); // saldo disponible 0
		assertEquals(2000, cAhorro2.saldoDisponible(), 0); // saldo disponible 2000
	}
	
	@Test
	public void recuperarSaldoTest() {
		cAhorro1.depositarDinero(1000);
		
		cAhorro1.reservarSaldo(1000);
		cAhorro2.reservarSaldo(500);
		
		cAhorro1.reintegrarSaldo(500);
		cAhorro2.reintegrarSaldo(500);
		
		assertEquals(500, cAhorro1.saldoDisponible(), 0); // saldo disponible 500
		assertEquals(1000, cAhorro2.saldoDisponible(), 0); // saldo disponible 1000
	}
	
	
	@Test
	public void transferirACuentaDeAhorro() {
		cAhorro2.trasferirDineroA(cAhorro1, 500);
		
		assertEquals(500.0, cAhorro1.saldoDisponible(),0);
		assertEquals(500.0, cAhorro2.saldoDisponible(),0);
	}
	
	
	@Test
	public void transferirACuentaCorriente() {
		CuentaCorriete cc = new CuentaCorriete(1000);
		cAhorro1.depositarDinero(1000);
		cAhorro1.trasferirDineroA(cc, 500);
		
		assertEquals(500.0, cAhorro1.saldoDisponible(),0);
		assertEquals(500.0, cc.saldoDisponible(),0);
	}
	
	
	// PRUEBAS PARA MANEJO DE ERRORES
	
	@Test(expected=Error.class)
	public void guardarDineroNegativo() {
		cAhorro2.reservarSaldo(-300);
	}
	
	@Test(expected=Error.class)
	public void recuperarDineroNegativo() {
		cAhorro1.reservarSaldo(300);
		cAhorro1.reintegrarSaldo(-300);
	}
	
	@Test(expected=Error.class)
	public void guardarDineroQueNoExiste() {
		cAhorro2.reservarSaldo(3000);
	}
	
	@Test(expected=Error.class)
	public void recuperarDineroQueNoExiste() {
		cAhorro1.reservarSaldo(100);
	}
}
