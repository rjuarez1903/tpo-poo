package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.SoporteTecnicoControlador;
import controlador.WindowManagerSingleton;
import excepciones.SedeExistenteException;
import modelo.Nivel;

public class CreacionSede extends JPanel {

	public CreacionSede() {

		JPanel panel = new JPanel(new GridLayout(4, 2));

		JLabel label1 = new JLabel("Barrio:");
		JLabel label2 = new JLabel("Nivel:");
		JLabel label3 = new JLabel("Precio de Alquiler:");

		JTextField textField1 = new JTextField();
		JComboBox<Nivel> comboBox = new JComboBox<>(Nivel.values());
		JTextField textField3 = new JTextField();

		panel.add(label1);
		panel.add(textField1);
		panel.add(label2);
		panel.add(comboBox);
		panel.add(label3);
		panel.add(textField3);

		JButton createButton = new JButton("Crear");
		JButton volverButton = new JButton("Volver");

		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new SoporteTecnicoControlador().agregarSede(textField1.getText(),
							(Nivel) comboBox.getSelectedItem(), Double.parseDouble(textField3.getText()));
					JOptionPane.showMessageDialog(CreacionSede.this, "Sede creada con éxito");
				} catch (SedeExistenteException e1) {
					JOptionPane.showMessageDialog(CreacionSede.this, e1.getMessage());
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
