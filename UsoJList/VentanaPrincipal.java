package UsoJList;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ScrollPaneUI;

import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor; /* Declaramos contenedor */
    private JButton agregar, eliminar, borrar; /* Declaramos objeto boton */
    private JLabel labelTitulo, mensaje;/* Declaramos objeto Label */
    private JTextField campo;
    private JList<String> listaNombres;/* Declaramos la lista */
    private DefaultListModel<String> modelo;/* Declaramos el Modelo */
    private JScrollPane scrollLista;

    public VentanaPrincipal() {
        iniciarComponentes();
        setTitle("Compnente JList");
        setSize(280, 330);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        contenedor = this.getContentPane();
        contenedor.setLayout(null);
        campo = new JTextField();
        campo.setBounds(20, 80, 135, 23);

        agregar = new JButton();
        agregar.setText("Agregar");
        agregar.setBounds(160, 80, 80, 23);
        agregar.addActionListener(this);

        eliminar = new JButton();
        eliminar.setText("Eliminar");
        eliminar.setBounds(20, 210, 80, 23);
        eliminar.addActionListener(this);

        borrar = new JButton();
        borrar.setText("Borrar Lista");
        borrar.setBounds(120, 210, 120, 23);
        borrar.addActionListener(this);

        labelTitulo = new JLabel();
        labelTitulo.setFont(new Font("Tahoma", 0, 28));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setText("JList");
        labelTitulo.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        labelTitulo.setBounds(40, 20, 180, 43);

        mensaje = new JLabel();
        mensaje.setBounds(20, 250, 180, 23);

        listaNombres = new JList<String>();
        listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        modelo = new DefaultListModel<String>();

        scrollLista = new JScrollPane();
        scrollLista.setBounds(20, 120, 220, 80);
        scrollLista.setViewportView(listaNombres);

        contenedor.add(labelTitulo);
        contenedor.add(campo);
        contenedor.add(agregar);
        contenedor.add(eliminar);
        contenedor.add(borrar);
        contenedor.add(mensaje);
        contenedor.add(scrollLista);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == agregar) {
            agregarNombre();
            mensaje.setText("Se agrego un nuevo elemento");
        }
        if (evento.getSource() == eliminar) {
            eliminarNombre(listaNombres.getSelectedIndex());
        }
        if (evento.getSource() == borrar) {
            borrarLista();
            mensaje.setText("Se borro toda la lista");
        }
    }

    private void agregarNombre() {
        String nombre = campo.getText();
        modelo.addElement(nombre);
        listaNombres.setModel(modelo);
        campo.setText("");
    }

    private void eliminarNombre(int indice) {
        if (indice >= 0) {
            modelo.removeElementAt(indice);
            mensaje.setText("Se elimino un elemento en la posicion");
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un indice", "Error", JOptionPane.ERROR_MESSAGE, null);
            mensaje.setText("no se selecciono ningun elemento");
        }
    }

    private void borrarLista() {
        modelo.clear();
    }
}
