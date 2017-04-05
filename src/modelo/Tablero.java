package modelo;

import javax.swing.JButton;

import control.Varios;

public class Tablero {
	private Casilla[][] casillas;
	boolean minasColocadas= false;
	int minas = 20;
	boolean ganador = false;
	boolean perdedor = false;

	public int length() {
		return casillas.length;
	}

	public boolean isGanador() {
		return ganador;
	}

	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}

	public boolean isPerdedor() {
		return perdedor;
	}

	public void setPerdedor(boolean perdedor) {
		this.perdedor = perdedor;
	}

	public Tablero(int filas, int columnas) {
		super();
		generarTablero(filas, columnas);
	}

	public Tablero(int cuadrada) {
		this(cuadrada, cuadrada);
	}

	public void colocarMinas(Tablero tablero) {
		int contador = 0;
		int x, y;
		do {
			x = (int) Math.floor(Math.random() * tablero.length());
			y = (int) Math.floor(Math.random() * tablero.length());
			if(!tablero.getCasilla(new Coordenada(x, y)).isMina()){
				tablero.getCasilla(new Coordenada(x, y)).setMina(true);
				contador++;}
		} while (contador < minas);
	}

	private void generarTablero(int filas, int columnas) {
		casillas = new Casilla[filas][columnas];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = new Casilla();
			}
		}
		
	}

	public void contadorMinas(Tablero tablero) {

		for (int i = 0; i < tablero.length(); i++) {
			for (int j = 0; j < tablero.length(); j++) {
				if (tablero.getCasilla(new Coordenada(i, j)).isMina()) {
					Coordenada coordenada[] = new Varios().contiguas(i, j);
					Coordenada validas[] = new Varios().validaContiguas(coordenada, casillas.length - 1);
					for (int k = 0; k < validas.length; k++) {
						if (!tablero.getCasilla(new Coordenada(validas[k].getX(), validas[k].getY())).isMina()) {
							tablero.getCasilla(new Coordenada(validas[k].getX(), validas[k].getY())).setMinasCercanas();
						}
					}
				}
			}
		}

	}

	public boolean isMinasColocadas() {
		return minasColocadas;
	}

	public void setMinasColocadas(boolean minasColocadas) {
		this.minasColocadas = minasColocadas;
	}

	public void contadorBanderas(Tablero tablero, JButton boton) {
		int bandera = 0;
		Coordenada botonActual = new Varios().obtenerCoordenada(boton);
		Coordenada coordenada[] = new Varios().contiguas(botonActual.getX(), botonActual.getY());
		Coordenada validas[] = new Varios().validaContiguas(coordenada, casillas.length - 1);
		for (int k = 0; k < validas.length; k++) {
			if (tablero.getCasilla(validas[k]).isMarcada()) {
				bandera++;
			}
		}
		tablero.getCasilla(botonActual).setBanderaCercanas(bandera);

	}

	private Casilla[][] getCasillas() {
		return casillas;
	}

	private void setCasillas(Casilla[][] casillas) {
		this.casillas = casillas;
	}

	public Casilla getCasilla(Coordenada coordenada) {
		return casillas[coordenada.getX()][coordenada.getY()];
	}

}
