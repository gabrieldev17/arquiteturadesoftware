
public class ArmaFactory {
	
	Arma arma1 = new Arma("Machado Simples", 500, 12, 12);
	Arma arma2 = new Arma("Machado duplo", 1000, 15, 15);
	Arma arma3 = new Arma("Espada curta", 800, 13, 13);
	Arma arma4 = new Arma("Espada longa", 1100, 22, 20);
	Arma arma5 = new Arma("Arco longo", 600, 8, 9);
	Arma arma6 = new Arma("Espada flamejante", 1800, 20, 26);
	Arma arma7 = new Arma("Machado duplo pesado", 1500, 33, 29);
	Arma arma8 = new Arma("Escudo de madeira", 200, 4, 12);
	Arma arma9 = new Arma("Escudo de ferro", 400, 10, 20);
	Arma arma10 = new Arma("Escudo Milenar do rei Brasz", 1500, 15, 31);
		
	Loja loja = new Loja();
	
	ArmaFactory() {
		loja.arma[0] = arma1;
		loja.arma[1] = arma2;
		loja.arma[2] = arma3;
		loja.arma[3] = arma4;
		loja.arma[4] = arma5;
		loja.arma[5] = arma6;
		loja.arma[6] = arma7;
		loja.arma[7] = arma8;
		loja.arma[8] = arma9;
		loja.arma[9] = arma10;
	}
	
	

}
