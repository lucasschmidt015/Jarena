/**
 * Um exemplo de agente que anda aleatoriamente na arena. Esse agente pode ser usado como base
 * para a criação de um agente mais esperto. Para mais informações sobre métodos que podem
 * ser utilizados, veja a classe Agente.java.
 * 
 * Fernando Bevilacqua <fernando.bevilacqua@uffs.edu.br>
 */

package br.uffs.cc.jarena;

public class AgenteDummy extends Agente
{
	private int ContaEnergia;
	public AgenteDummy(Integer x, Integer y, Integer energia) {
		super(x, y, energia);
		setDirecao(geraDirecaoAleatoria());
	}
	
	public void pensa() {
		if (!podeMoverPara(getDirecao())) {
			
			setDirecao(geraDirecaoAleatoria());
		}

		/*if (getEnergia() < 200)
		{
			para();
		}*/

	}
	
	public void recebendoEnergia()
	{
		if(ContaEnergia < getEnergia())
			ContaEnergia = getEnergia();
		else
			setDirecao(geraDirecaoAleatoria());
	}

	public void recebeuEnergia() {
		para();
		enviaMensagem(getX() + "," + getY());
		recebendoEnergia();
	}

	public void tomouDano(int energiaRestanteInimigo) {
		setDirecao(geraDirecaoAleatoria());
	}
	
	public void ganhouCombate() {
		//Pensar em algo
	}
	
	public void recebeuMensagem(String msg) {
		int[] posicoes = converter(msg);	
		int diferencaX,diferencaY;
		
		diferencaX = posicoes[0] - getX();
		diferencaY = posicoes[1] - getY();
		if(diferencaX<0){
			diferencaX = diferencaX * (-1);
		}
		if(diferencaY < 0){
			diferencaY = diferencaY * (-1);
		}
		if(diferencaX > diferencaY){
			if(posicoes[0] > getX()){
				setDirecao(DIREITA);
			}else if(posicoes[0] < getX()){
				setDirecao(ESQUERDA);
			}
		}else{
			if(posicoes[1] > getY()){
				setDirecao(BAIXO);
			}else{
				setDirecao(CIMA);
			}
		}
	}
	
	
	public String getEquipe() {
		return "Equipe_Lucas/Geovane";
	}

	private int[] converter(String positions) {
		String[] vet = positions.split(",");
		int[] XY = new int [2];

		for (int i = 0; i < vet.length; i++){
			XY[i] = Integer.parseInt(vet[i]);
		}

		return XY;
	}
}
