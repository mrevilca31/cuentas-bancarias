package clases;

public class CuentaDeAhorros extends Cuenta {

	private double saldoReservado;

	public CuentaDeAhorros(double dinero) {
		super(dinero);
	}

	public CuentaDeAhorros() {
		super();
	}
	
	public double cantidadGuardada() {
		return this.saldoReservado;
	}

	private void incrementarSaldo(double dinero) {
		if ((dinero < 0) || (dinero > super.saldoDisponible())) {
			throw new Error("Cantidad incorrecta.");
		}
		this.saldoReservado += dinero;
	}

	private void disminuirSaldo(double dinero) {
		if (dinero < 0 || dinero > this.cantidadGuardada()) {
			throw new Error("Caintidad Incorrecta.");
		}
		this.saldoReservado -= dinero;
	}
	
	public void reservarSaldo(double dinero) {
		this.incrementarSaldo(dinero);
		super.retirarDinero(dinero);
	}
	
	public void reintegrarSaldo(double dinero) {
		this.disminuirSaldo(dinero);
		super.depositarDinero(dinero);
	}
}
