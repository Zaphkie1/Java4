package EjemploMenus;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Estadistica extends JFrame implements ActionListener {

	private JMenuBar menu;
	private JMenu menu1, menu2;
	private JMenuItem opcion11, opcion12, opcion21;
	private JList<Double> lstValores;
	private DefaultListModel<Double> modelo = new DefaultListModel<Double>();
	private JButton btnAgregar, btnEliminar, btnLimpiar;
	private JLabel lblValor;
	private JTextField txtValor;
	private JPanel contenedor;
	private JScrollPane scroll;

	// Constructor
	public Estadistica() {
		this.setTitle("Calculadora Estadistica");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		contenedor = (JPanel) this.getContentPane();
		contenedor.setLayout(new FlowLayout());
		contenedor.setBackground(Color.CYAN);
		// Se define la barra de menus
		menu = new JMenuBar();
		menu1 = new JMenu("Calculos");
		menu2 = new JMenu("Info");
		menu.add(menu1);
		menu.add(menu2);
		opcion11 = new JMenuItem("Promedio");
		opcion12 = new JMenuItem("Desviacion Estandar");
		opcion21 = new JMenuItem("Acerca de");
		menu1.add(opcion11);
		menu1.add(opcion12);
		menu2.add(opcion21);
		this.setJMenuBar(menu);
		lblValor = new JLabel("Valor:");
		txtValor = new JTextField(15);
		lstValores = new JList<Double>();
		scroll = new JScrollPane();
		scroll.setPreferredSize(new Dimension(200, 280));
		scroll.setViewportView(lstValores);
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		// Agregar contenedor
		contenedor.add(lblValor);
		contenedor.add(txtValor);
		contenedor.add(btnAgregar);
		contenedor.add(scroll);
		contenedor.add(btnEliminar);
		contenedor.add(btnLimpiar);
		opcion11.addActionListener(this);
		opcion12.addActionListener(this);
		opcion21.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == btnAgregar) {
			try {
				double aux = Double.parseDouble(txtValor.getText());
				modelo.addElement(aux);
				lstValores.setModel(modelo);
				txtValor.setText("");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error en datos");
			}
		}
		if (evento.getSource() == btnEliminar) {
			int pos = lstValores.getSelectedIndex();
			if (pos >= 0) {
				modelo.removeElementAt(pos);
				lstValores.setModel(modelo);
			}
		}
		if (evento.getSource() == btnLimpiar) {
			modelo.clear();
			lstValores.setModel(modelo);
		}
		if (evento.getSource() == opcion11) {
			JOptionPane.showMessageDialog(null, "El promedio=" + promedio(modelo));
		}
		if (evento.getSource() == opcion12) {
			JOptionPane.showMessageDialog(null, "La desviacion estandar=" + desvstd(modelo));
		}
		if (evento.getSource() == opcion21) {
			JOptionPane.showMessageDialog(null, "Topicos Avanzado de Programaci�n 2023");
		}
	}

	private double promedio(DefaultListModel modelo) {
		double suma = 0.0, promx, valorx;
		Object[] valores = modelo.toArray();
		for (Object x : valores) {
			valorx = (double) x;
			suma = suma + valorx;
		}
		promx = suma / valores.length;
		return promx;
	}

	private double desvstd(DefaultListModel modelo) {
		double sumax = 0.0, ds, valorx;
		double media = promedio(modelo);
		Object[] valores = modelo.toArray();
		for (Object x : valores) {
			valorx = (double) x;
			sumax = sumax + Math.pow(valorx - media, 2);
		}
		ds = Math.sqrt(sumax / valores.length);
		return ds;
	}
}
