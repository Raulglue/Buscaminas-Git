package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.GridLayout;

public class UIbusqui extends JFrame {

	protected JPanel contentPane;
	private int tamaño=10;
	protected JButton[][] botonera = new JButton[tamaño][tamaño];
	protected JLabel lblBuscaminah;

	/**
	 * Create the frame.
	 */
	public UIbusqui() {
		setMinimumSize(new Dimension(1300,1000));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		lblBuscaminah = new JLabel("Buscaminah");
		lblBuscaminah.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscaminah.setBounds(new Rectangle(50, 0, 50, 0));
		lblBuscaminah.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblBuscaminah.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblBuscaminah, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, botonera.length, 0, 0));
		for (int i = 0; i < botonera.length; i++) {
			for (int j = 0; j < botonera.length; j++) {
				botonera[i][j] = new JButton();
				panel.add(botonera[i][j]);
				botonera[i][j].setName(i+","+j);
				 
			}
		}
	}
}
