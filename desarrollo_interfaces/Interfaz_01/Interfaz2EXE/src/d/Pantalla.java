package d;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
        EventQueue.invokeLater(() -> {
            try {
                Pantalla window = new Pantalla();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
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

        // Botón salir
        JButton btnSalir = new JButton();
        btnSalir.setIcon(new ImageIcon(Pantalla.class.getResource("/recursos/salir.png")));
        btnSalir.setSelectedIcon(new ImageIcon(Pantalla.class.getResource("/recursos/salir.png")));
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setMargin(new Insets(0, 0, 0, 0));
        btnSalir.setBounds(744, 6, 50, 51);
        btnSalir.addActionListener(e -> System.exit(0));
        frame.getContentPane().add(btnSalir);

        // Imagen usuario
        JLabel usuario = new JLabel();
        usuario.setIcon(new ImageIcon(Pantalla.class.getResource("/recursos/usuario.png")));
        usuario.setBounds(104, 98, 202, 211);
        frame.getContentPane().add(usuario);

        // Label "Usuario"
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setForeground(Color.GRAY);
        lblUsuario.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblUsuario.setBounds(408, 119, 111, 25);
        frame.getContentPane().add(lblUsuario);

        // Label "Contraseña"
        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setForeground(Color.GRAY);
        lblContraseña.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblContraseña.setBounds(408, 195, 145, 25);
        frame.getContentPane().add(lblContraseña);

        // Campo de texto usuario
        textField = new JTextField();
        textField.setBounds(408, 156, 266, 26);
        textField.setColumns(10);
        frame.getContentPane().add(textField);

        // Campo de contraseña
        passwordField = new JPasswordField();
        passwordField.setBounds(408, 232, 266, 26);
        frame.getContentPane().add(passwordField);

        // Botón LOGIN
        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setBounds(557, 280, 117, 29);
        frame.getContentPane().add(btnLogin);

        // Checkbox "Recordarme"
        JCheckBox chckbxRecordarme = new JCheckBox("Recordarme");
        chckbxRecordarme.setBounds(408, 286, 128, 23);
        frame.getContentPane().add(chckbxRecordarme);

        // Fondo
        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon(Pantalla.class.getResource("/recursos/fondo.jpg")));
        fondo.setBounds(0, 0, 800, 400);
        frame.getContentPane().add(fondo);

        // Label "Bienvenidos"
        JLabel lblBienvenidos = new JLabel("Bienvenidos!");
        lblBienvenidos.setFont(new Font("SansSerif", Font.BOLD, 30));
        lblBienvenidos.setBounds(408, 40, 202, 60);
        frame.getContentPane().add(lblBienvenidos);
    }
}