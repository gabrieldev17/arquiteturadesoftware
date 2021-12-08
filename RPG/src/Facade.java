import java.util.Scanner;

public class Facade {

	public static void main(String[] args) {
		
		Beowulf Gabriel = Beowulf.getInstance();
		Beowulf Evelyn = Beowulf.getInstance();
		Drag�o vermelho = new Drag�o(100, 25, 20, 80);
		
		ArmaFactory Loja = new ArmaFactory();

		Gabriel.addarma(Loja.arma1);
		Gabriel.addarma(Loja.arma8);
		Gabriel.defesa = 12;
		Gabriel.pesoMaximo = 23;
		Gabriel.dinheiro = 1500;
		Gabriel.healthPoints = 50;

		Scanner x = new Scanner(System.in);
		int atual = 0;
		int menu_principal=0;
		
		while (Gabriel.healthPoints > 0 && menu_principal != 3) {
			System.out.println("1 - Ir � Loja\n2 - Ir � batalha\n3 - Desistir de suas aventuras");
			menu_principal = x.nextInt();
			if (menu_principal == 1) {
				int num2 = 0;
				while (num2 != 3) {
					System.out.println("Bem vindo � loja "+Gabriel+". Voc� deseja:");
					System.out.println("Bem vindo � loja "+Evelyn+". Voc� deseja:");
					System.out.println("1 - Comprar itens\n2 - Vender itens\n3 - Sair da loja");
					num2 = x.nextInt();
					if (num2 == 1) {
						System.out.println(
								"Qual iten deseja comprar? \r\n1- Machado simples, 500 pe�as de ouro, 12 libras, 12 de dano.\r\n"
										+ "2- Machado duplo, 1000 pe�as de ouro, 15 libras, 15 de dano.\r\n"
										+ "3- Espada curta, 800 pe�as de ouro, 13 libras, 13 de dano.\r\n"
										+ "4- Espada longa, 1100 pe�as de ouro, 22 libras, 20 de dano.\r\n"
										+ "5- Arco longo, 600 pe�as de ouro, 8 libras, 9 de dano.\r\n"
										+ "6- Espada flamejante, 1800 pe�as de ouro, 20 libras, 26 de dano.\r\n"
										+ "7- Machado duplo pesado, 1500 pe�as de ouro, 33 libras, 29 de dano.\r\n"
										+ "7- Escudo de madeira, 200 pe�as de ouro, 4 libras, 12 de defesa.\r\n"
										+ "9- Escudo de ferro, 400 pe�as de ouro, 10 libras, 20 de defesa.\r\n"
										+ "10- Escudo Milenar do rei Brasz, 1500 pe�as de ouro, 15 libras, 31 de defesa.");

						int n = x.nextInt();
						if (n == 1) {
							Loja.loja.Comprar(Gabriel, Loja.arma1);
						} else if (n == 2) {
							Loja.loja.Comprar(Gabriel, Loja.arma2);
						} else if (n == 3) {
							Loja.loja.Comprar(Gabriel, Loja.arma3);
						} else if (n == 4) {
							Loja.loja.Comprar(Gabriel, Loja.arma4);
						} else if (n == 5) {
							Loja.loja.Comprar(Gabriel, Loja.arma5);
						} else if (n == 6) {
							Loja.loja.Comprar(Gabriel, Loja.arma6);
						} else if (n == 7) {
							Loja.loja.Comprar(Gabriel, Loja.arma7);
						} else if (n == 8) {
							Loja.loja.Comprar(Gabriel, Loja.arma8);
						} else if (n == 9) {
							Loja.loja.Comprar(Gabriel, Loja.arma9);
						} else if (n == 10) {
							Loja.loja.Comprar(Gabriel, Loja.arma10);
						} else {
							System.out.println("Esse n�mero n�o consta nas op��es, digite novamente");
						}
					} else if (num2 == 2) {
						System.out.println("Qual arma do seu invent�rio voc� ir� vender?");
						if (Loja.loja.cont > 0) {
							int cont = 0;
							while (cont < Loja.loja.cont) {
								System.out.println(cont + 1 + "- " + Gabriel.arma[cont].nome);
								cont++;
							}
							int n = x.nextInt();
							Loja.loja.Vender(Gabriel, n);
						} else {
							System.out.println("Voc� n�o possui armas para vender");
						}

					}
				}
			} else if (menu_principal == 2) {
				System.out.println("1 - Ataque\n2 - Trocar arma\n3 - Fugir da batalha");
				int a = x.nextInt();
				if (a == 2) {
					if (Loja.loja.cont > 0) {
						int cont = 0;
						System.out.println("Suas armas s�o:");
						while (cont < Loja.loja.cont) {
							System.out.println(cont + 1 + "- " + Gabriel.arma[cont].nome);
							cont++;
						}
						System.out.println("Qual voc� quer trocar");
						atual = x.nextInt();
					} else {
						System.out.println("Voc� n�o possui armas para atacar");
					}
					int at = x.nextInt();
					atual = at;
				} else if (a == 1) {
					if (atual == 0) {
						if (Loja.loja.cont > 0) {
							int cont = 0;
							System.out.println("Suas armas s�o:");
							while (cont < Loja.loja.cont) {
								System.out.println(cont + 1 + "- " + Gabriel.arma[cont].nome);
								cont++;
							}
							System.out.println("Qual voc� quer atacar");
							atual = x.nextInt();
						} else {
							System.out.println("Voc� n�o possui armas para atacar");
						}
						Gabriel.StrategyDano(Gabriel, vermelho, atual);
						vermelho.StrategyDano(Gabriel);
					} else {
						Gabriel.StrategyDano(Gabriel, vermelho, atual);
						vermelho.StrategyDano(Gabriel);
					}
				}
			} else if (menu_principal > 3 || menu_principal < 1) {
				System.out.println("Essas op��es n�o constam no menu principal, tente novamente");
			}
			if(vermelho.healthPoints <= 0) {
				System.out.println("O her�i, ap�s batalhar bravamente derrota o drag�o e ganha 1,000 em ouro");
				Gabriel.dinheiro += 1000;
				vermelho.healthPoints = 100;
			}
		}
		if(Gabriel.healthPoints <= 0) {
			System.out.println("O her�i, ap�s batalhar bravamente morreu como um verdadeiro guerreiro");
		}
		if (menu_principal == 3) {
			System.out.println("O her�i decide n�o mais lutar com o drag�o, e derrotado volta para a sua vila, como um verdadeiro perdedor.");
		}
		
	}
}

