package control;

import java.awt.Color;

import javax.swing.JButton;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;

public class Desvelador {
	Color color0 = new Color(255, 255, 255);
	Color color1 = new Color(21, 163, 201);
	Color color2 = new Color(21, 114, 201);
	Color color3 = new Color(149, 21, 201);
	Color color4 = new Color(201, 21, 193);
	Color color5 = new Color(201, 21, 149);
	Color color6 = new Color(201, 21, 130);
	Color color7 = new Color(201, 21, 89);
	Color color8 = new Color(201, 21, 54);
	Color mina = new Color(202, 21, 21);

	public void muestraCasillas(JButton boton,  Tablero tablero) {
		Coordenada coordenada = new Varios().obtenerCoordenada(boton);
		Casilla casilla = tablero.getCasilla(coordenada);
		if (casilla.isVelada()) {
			casilla.setVelada(false);
			boton.setOpaque(true);
			switch (casilla.getMinasCercanas()) {
			case 0:
				boton.setText(" ");
				boton.setBackground(color0);

				break;
			case 1:
				boton.setBackground(color1);
				break;
			case 2:
				boton.setBackground(color2);
				break;
			case 3:
				boton.setBackground(color3);
				break;
			case 4:
				boton.setBackground(color4);
				break;
			case 5:
				boton.setBackground(color5);
				break;
			case 6:
				boton.setBackground(color6);
				break;
			case 7:
				boton.setBackground(color7);
				break;
			case 8:
				boton.setBackground(color8);

				break;

			default:
				break;
			}

			if (casilla.getMinasCercanas() > 0) {

				boton.setText(Integer.toString(casilla.getMinasCercanas()));
			}
		}
		if (casilla.isMina()) {
			boton.setText("MINA");
			boton.setOpaque(true);
			boton.setBackground(mina);
			
		}
	}

	public void desvelarCasilla(JButton boton, Tablero tablero, JButton[][] botonera) {
		Coordenada coordenadaActual = new Varios().obtenerCoordenada(boton);
		Casilla casillaActual = tablero.getCasilla(coordenadaActual);
		// tablero.cuentaBanderas(tablero, boton);

		if (casillaActual.isVelada() && !tablero.getCasilla(coordenadaActual).isMarcada()) {
			
			if(casillaActual.isMina()){
				muestraCasillas(boton, tablero);
				tablero.setPerdedor(true);
			}
			
			if (casillaActual.getMinasCercanas() > 0) {
				muestraCasillas(boton, tablero);
			}
			if (casillaActual.getMinasCercanas() == 0) {
				desvelaRecursiva(coordenadaActual, botonera, tablero);

			}
		}
		
		if(!casillaActual.isVelada()){
			tablero.contadorBanderas(tablero, boton);
			Coordenada[] contiguas = new Varios().contiguas(coordenadaActual.getX(), coordenadaActual.getY());
			Coordenada[] ContiguasValidadas = new Varios().validaContiguas(contiguas, tablero.length());
			if(tablero.getCasilla(coordenadaActual).getBanderaCercanas()==tablero.getCasilla(coordenadaActual).getMinasCercanas()){
				for (int i = 0; i < ContiguasValidadas.length; i++) {

					if(!tablero.getCasilla(ContiguasValidadas[i]).isMarcada()){
						muestraCasillas(botonera[ContiguasValidadas[i].getX()][ContiguasValidadas[i].getY()], tablero);

					}
				}
			}
			
		}
		if(tablero.isPerdedor()){
			for (int i = 0; i < botonera.length; i++) {
				for (int j = 0; j < botonera.length; j++) {
					muestraCasillas(botonera[i][j], tablero);
					botonera[i][j].setEnabled(false);
				}
			}
		}
		if(!tablero.isPerdedor()){
			tablero.setGanador(comprobarGanador(botonera, tablero));
			
		}
		if(tablero.isGanador()){
			for (int i = 0; i < botonera.length; i++) {
				for (int j = 0; j < botonera.length; j++) {
					muestraCasillas(botonera[i][j], tablero);
					botonera[i][j].setEnabled(false);
				}
			}
		}
		

	}

	

	
	private boolean comprobarGanador(JButton[][] botonera,Tablero tablero){
		
		boolean ganador=true;
		for (int i = 0; i < botonera.length; i++) {
			for (int j = 0; j < botonera.length; j++) {
				if(tablero.getCasilla(new Varios().obtenerCoordenada(botonera[i][j])).isVelada()){
					if(!tablero.getCasilla(new Varios().obtenerCoordenada(botonera[i][j])).isMina()){
						ganador=false;
					}
				}
			}
		}
		return ganador;
	}
	
	
	
	
	private void desvelaRecursiva(Coordenada coordenada, JButton[][] botonera, Tablero tablero) {
		Coordenada coordenadaCasilla = new Varios().obtenerCoordenada(botonera[coordenada.getX()][coordenada.getY()]);
		Coordenada coordenadas[] = new Varios().contiguas(coordenadaCasilla.getX(), coordenadaCasilla.getY());
		Coordenada[] coordenadasValidas = new Varios().validaRecursivas(coordenadas, tablero.length() - 1, tablero);
		if (tablero.getCasilla(coordenadaCasilla).getMinasCercanas() > 0) {
			muestraCasillas(botonera[coordenadaCasilla.getX()][coordenadaCasilla.getY()], tablero);

		} else {
			muestraCasillas(botonera[coordenadaCasilla.getX()][coordenadaCasilla.getY()], tablero);
			for (int i = 0; i < coordenadasValidas.length; i++) {
				desvelaRecursiva(new Coordenada(coordenadasValidas[i].getX(), coordenadasValidas[i].getY()), botonera,
						tablero);
			}
		}

	}

}