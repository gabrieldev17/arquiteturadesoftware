
import java.util.Random;

public class Beowulf {
	Arma arma[] = new Arma[3];
	String nome;
	int dinheiro;
	int healthPoints;
	int pesoMaximo;
	int defesa;
	double esquiva;
	int pesoatual;
	
	Random aleatorio = new Random();
	float valor = aleatorio.nextFloat();

	int cont=0;
	
	static private Beowulf instance = null;
	private Beowulf() {
	
	}
	static Beowulf getInstance() {
		if(instance == null)
			instance = new Beowulf();
		return instance;
	}
	
	
	public void addarma(Arma arma) {
		if (cont == 3) {
			System.out.println("Você adquiriu o número máximo de armas");
		} else {
			if (arma.nome.contains("Escudo")) {
				this.arma[cont] = arma;
				this.dinheiro -= arma.valor;
				this.pesoatual += arma.peso;
				this.defesa += arma.dano;
				cont++;
				System.out.println(cont);
			} else {
				this.arma[cont] = arma;
				this.dinheiro -= arma.valor;
				this.pesoatual += arma.peso;
				cont++;
				System.out.println(cont);
			}
		}
	}

	public void delarma(Arma arma) {
		if (cont == 0) {
			System.out.println("O jogador não possui armas para vender");
		} else {
			this.arma[cont] = null;
			this.dinheiro += arma.valor / 2;
			this.pesoatual -= arma.peso;
		}
	}

	public void StrategyDano(Beowulf B, Dragão D, int z) {
		if ((D.esquiva_natural / 200) < valor) {
			double d = B.arma[z-1].dano - (D.armadura / 2);
			System.out.println("O dano foi de: " + d);
			D.healthPoints -= d;
			System.out.println("O dragão tem "+D.healthPoints+" de vida");
		} else {
			System.out.println("O dragão esquivou");
		}
	}
}
