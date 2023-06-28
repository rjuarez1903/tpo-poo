package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.SoporteTecnicoControlador;
import controlador.WindowManagerSingleton;
import excepciones.UsuarioDuplicadoException;

public class CreacionTipoClase extends JPanel {

	public CreacionTipoClase() {

		JPanel panel = new JPanel(new GridLayout(4, 2));

		JLabel label1 = new JLabel("Nombre:");
		JLabel label2 = new JLabel("Es online:");

		JTextField textField1 = new JTextField();
		JRadioButton yesRadioButton = new JRadioButton("Yes");
		JRadioButton noRadioButton = new JRadioButton("No");
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(yesRadioButton);
		buttonGroup.add(noRadioButton);

		panel.add(label1);
		panel.add(textField1);
		panel.add(label2);
		panel.add(yesRadioButton);
		panel.add(noRadioButton);

		JButton createButton = new JButton("Crear");
		JButton volverButton = new JButton("Volver");

		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean seleccionado = yesRadioButton.isSelected();
				System.err.println(seleccionado);
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
