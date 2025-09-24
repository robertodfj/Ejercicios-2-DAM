import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class Pantalla {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla window = new Pantalla();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pantalla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("");
		btnSalir.setSelectedIcon(new ImageIcon(Pantalla.class.getResource("/imagenes/salir.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBorder(null);
		btnSalir.setBorderPainted(false);
		btnSalir.setMargin(new Insets(0, 0, 0, 0));
		btnSalir.setIcon(new ImageIcon(Pantalla.class.getResource("/imagenes/salir.png")));
		btnSalir.setBounds(744, 6, 50, 51);
		frame.getContentPane().add(btnSalir);
		
		JLabel usuario = new JLabel("");
		usuario.setIcon(new ImageIcon(Pantalla.class.getResource("/imagenes/usuario.png")));
		usuario.setBounds(104, 98, 202, 211);
		frame.getContentPane().add(usuario);
		
		JLabel Usuario = new JLabel("Usuario:");
		Usuario.setForeground(Color.GRAY);
		Usuario.setFont(new Font("SansSerif", Font.BOLD, 20));
		Usuario.setBounds(408, 119, 111, 25);
		frame.getContentPane().add(Usuario);
		
		JLabel Contraseña = new JLabel("Contraseña:");
		Contraseña.setForeground(Color.GRAY);
		Contraseña.setFont(new Font("SansSerif", Font.BOLD, 20));
		Contraseña.setBounds(408, 195, 145, 25);
		frame.getContentPane().add(Contraseña);
		
		textField = new JTextField();
		textField.setBounds(408, 156, 266, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(408, 232, 266, 26);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(557, 280, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Recordarme");
		chckbxNewCheckBox.setBounds(408, 286, 128, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JLabel fondo = new JLabel("New label");
		fondo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		fondo.setIcon(new ImageIcon(Pantalla.class.getResource("/imagenes/fondo.jpg")));
		fondo.setBounds(0, 0, 800, 400);
		frame.getContentPane().add(fondo);
		
		JLabel lblBienvenidos = new JLabel("Bienvenidos!");
		lblBienvenidos.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblBienvenidos.setBounds(408, 40, 202, 60);
		frame.getContentPane().add(lblBienvenidos);
	}
}
