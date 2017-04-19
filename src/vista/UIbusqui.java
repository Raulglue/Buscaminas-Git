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
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JMenuItem;

public class UIbusqui extends JFrame {

	protected JPanel contentPane;
	private int tamaño=5;
	protected JButton[][] botonera = new JButton[tamaño][tamaño];
	protected JLabel lblBuscaminah;
	private JMenuBar menuBar;
	private JMenu mnJuego;
	private JMenu mnPersonalizado;
	private JLabel lblTamao;
	private JTextField textField;
	private JLabel label_1;
	

	/**
	 * Create the frame.
	 */
	public UIbusqui() {

		setBounds(100, 100, 583, 432);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnJuego = new JMenu("Juego");
		menuBar.add(mnJuego);
		
		mnPersonalizado = new JMenu("Personalizado");
		mnJuego.add(mnPersonalizado);
		
		lblTamao = new JLabel("Tama\u00F1o");
		lblTamao.setHorizontalAlignment(SwingConstants.CENTER);
		mnPersonalizado.add(lblTamao);
		
		textField = new JTextField();
		textField.setColumns(10);
		mnPersonalizado.add(textField);
		
		label_1 = new JLabel("Minas");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		mnPersonalizado.add(label_1);
		
		JTextField txtMaxTamao = new JTextField();
		txtMaxTamao.setText("MAX: tama\u00F1o\u00B2");
		txtMaxTamao.setColumns(10);
		mnPersonalizado.add(txtMaxTamao);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		lblBuscaminah = new JLabel("Buscaminah");
		lblBuscaminah.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscaminah.setBounds(new Rectangle(50, 0, 50, 0));
		lblBuscaminah.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblBuscaminah.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblBuscaminah, BorderLayout.SOUTH);
		
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
