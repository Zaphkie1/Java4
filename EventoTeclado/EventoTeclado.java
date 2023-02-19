package EventoTeclado;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class EventoTeclado {
    public static void main(String[] args) {
        MarcoConTeclas mimarco=new MarcoConTeclas();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConTeclas extends JFrame{
    public MarcoConTeclas(){
        setVisible(true);
        setBounds(700,300,600,450);
        EventoDeTeclado tecla=new EventoDeTeclado();
        addKeyListener(tecla);
    }
}

class EventoDeTeclado implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        char letra=e.getKeyChar();
        System.out.println(letra);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        //int codigo=e.getKeyCode();
        //System.out.println(codigo);
    }

}