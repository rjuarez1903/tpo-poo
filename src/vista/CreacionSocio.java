package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.SoporteTecnicoControlador;
import controlador.WindowManagerSingleton;
import excepciones.SedeExistenteException;
import excepciones.UsuarioDuplicadoException;
import modelo.Nivel;

public class CreacionSocio extends JPanel {

	public CreacionSocio() {

		JPanel panel = new JPanel(new GridLayout(4, 2));

		JLabel label1 = new JLabel("Nombre:");
		JLabel label2 = new JLabel("Apellido:");
		JLabel label3 = new JLabel("DNI:");
		JLabel label4 = new JLabel("Nivel:");

		JTextField textField1 = new JTextField();
		JTextField textField2 = new JTextField();
		JTextField textField3 = new JTextField();
		JComboBox<Nivel> comboBox = new JComboBox<>(Nivel.values());

		panel.add(label1);
		panel.add(textField1);
		panel.add(label2);
		panel.add(textField2);
		panel.add(label3);
		panel.add(textField3);
		panel.add(label4);
		panel.add(comboBox);

		JButton createButton = new JButton("Crear");
		JButton volverButton = new JButton("Volver");

		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new SoporteTecnicoControlador().crearSocio(textField1.getText(), textField2.getText(),
							textField3.getText(), (Nivel) comboBox.getSelectedItem());
					JOptionPane.showMessageDialog(CreacionSocio.this, "Socio dado de alta con éxito");
				} catch (UsuarioDuplicadoException e1) {
					JOptionPane.showMessageDialog(CreacionSocio.this, e1.getMessage());
				}
			}
		});

		volverButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowManagerSingleton windowManager = WindowManagerSingleton.getInstance();
				windowManager.switchWindow(new HomeSoporteTecnico());
			}
		});

		panel.add(createButton);
		panel.add(volverButton);

		this.add(panel);
	}

}
