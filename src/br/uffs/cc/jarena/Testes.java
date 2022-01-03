package br.uffs.cc.jarena;

public class Testes extends Agente
{
    private boolean energizado = false;
	public Testes(Integer x, Integer y, Integer energia) {
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
        if(isParado()){
            if(energizado){
                para();
            }
            else{
                setDirecao(geraDirecaoAleatoria());
            }
        }
		
		// Se o agente conseguie se dividir (tem energia) e se o total de energia
		// do agente é maior que 400, nos dividimos. O agente filho terá a metade
		// da nossa energia atual.
		/*if(podeDividir() && getEnergia() >= 800) {
			divide();
		}*/
        
	}
	
	public void recebeuEnergia() {
		// Invocado sempre que o agente recebe energia.
        enviaMensagem("EnergiaDaBoa");
        this.energizado = true;
        para();
        recebendoEnergia();
	}
	
	public void tomouDano(int energiaRestanteInimigo) {
		// Invocado quando o agente está na mesma posição que um agente inimigo
		// e eles estão batalhando (ambos tomam dano).
        enviaMensagem("Help-me");
	}
	
	public void ganhouCombate() {
		// Invocado se estamos batalhando e nosso inimigo morreu.
	}
	
	public void recebeuMensagem(String msg) {
		// Invocado sempre que um agente aliado próximo envia uma mensagem.
        if(msg == "EnergiaDaBoa"){
            //faz logica para mover os proximos para perto do aliado que esta recebendo energia
        }
        if(msg == "Help-me"){
            //logica para atrair aliados proximos para ajudar na batalha
        }
	}
	
	public String getEquipe() {
		// Definimos que o nome da equipe do agente é "Fernando".
		return "Schmidt";
	}
    private boolean recebendoEnergia(){
        this.energizado = false;
        return this.energizado;
    }
}
