package vista;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import controlador.SoporteTecnicoControlador;
import controlador.WindowManagerSingleton;
import excepciones.UsuarioDuplicadoException;
import modelo.Sede;

public class CreacionAdministrativo extends JPanel {

	private JTable table;
	private JScrollPane scrollPane;
	private JCheckBox checkBox;
	private ArrayList<Sede> sedesSeleccionadas = new ArrayList<Sede>();

	public CreacionAdministrativo(ArrayList<Sede> sedes) {

		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel(new GridLayout(3, 2));

		JLabel label1 = new JLabel("Nombre:");
		JLabel label2 = new JLabel("Apellido:");
		JLabel label3 = new JLabel("DNI:");

		JTextField textField1 = new JTextField();
		JTextField textField2 = new JTextField();
		JTextField textField3 = new JTextField();

		panel2.add(label1);
		panel2.add(textField1);
		panel2.add(label2);
		panel2.add(textField2);
		panel2.add(label3);
		panel2.add(textField3);

		JButton createButton = new JButton("Crear");
		JButton volverButton = new JButton("Volver");

		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new SoporteTecnicoControlador().crearAdministrativo(textField1.getText(), textField2.getText(),
							textField3.getText(), sedesSeleccionadas);
					JOptionPane.showMessageDialog(CreacionAdministrativo.this, "Administrativo dado de alta con éxito");
				} catch (UsuarioDuplicadoException e1) {
					JOptionPane.showMessageDialog(CreacionAdministrativo.this, e1.getMessage());
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
		createTable(sedes);
		panel.add(scrollPane);

		this.add(panel2);
		this.add(panel);
	}

	private void createTable(ArrayList<Sede> sedes) {
		SedeTableModel model = new SedeTableModel(sedes);
		table = new JTable(model);
		initializeCheckbox();
		scrollPane = new JScrollPane(table);
	}

	private void initializeCheckbox() {
		checkBox = new JCheckBox();
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn column = columnModel.getColumn(2);
		column.setCellRenderer(new CheckBoxRenderer());
		column.setCellEditor(new CheckBoxEditor(checkBox));
	}

	// Clase interna para manejo tabla

	class SedeTableModel extends javax.swing.table.AbstractTableModel {
		private ArrayList<Sede> sedeList;
		private String[] columnNames = { "Barrio", "Nivel", "Selección" };
		private boolean[] selectedRows;

		public SedeTableModel(ArrayList<Sede> sedeList) {
			this.sedeList = sedeList;
			this.selectedRows = new boolean[sedeList.size()];
		}

		@Override
		public int getRowCount() {
			return sedeList.size();
		}

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public String getColumnName(int column) {
			return columnNames[column];
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			if (columnIndex == 2) {
				return Boolean.class;
			}
			return super.getColumnClass(columnIndex);
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return columnIndex == 2;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Sede sede = sedeList.get(rowIndex);
			if (columnIndex == 0) {
				return sede.getBarrio();
			} else if (columnIndex == 1) {
				return sede.getNivel();
			} else if (columnIndex == 2) {
				return selectedRows[rowIndex];
			}
			return null;
		}

		@Override
		public void setValueAt(Object value, int rowIndex, int columnIndex) {
			// Existing code...

			if (columnIndex == 2 && value instanceof Boolean) {
				selectedRows[rowIndex] = (Boolean) value;

				// Update the sedesSeleccionadas ArrayList based on the selected rows
				sedesSeleccionadas.clear();
				for (int i = 0; i < selectedRows.length; i++) {
					if (selectedRows[i]) {
						sedesSeleccionadas.add(sedeList.get(i));
					}
				}
			}
		}

		public boolean[] getSelectedRows() {
			return selectedRows;
		}
	}

}

// Manejo de checkboxes para seleccion de clases

class CheckBoxRenderer extends JCheckBox implements TableCellRenderer {
	public CheckBoxRenderer() {
		setHorizontalAlignment(JCheckBox.CENTER);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setSelected((value != null && (boolean) value));
		return this;
	}
}

class CheckBoxEditor extends AbstractCellEditor implements TableCellEditor, ItemListener {
	private JCheckBox checkBox;

	public CheckBoxEditor(JCheckBox checkBox) {
		this.checkBox = checkBox;
		checkBox.addItemListener(this);
	}

	@Override
	public Object getCellEditorValue() {
		return checkBox.isSelected();
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		checkBox.setSelected((value != null && (boolean) value));
		return checkBox;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		super.fireEditingStopped();
	}
}
