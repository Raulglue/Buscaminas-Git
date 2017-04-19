package control;

import javax.swing.JButton;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;

public class Varios {

	public Coordenada obtenerCoordenada(JButton boton) {

		String[] coordenada = boton.getName().split(",");

		int x = Integer.parseInt(coordenada[0]);
		int y = Integer.parseInt(coordenada[1]);

		return new Coordenada(x, y);

	}

	public Casilla[] convierteMatriz(Casilla[][] casillas) {
		int tamaño = casillas.length * casillas[0].length;
		Casilla[] arrayCasillas = new Casilla[tamaño];
		for (int i = 0; i < casillas[0].length; i++) {
			Casilla[] filaCoord = casillas[i];
			for (int j = 0; j < filaCoord.length; j++) {
				arrayCasillas[i * filaCoord.length + j] = casillas[i][j];
			}
		}
		return arrayCasillas;
	}

	public Casilla[] borraPosicion(Casilla[] casillas) {
		Casilla[] casillasNuevo = new Casilla[casillas.length - 1];
		int k = 0;
		for (int i = 0; i < casillas.length; i++) {
			if (!casillas[i].isMina()) {
				casillasNuevo[k] = casillas[i];
				k++;
			}
		}
		return casillasNuevo;
	}

	public Casilla[] quitaPosicion(Casilla[] casillas, JButton boton, int longitud) {
		Casilla[] casillasNuevo = new Casilla[casillas.length - 1];
		Coordenada coorBoton = new Varios().obtenerCoordenada(boton);
		int suma = (coorBoton.getX() * longitud) + (coorBoton.getY());
		int k = 0;
		for (int i = 0; i < casillas.length; i++) {
			if (i!=suma) {
				casillasNuevo[k] = casillas[i];
				k++;
			}
			
		}
		return casillasNuevo;
	}

	public Coordenada[] contiguas(int x, int y) {
		Coordenada[] coordenadas = { new Coordenada(x - 1, y - 1), new Coordenada(x - 1, y),
				new Coordenada(x - 1, y + 1), new Coordenada(x, y - 1), new Coordenada(x, y + 1),
				new Coordenada(x + 1, y - 1), new Coordenada(x + 1, y), new Coordenada(x + 1, y + 1) };
		return coordenadas;
	}

	public Coordenada[] validaContiguas(Coordenada[] coordenadas, int maximo) {
		int noValidas = 0;
		for (int i = 0; i < coordenadas.length; i++) {
			if (coordenadas[i].getX() < 0 || coordenadas[i].getY() < 0 || coordenadas[i].getX() > maximo
					|| coordenadas[i].getY() > maximo) {
				coordenadas[i].setX(-1);
				coordenadas[i].setY(-1);
				noValidas++;
			}
		}
		Coordenada[] validas = new Coordenada[coordenadas.length - noValidas];
		int iterador = 0;
		for (int i = 0; i < coordenadas.length; i++) {
			if (coordenadas[i].getX() == -1) {

			} else {
				validas[iterador] = coordenadas[i];
				iterador++;
			}
		}

		return validas;

	}

	public Coordenada[] validaRecursivas(Coordenada[] coordenadas, int maximo, Tablero tablero) {
		int noValidas = 0;
		for (int i = 0; i < coordenadas.length; i++) {
			if (coordenadas[i].getX() < 0 || coordenadas[i].getY() < 0 || coordenadas[i].getX() > maximo
					|| coordenadas[i].getY() > maximo || !tablero.getCasilla(coordenadas[i]).isVelada()) {
				coordenadas[i].setX(-1);
				coordenadas[i].setY(-1);
				noValidas++;
			}
		}
		Coordenada[] validas = new Coordenada[coordenadas.length - noValidas];
		int iterador = 0;
		for (int i = 0; i < coordenadas.length; i++) {
			if (coordenadas[i].getX() == -1) {

			} else {
				validas[iterador] = coordenadas[i];
				iterador++;
			}
		}

		return validas;

	}

	public int intAt(String nombre, int posicion) {
		return Integer.parseInt(nombre.substring(posicion, posicion + 1));
	}
}
