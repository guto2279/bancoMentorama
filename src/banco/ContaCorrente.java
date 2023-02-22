package banco;

import java.util.Scanner;

public class ContaCorrente extends Conta{
	
	private double chequeEspecial;
	Scanner scanner = new Scanner(System.in);
	


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
		if (sacar <= this.saldo) {
			this.saldo -= sacar;
		}else if(sacar <= this.getSaldo()) {
			System.out.println("Operação cancelada, saldo insuficiente! ");
			System.out.println("Deseja retirar do cheque especial? (S/N) ");
			String escolha = scanner.next();
			if (escolha.equalsIgnoreCase("S")) {
				saldo  += chequeEspecial;
				saldo -= sacar;
				chequeEspecial = saldo;
				saldo = 0;
				System.out.println("Operação realizada com sucesso!");
				System.out.println("Saldo disponivel: " + saldo);
				System.out.println("Saldo cheque especial: " + chequeEspecial);
			} 
		}else {
			System.out.println("Operação cancelada, saldo insuficiente! ");
			System.out.println("Saldo disponivel " + getSaldo());
		}
		
	}
	
	public void depositarDinheiro(double depositar) {
		saldo += depositar;
	}
	
	
	
}
