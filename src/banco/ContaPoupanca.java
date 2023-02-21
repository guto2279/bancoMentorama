package banco;

public class ContaPoupanca extends Conta{
	
	private int diaAniverssario;
	private double taxaJuros;
	
	
	
	public ContaPoupanca(int numero, int agencia, String banco, double saldo, int diaAniverssario, double taxaJuros) {
		super(numero, agencia, banco, saldo);
		this.diaAniverssario = diaAniverssario;
		this.taxaJuros = taxaJuros;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getSaldo() {
		// TODO Auto-generated method stub
		if (this.saldo <= 0) {
			return 0;
		}else {
			return this.saldo + this.taxaJuros * this.saldo;
		}
			
		
	}
	
	public void transferirDinheiro(double transferir) {
		this.saldo += transferir;
	}
	
	public void retirarDinheiro(double retirar) {
		this.saldo -= retirar;
	}
	
	public void mostrarTaxaJuros() {
		System.out.println ("Taxa de Juros atual: " + this.taxaJuros + "%");
	}
	
	public void medirTaxaDeJuros(int dia) {
		if (dia == this.diaAniverssario) {
			this.taxaJuros = 1.5;
		}
	}
	
	
}
