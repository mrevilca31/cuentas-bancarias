package clases;

abstract class Cuenta {
	private double saldo;
	private Transaccion[] registroDeTransacciones;

	protected Cuenta(double dinero) {
		this.depositarDinero(dinero);
	}

	protected Cuenta() {
		this(0.0);
	}

	public double saldoDisponible() {
		return this.saldo;
	}

	public void depositarDinero(double dinero) {
		if (dinero < 0) {
			throw new Error("Cantidad ingresada invalida.");
		}
		this.saldo += dinero;
	}

	private void disminuirSaldo(double dinero) {
		if (dinero < 0) {
			throw new Error("Cantidad ingresada invalida.");
		}
		this.saldo -= dinero;
	}

	public void retirarDinero(double dinero) {
		if (dinero > this.saldoDisponible()) {
			throw new Error("Saldo insuficiente para realizar esta operacion.");
		}
		this.disminuirSaldo(dinero);
	}

	public void trasferirDineroA(Cuenta otraCuenta, double dinero) {
		this.retirarDinero(dinero);
		otraCuenta.depositarDinero(dinero);
	}
}
