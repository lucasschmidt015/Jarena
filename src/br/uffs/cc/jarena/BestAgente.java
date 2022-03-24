package br.uffs.cc.jarena;

public class BestAgente extends Agente{
    public BestAgente(Integer x, Integer y, Integer energia) {
		super(x, y, energia);
		setDirecao(geraDirecaoAleatoria());
	}
	
	public void pensa() {
		if (!podeMoverPara(getDirecao())) {
			setDirecao(geraDirecaoAleatoria());
		}
		if (getEnergia() < 200)
		{
			para();
			if(getEnergia() >= 210){
				setDirecao(geraDirecaoAleatoria());
			}
		}
	}

	public void recebeuEnergia() {
		para();
		enviaMensagem(getX() + "," + getY());
	}

	public void tomouDano(int energiaRestanteInimigo) {
		if (energiaRestanteInimigo < getEnergia())
		{
			para();
			enviaMensagem(getX() + "," + getY());
		}
		else
		{
			setDirecao(geraDirecaoAleatoria());
		}
	}
	
	public void ganhouCombate() {
		setDirecao(geraDirecaoAleatoria());
	}
	
	public void recebeuMensagem(String msg) {
		int[] posicoes = converter(msg);	
		int distanciaX,distanciaY;
		
		distanciaX = posicoes[0] - getX();
		distanciaY = posicoes[1] - getY();
		if(distanciaX < 0){
			distanciaX = distanciaX * (-1);
		}
		if(distanciaY < 0){
			distanciaY = distanciaY * (-1);
		}
		if(distanciaX > distanciaY){
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
	
	
	
	private int[] converter(String positions) {
		String[] vet = positions.split(",");
		int[] XY = new int [2];
		
		for (int i = 0; i < vet.length; i++){
			XY[i] = Integer.parseInt(vet[i]);
		}

		return XY;
	}

	public String getEquipe() {
		return "Equipe_Lucas/Geovane";
	}
}
