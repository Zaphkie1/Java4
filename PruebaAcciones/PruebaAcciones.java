import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PruebaAcciones {
    public static void main(String[] args) {
        MarcoAccion marco = new MarcoAccion();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class MarcoAccion extends JFrame {
    public MarcoAccion() {
        setTitle("Prueba Acciones");
        setBounds(600, 350, 600, 300);
        PanelAccion lamina = new PanelAccion();
        add(lamina);
    }
}

class PanelAccion extends JPanel {
    public PanelAccion() {
        AccionColor accionAmarillo = new AccionColor("Amarillo", new ImageIcon(
                "C:/Users/TheWi/Documents/Universidad/TopicosAvanzadosDeProgramacion/Java4/PruebaAcciones/circulo_amarillo.png"),
                Color.yellow);
        AccionColor accionAzul = new AccionColor("Azul", new ImageIcon(
                "C:/Users/TheWi/Documents/Universidad/TopicosAvanzadosDeProgramacion/Java4/PruebaAcciones/circulo_azul.png"),
                Color.blue);
        AccionColor accionRojo = new AccionColor("Rojo", new ImageIcon(
                "C:/Users/TheWi/Documents/Universidad/TopicosAvanzadosDeProgramacion/Java4/PruebaAcciones/circulo_rojo.png"),
                Color.red);
        add(new JButton(accionAmarillo));
        add(new JButton(accionAzul));
        add(new JButton(accionRojo));

        /*
         * JButton botonAmarillo = new JButton("Amarillo");
         * JButton botonAzul = new JButton("Azul");
         * JButton botonRojo = new JButton("Rojo");
         * add(botonAmarillo);
         * add(botonAzul);
         * add(botonRojo);
         */
        InputMap mapaEntrada = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        // *KeyStroke teclaAmarillo = KeyStroke.getKeyStroke("ctrl A");
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "Fondo_Amarillo");
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "Fondo_Azul");
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "Fondo_rojo");
        ActionMap mapaAccion = getActionMap();
        mapaAccion.put("Fondo_amarillo", accionAmarillo);
        mapaAccion.put("Fondo_azul", accionAzul);
        mapaAccion.put("Fondo_rojo", accionRojo);
    }

    private class AccionColor extends AbstractAction {
        public AccionColor(String nombre, Icon icono, Color color_boton) {
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Poner la lamina de color " + nombre);
            putValue("Color_de_fondo", color_boton);
        }

        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("Color_de_fondo");
            setBackground(c);
            System.out.println(
                    "Nombre: " + getValue(Action.NAME) + " Descripcion: " + getValue(Action.SHORT_DESCRIPTION));
        }
    }

}
