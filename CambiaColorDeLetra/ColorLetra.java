package CambiaColorDeLetra;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class ColorLetra {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MarcoConColor mimarco = new MarcoConColor();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
    }
}

class MarcoConColor extends JFrame {
    public MarcoConColor() {
        setTitle("Prueba con colores");
        setSize(400, 400);
        LaminaConColor milamina = new LaminaConColor();

        add(milamina);
    }
}

class LaminaConColor extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // dibujo de rectangulo
        Rectangle2D rectangulo = new Rectangle2D.Double(109, 100, 200, 150);
        g2.setPaint(Color.MAGENTA);
        g2.fill(rectangulo);
        // dibujo elipse
        Ellipse2D elipse = new Ellipse2D.Double();

        elipse.setFrame(rectangulo);
        g2.setPaint(new Color(0,140,255));
        g2.fill(elipse);
    }
}
