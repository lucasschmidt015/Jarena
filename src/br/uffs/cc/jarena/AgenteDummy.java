/**
 * Um exemplo de agente que anda aleatoriamente na arena. Esse agente pode ser usado como base
 * para a criação de um agente mais esperto. Para mais informações sobre métodos que podem
 * ser utilizados, veja a classe Agente.java.
 * 
 * Fernando Bevilacqua <fernando.bevilacqua@uffs.edu.br>
 */

package br.uffs.cc.jarena;

import java.sql.Time;

public class AgenteDummy extends Agente
{
	public AgenteDummy(Integer x, Integer y, Integer energia) {
		super(x, y, energia);
		setDirecao(geraDirecaoAleatoria());
	}
	
	public void pensa() {
		// Se não conseguimos nos mover para a direção atual, quer dizer
		// que chegamos no final do mapa ou existe algo bloqueando nosso
		// caminho.
		if(!podeMoverPara(getDirecao())) {
			// Como não conseguimos nos mover, vamos escolher uma direção
			// nova.
			
			setDirecao(geraDirecaoAleatoria());
		}
		
		// Se o agente conseguie se dividir (tem energia) e se o total de energia
		// do agente é maior que 400, nos dividimos. O agente filho terá a metade
		// da nossa energia atual.
		
		if(podeDividir() && getEnergia() >= 1250) {
			divide();
		}
	}
	
	public void recebeuEnergia() {
		// Invocado sempre que o agente recebe energia.
		para();
		if(getEnergia()<=500)
		{
			enviaMensagem(String.valueOf(getX()) +" "+ String.valueOf(getY()));
			setDirecao(geraDirecaoAleatoria());
			if(getEnergia() >= 700)
			{
				setDirecao(geraDirecaoAleatoria());
			}
		}
	}

	public void tomouDano(int energiaRestanteInimigo) {
		// Invocado quando o agente está na mesma posição que um agente inimigo
		// e eles estão batalhando (ambos tomam dano).
		if(energiaRestanteInimigo < getEnergia())
		{
			para();			
		}
		else
		{
			setDirecao(geraDirecaoAleatoria());
		}
	}
	
	public void ganhouCombate() {
		// Invocado se estamos batalhando e nosso inimigo morreu.
	}
	
	public void recebeuMensagem(String msg) {
		// Invocado sempre que um agente aliado próximo envia uma mensagem.
		int[] posicoes = converter(msg);
	}
	
	public String getEquipe() {
		// Definimos que o nome da equipe do agente é "Fernando".
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
