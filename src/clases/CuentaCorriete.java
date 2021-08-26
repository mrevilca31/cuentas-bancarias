package clases;

public class CuentaCorriete extends Cuenta {
	private double dineroExtra;

	public CuentaCorriete(double saldoInicial, double dineroExtra) {
		super(saldoInicial);
		this.definirExtra(dineroExtra);
	}

	public CuentaCorriete(double dineroExtra) {
		super();
		this.definirExtra(dineroExtra);
	}

	public double mostrarDineroExtra() {
		return this.dineroExtra;
	}

	private void definirExtra(double dinero) {
		if (dinero < 0) {
			throw new Error("Dinero no puede ser negativo.");
		}
		this.dineroExtra = dinero;
	}

	private void extraccionDeDinero(double dinero) {
		if (dinero <= super.saldoDisponible()) {
			super.retirarDinero(dinero);
		} else {
			double retirarDeExtra = dinero - super.saldoDisponible();
			double retirarDeSaldo = dinero - retirarDeExtra;
			super.retirarDinero(retirarDeSaldo);
			this.dineroExtra -= retirarDeExtra;
		}
	}

	@Override
	public void retirarDinero(double dinero) {
		if (dinero > this.dineroExtra + super.saldoDisponible()) {
			throw new Error("El saldo es insuficiente para realizar esta operacion.");
		}

		this.extraccionDeDinero(dinero);
	}
}
