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
