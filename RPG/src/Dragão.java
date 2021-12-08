
import java.util.Random;
public class Drag�o {
	int healthPoints;
	double esquiva_natural;
	int bolaFogo;
	int armadura;
	
	Random aleatorio = new Random();
	float valor = aleatorio.nextFloat();
	
	Drag�o(int healthPoints, double esquiva_natural, int bolaFogo, int armadura){
		this.healthPoints = healthPoints;
		this.esquiva_natural = esquiva_natural;
		this.bolaFogo = bolaFogo;
		this.armadura = armadura;	
	}
	
	public void StrategyDano(Beowulf B) {
		if((20-B.pesoatual)/200 < valor) {
			double d = (this.bolaFogo - B.defesa)/2;
			System.out.println("O dano sofrido pelo her�i foi de: " + d);
			B.healthPoints -= d;
			System.out.println("A vida do h�roi: "+B.healthPoints);
		} else {
			System.out.println("O jogador esquivou da bola de fogo");
		}
	}
}
