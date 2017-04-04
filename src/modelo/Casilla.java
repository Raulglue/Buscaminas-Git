package modelo;

public class Casilla {
	private boolean velada=true;
	private boolean marcada=false;
	private boolean Mina=false;
	private int banderaCercanas=0;
	private int minasCercanas=0;
	
	public int getBanderaCercanas() {
		return banderaCercanas;
	}
	public void setBanderaCercanas(int banderaCercanas) {
		this.banderaCercanas = banderaCercanas;
	}
	
	public boolean isMina() {
		return Mina;
	}
	public void setMina(boolean esMina) {
		this.Mina = esMina;
	}
	
	
	public int getMinasCercanas() {
		return minasCercanas;
	}
	public void setMinasCercanas() {
		this.minasCercanas +=1;
	}
	public boolean isVelada() {
		return velada;
	}
	public void setVelada(boolean velada) {
		this.velada = velada;
	}
	public boolean isMarcada() {
		return marcada;
	}
	public void setMarcada(boolean marcada) {
		this.marcada = marcada;
	}
	
}
