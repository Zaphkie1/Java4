package imagenenjava;

import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

public class PruebaImagen {
    public static void main(String[] args) {
        MarcoImagen mimarco = new MarcoImagen();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoImagen extends JFrame {
    public MarcoImagen() {
        setTitle("Marco Con Imagen");
        setBounds(750, 300, 726, 622);
        LaminaConImagen milamina = new LaminaConImagen();
        add(milamina);
    }
}

class LaminaConImagen extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //File miimagen = new File("C:/Users/TheWi/Documents/Java4/imagenenjava/gato-like.jpg");
        try {
            imagen = ImageIO.read(new File("imagenenjava/gato-like.jpg"));
        } catch (IOException e) {
            System.out.println("La iagen no se encuentra");
        }
        g.drawImage(imagen, 5, 5, null);
    }

    private Image imagen;
}