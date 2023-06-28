package vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controlador.AccesoControlador;
import excepciones.UsuarioInexistenteException;

public class Login extends JPanel {

    JTextField campoDni;

    public Login() {
        setLayout(new GridBagLayout());
        setBackground(Color.decode("#14213d"));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel1.setBackground(Color.decode("#14213d"));

        JLabel labelDni = new JLabel("DNI");
        labelDni.setFont(labelDni.getFont().deriveFont(Font.BOLD, 16));
        labelDni.setForeground(Color.WHITE);

        campoDni = new JTextField();
        campoDni.setPreferredSize(new Dimension(200, 30));

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setBackground(Color.decode("#e5e5e5"));
        btnIngresar.setForeground(Color.decode("#14213d"));
        btnIngresar.setFont(btnIngresar.getFont().deriveFont(Font.BOLD, 14));
        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AccesoControlador controler = new AccesoControlador();
                try {
                    controler.ingresar(campoDni.getText());
                } catch (UsuarioInexistenteException e1) {
                    JOptionPane.showMessageDialog(Login.this, e1.getMessage());
                }
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        panel1.add(labelDni, gbc);

        gbc.gridy = 1;
        panel1.add(campoDni, gbc);

        gbc.gridy = 2;
        panel1.add(btnIngresar, gbc);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.decode("#14213d"));

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(panel1, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(centerPanel, gbc);

        UIManager.put("Panel.background", Color.decode("#14213d"));
        UIManager.put("Button.background", Color.decode("#e5e5e5"));
        UIManager.put("Button.foreground", Color.decode("#14213d"));
        UIManager.put("Button.font", btnIngresar.getFont().deriveFont(Font.BOLD, 14));
    }
}
