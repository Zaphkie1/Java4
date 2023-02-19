package Ventanita;
import javax.swing.*;
import java.awt.Color;;
public class Ventana extends JFrame {
    JPanel contenedor;
    JButton btnHola,btnAdios;
    //constructor
    public Ventana() {
        contenedor=(JPanel)this.getContentPane();
        contenedor.setBackground(Color.black);
        this.setTitle("Mi primer ventana");
        this.setBounds(100,100,300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnHola=new JButton("Hola");
        btnHola.setBounds(10,10,100,50);
        btnAdios=new JButton("Adios");
        btnAdios.setBounds(10,70,100,50);
        contenedor.setLayout(null);
        contenedor.add(btnHola);
        contenedor.add(btnAdios);
    }
}
