package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import controlador.SoporteTecnicoControlador;
import controlador.WindowManagerSingleton;
import modelo.TipoAmortizacion;

public class CreacionTipoArticulo extends JPanel {

	public CreacionTipoArticulo() {

		JPanel panel = new JPanel(new GridLayout(4, 2));

		JLabel label1 = new JLabel("Nombre:");
		JLabel label2 = new JLabel("Cantidad de usos/dias:");
		JLabel label4 = new JLabel("Tipo Amortización:");

		JTextField textField1 = new JTextField();
		JTextField textField2 = new JTextField();
		JComboBox<TipoAmortizacion> comboBox = new JComboBox<>(TipoAmortizacion.values());

		panel.add(label1);
		panel.add(textField1);
		panel.add(label2);
		panel.add(textField2);
		panel.add(label4);
		panel.add(comboBox);

		JButton createButton = new JButton("Crear");
		JButton volverButton = new JButton("Volver");

		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowManagerSingleton windowManager = WindowManagerSingleton.getInstance();
				try {
					new SoporteTecnicoControlador().agregarTipoArticulo(textField1.getText(),
							Integer.parseInt(textField2.getText()), (TipoAmortizacion) comboBox.getSelectedItem());
					JOptionPane.showMessageDialog(CreacionTipoArticulo.this, "Tipo de Articulo creado con éxito");
				} catch (NumberFormatException e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(CreacionTipoArticulo.this, "Ocurrió un error: " + e1.getMessage());
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
