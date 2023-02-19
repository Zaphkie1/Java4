package Estadistica;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Estadistica extends JFrame implements ActionListener {
    private JMenuBar menu;
    private JMenu menu1,menu2;
    private JMenuItem opcion11,opcion12,opcion21;
    private JList<Double>lstValores;
    private DefaultListModel<Double>modelo = new DefaultListModel<Double>();
    private JButton btnAgregar,btnEliminar,btnLimpiar;
    private  JLabel lblValor;
    private JTextField txtValor;
    private JPanel contenedor;

    public Estadistica(){
        this.setTitle("Calculadora estadistica");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        iniciarComponentes();
    }
    private void iniciarComponentes(){
        contenedor=(JPanel) this.getContentPane();
        contenedor.setLayout (new FlowLayout());
        contenedor.setBackground(Color.CYAN);

        menu=new JMenuBar();
        menu1=new JMenu("Calculos");
        menu2=new JMenu("Info");
        menu.add(menu1);menu.add(menu2);
        opcion11=new JMenuItem("Promedio");
        opcion12=new JMenuItem("Desviacion Estandar");
        opcion21=new JMenuItem("Acerca de");
        menu1.add(opcion11);menu1.add(opcion12);
        menu2.add(opcion21);
        this.setJMenuBar(menu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
