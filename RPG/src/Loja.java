public class Loja {
	
	
		Arma arma[] = new Arma[10];
		
	
	
	Loja() {

	}

	int cont = 2;

	public void Comprar(Beowulf B, Arma arma) {
		if (arma.valor < B.dinheiro) {
			if (cont == 3) {
				System.out.println("Você adquiriu o número máximo de armas");
			} else {
				if ((B.pesoatual + arma.peso) < B.pesoMaximo) {
					if (arma.nome.contains("Escudo")) {
						B.arma[cont] = arma;
						B.dinheiro -= arma.valor;
						B.pesoatual += arma.peso;
						B.defesa += arma.dano;
						cont++;
						System.out.println("Dinheiro atual: " + B.dinheiro);
						System.out.println("Peso atual: " + B.pesoatual);
					} else {
						B.arma[cont] = arma;
						B.dinheiro -= arma.valor;
						B.pesoatual += arma.peso;
						cont++;
						System.out.println("Dinheiro atual: " + B.dinheiro);
						System.out.println("Peso atual: " + B.pesoatual);
					}
				} else {
					System.out.println("Você ultrapassou o limite de peso que pode carregar");
				}
			}
		} else {
			System.out.println("Você não tem dinheiro suficiente");
		}
	}

	public void Vender(Beowulf B, int n) {
		if (this.cont == 0) {
			System.out.println("O jogador não possui armas para vender");
		} else {
			if (n<3) {
				B.dinheiro += (B.arma[n - 1].valor / 2);
				B.pesoatual -= B.arma[n - 1].peso;
				System.out.println("Dinheiro atual: " + B.dinheiro);
				System.out.println("Peso atual: " + B.pesoatual);
				B.arma[n - 1] = null;
				B.arma[n-1] = B.arma[n];
				B.arma[n] = null;
				cont--;
			} else {
				B.dinheiro += (B.arma[n - 1].valor / 2);
				B.pesoatual -= B.arma[n - 1].peso;
				System.out.println("Dinheiro atual: " + B.dinheiro);
				System.out.println("Peso atual: " + B.pesoatual);
				B.arma[n - 1] = null;
				cont--;
			}
		}
	}

}
