package control;

import modelo.Tablero;
import vista.UIbusqui;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class ParaUIBusqui extends UIbusqui {

	Tablero tablero = new Tablero(botonera.length, botonera.length);

	public ParaUIBusqui() {
		for (int i = 0; i < botonera.length; i++) {
			for (int j = 0; j < botonera.length; j++) {

				botonera[i][j].addMouseListener(new MouseAdapter() {

					public void mousePressed(MouseEvent e) {
						if (e.getButton() == MouseEvent.BUTTON3)
							new Marcador().marcarCasilla((JButton) e.getSource(), tablero);
					}
				});

				botonera[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (!tablero.isMinasColocadas()) {
							tablero.colocarMinas(tablero);
							tablero.contadorMinas(tablero);
							tablero.setMinasColocadas(true);
						}
						new Desvelador().desvelarCasilla((JButton) arg0.getSource(), tablero, botonera);
						if (tablero.isPerdedor()) {
							lblBuscaminah.setText("HAS PISADO UNA MINA COMPAÑERO");
							lblBuscaminah.setForeground(Color.RED);
						}
						if (tablero.isGanador()) {
							lblBuscaminah.setText("CONGRATULAISION MAI FREI");
							lblBuscaminah.setForeground(Color.GREEN);
						}

					}
				});
			}
		}

	}
}