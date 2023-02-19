package EventoRaton;

import java.awt.event.*;

import javax.swing.JFrame;

public class EventoRaton {
    public static void main(String[] args) {
        MarcoRaton mimarco = new MarcoRaton();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoRaton extends JFrame {
    public MarcoRaton() {
        setVisible(true);
        setBounds(700, 300, 600, 450);
        EventoDeRaton EventoRaton = new EventoDeRaton();
        addMouseMotionListener(EventoRaton);
    }
}

class EventoDeRaton implements MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Estas Arrastrando");

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Estas Moviendo");

    }

}
