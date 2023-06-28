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
import excepciones.UsuarioDuplicadoException;
import modelo.Nivel;

public class CreacionSoporteTecnico extends JPanel {

	public CreacionSoporteTecnico() {

		JPanel panel = new JPanel(new GridLayout(4, 2));

		JLabel label1 = new JLabel("Nombre:");
		JLabel label2 = new JLabel("Apellido:");
		JLabel label3 = new JLabel("DNI:");

		JTextField textField1 = new JTextField();
		JTextField textField2 = new JTextField();
		JTextField textField3 = new JTextField();

		panel.add(label1);
		panel.add(textField1);
		panel.add(label2);
		panel.add(textField2);
		panel.add(label3);
		panel.add(textField3);

		JButton createButton = new JButton("Crear");
		JButton volverButton = new JButton("Volver");

		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new SoporteTecnicoControlador().crearSoporteTecnico(textField1.getText(), textField2.getText(),
							textField3.getText());
					JOptionPane.showMessageDialog(CreacionSoporteTecnico.this, "Soporte Tecnico dado de alta con éxito");
				} catch (UsuarioDuplicadoException e1) {
					JOptionPane.showMessageDialog(CreacionSoporteTecnico.this, e1.getMessage());
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
