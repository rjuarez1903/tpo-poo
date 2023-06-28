package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.AccesoControlador;
import controlador.WindowManagerSingleton;
import modelo.SupertlonSingleton;

public class HomeSoporteTecnico extends JPanel {

	public HomeSoporteTecnico() {
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel(new BorderLayout());
		panel.setLayout(new GridLayout(4, 1, 2, 2));

		JButton tipoArticuloMenu = new JButton("Agregar Tipo Articulo");
		JButton sedeMenu = new JButton("Agregar Sede");
		JButton tipoClaseManu = new JButton("Crear Tipo Clase");
		JButton administrativoMenu = new JButton("Crear Administrativo");
		JButton socioMenu = new JButton("Crear Socio");
		JButton soporteTecnicoMenu = new JButton("Crear Soporte Tecnico");
		JButton logoutButton = new JButton("Cerrar sesión");

		JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
		buttonPanel.add(tipoArticuloMenu);
		buttonPanel.add(sedeMenu);
		buttonPanel.add(tipoClaseManu);
		buttonPanel.add(administrativoMenu);
		buttonPanel.add(socioMenu);
		buttonPanel.add(soporteTecnicoMenu);

		panel.add(buttonPanel, BorderLayout.CENTER);

		panel.add(logoutButton, BorderLayout.SOUTH);

		this.add(panel, BorderLayout.CENTER);

		sedeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowManagerSingleton windowManager = WindowManagerSingleton.getInstance();
				windowManager.switchWindow(new CreacionSede());
			}
		});

		tipoArticuloMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowManagerSingleton windowManager = WindowManagerSingleton.getInstance();
				windowManager.switchWindow(new CreacionTipoArticulo());

			}
		});

		tipoClaseManu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowManagerSingleton windowManager = WindowManagerSingleton.getInstance();
				windowManager.switchWindow(new CreacionTipoClase());

			}
		});

		socioMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowManagerSingleton windowManager = WindowManagerSingleton.getInstance();
				windowManager.switchWindow(new CreacionSocio());
			}
		});

		soporteTecnicoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowManagerSingleton windowManager = WindowManagerSingleton.getInstance();
				windowManager.switchWindow(new CreacionSoporteTecnico());
			}
		});

		administrativoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowManagerSingleton windowManager = WindowManagerSingleton.getInstance();
				windowManager.switchWindow(new CreacionAdministrativo(SupertlonSingleton.getInstance().getSedes()));
			}
		});

		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AccesoControlador().cerrarSesion();
			}
		});

	}

}
