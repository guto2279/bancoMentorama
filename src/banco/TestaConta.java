package banco;

import java.util.Scanner;

public class TestaConta {
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner (System.in);
		int opMenu;
		
		ContaCorrente cc1 = new ContaCorrente (22, 1, "Mentorama", 100.00, 1000.00);
		
		do {
			System.out.println("---------------------------------");
			System.out.println("         Banco Mentorama         ");
			System.out.println("---------------------------------");
			System.out.println("Operações: ");
			System.out.println("1 - Consultar Saldo ");
			System.out.println("2 - Depositar  ");
			System.out.println("3 - Sacar  ");
			System.out.println("4 - Conta Poupança  ");
			System.out.println("5 - Conta Salário  ");
			System.out.println("0 - Sair  ");
			opMenu = scanner.nextInt();
			
			switch (opMenu) {
			
			case 1: 
				System.out.println("Saldo em conta: " + cc1.getSaldo());
				break;
				
			case 2:
				System.out.println("Digite o valor que deseja depositar: ");
				double depositar = scanner.nextDouble();
				cc1.depositarDinheiro(depositar);
				
				System.out.println("O seu novo saldo é de: " + cc1.getSaldo());
				break;
				
			case 3: 
				System.out.println("Digite o valor que deseja sacar: ");
				double sacar = scanner.nextInt();
				cc1.sacarDinheiro(sacar);
				
				break;
				
			case 4:
				ContaPoupanca p1 = new ContaPoupanca(22, 1, "Mentorama", 100, 20, 0.2);	
				System.out.println("Digite o dia atual: ");
				int dia = scanner.nextInt();
				p1.medirTaxaDeJuros(dia);
				
				int opMenuPoupanca;
				
				do {
				System.out.println("---------------------------------");
				System.out.println("          Conta Poupança         ");
				System.out.println("---------------------------------");
				System.out.println("Operações: ");
				System.out.println("1 - Consultar Saldo ");
				System.out.println("2 - Transferir da conta corrente  ");
				System.out.println("3 - Transferir para conta corrente  ");
				System.out.println("4 - Taxa de Juros  ");
				System.out.println("0 - Sair  ");
				opMenuPoupanca = scanner.nextInt();
				
				switch (opMenuPoupanca) {
				case 1:
					System.out.println("Saldo em conta: " + p1.getSaldo());
					break;
					
				case 2: 
					int opSucessoTransferencia = 0;
					System.out.println("Seu saldo em conta correte: " + cc1.getSaldo());
					System.out.println("Digite o valor que deseja transferir: ");
					double transferir = scanner.nextDouble();
					
					do {
						
						if (cc1.getSaldo() < transferir) {
							System.out.println("Operação cancelada, saldo insuficiente! ");
							System.out.println("Saldo em conta: " + cc1.getSaldo());
							System.out.println("Digite o valor que deseja transferir: ");
							transferir = scanner.nextDouble();
						} else {
							p1.transferirDinheiro(transferir);
							cc1.sacarDinheiro(transferir);
							System.out.println("Operação realizada com sucesso!");
							System.out.println("Novo saldo em Conta Corrente: " + cc1.getSaldo());
							System.out.println("Novo saldo em Conta Poupança: " + p1.getSaldo());
							opSucessoTransferencia = 1;
						}
					
					}while (opSucessoTransferencia != 1);
					break;
					
				case 3: 
					int opSucessoTransferenciaCC = 0;
					System.out.println("Seu saldo em conta Poupança: " + p1.getSaldo());
					System.out.println("Digite o valor que deseja transferir: ");
					double transferirCC = scanner.nextDouble();
					
					do {
						
						if (p1.getSaldo() < transferirCC) {
							System.out.println("Operação cancelada, saldo insuficiente! ");
							System.out.println("Saldo em conta: " + p1.getSaldo());
							System.out.println("Digite o valor que deseja transferir: ");
							transferirCC = scanner.nextDouble();
						} else {
							p1.retirarDinheiro(transferirCC);
							cc1.depositarDinheiro(transferirCC);
							System.out.println("Operação realizada com sucesso!");
							System.out.println("Novo saldo em Conta Corrente: " + cc1.getSaldo());
							System.out.println("Novo saldo em Conta Poupança: " + p1.getSaldo());
							opSucessoTransferenciaCC = 1;
						}
					
					}while (opSucessoTransferenciaCC != 1);
					break;
					
				case 4:
					p1.mostrarTaxaJuros();
			
				}
				
				
				} while (opMenuPoupanca != 0);
				
				
			case 5:
				ContaSalario s1 = new ContaSalario(22, 1, "Mentorama",1200.00,5);
				int opContaSalario = 1;
				do {
					System.out.println("---------------------------------");
					System.out.println("          Conta Salário          ");
					System.out.println("---------------------------------");
					System.out.println("Operações: ");
					System.out.println("1 - Consultar Saldo ");
					System.out.println("2 - Sacar Dinheiro  ");
					System.out.println("0 - Sair  ");
					opContaSalario = scanner.nextInt();
					
					switch (opContaSalario) {
					case 1:
						System.out.println("Saldo em conta " + s1.getSaldo());
						break;
					
					case 2:
						int opSucessoTransferenciaCS = 0;
						System.out.println("Digite o valor que deseja sacar: ");
						double sacarCS = scanner.nextDouble();
						
						do {
							
							if (s1.getSaldo() < sacarCS) {
								System.out.println("Operação cancelada, saldo insuficiente! ");
								System.out.println("Saldo em conta: " + s1.getSaldo());
								System.out.println("Digite o valor que deseja transferir: ");
								sacarCS = scanner.nextDouble();
							} else {
								s1.saques(sacarCS);
								System.out.println("Saldo Atual: " + s1.getSaldo());
								System.out.println("Quantidade de saques restantes: " + s1.quantidadeSaques);
								opSucessoTransferenciaCS = 1;
								break;
							}
						
						}while (opSucessoTransferenciaCS != 1);
						break;
						
						
						
					}
					
				} while (opContaSalario !=0);
					
					break;
			}
		
		} while (opMenu != 0);
		
		
	
		

	}

}
