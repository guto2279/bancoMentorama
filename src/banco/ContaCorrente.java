package banco;

public class ContaCorrente extends Conta{
	
	private double chequeEspecial;
	


	public ContaCorrente(int numero, int agencia, String banco, double saldo, double chequeEspecial) {
		super(numero, agencia, banco, saldo);
		this.chequeEspecial = chequeEspecial;
	}


	@Override
	public String toString() {
		return "ContaCorrente [chequeEspecial=" + chequeEspecial + "]";
	}


	@Override
	public double getSaldo() {
		// TODO Auto-generated method stub
		return this.chequeEspecial + saldo;
	}
	
	public void sacarDinheiro(double sacar) {
		saldo -= sacar;
	}
	
	public void depositarDinheiro(double depositar) {
		saldo += depositar;
	}
	
	
	
}
