package banco;

public class ContaSalario extends Conta{
	
	int quantidadeSaques;
	
	
	
	

	public ContaSalario(int numero, int agencia, String banco, double saldo, int quantidadeSaques) {
		super(numero, agencia, banco, saldo);
		this.quantidadeSaques = quantidadeSaques;
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public double getSaldo() {
		// TODO Auto-generated method stub
		return this.saldo;
	}
	
	public void saques(double saque) {
		if (this.quantidadeSaques > 0){
			this.saldo -= saque;
			this.quantidadeSaques -= 1;
		}else {
			System.out.println("Sua quantidade de saques excedeu o limite, operação cancelada!");
		}
		
		
	}
	
	
	
	
	

	
	
	
	
}
