import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Convertidor extends JPanel {
private final double TASA_CAMBIO = 44.44;
private double cambioEfectivo = TASA_CAMBIO;
private JTextField campoCantidad;
private JTextField campoResultado;

public Convertidor() {
add(new JLabel("Cantidad a convertir"));
campoCantidad = new JTextField("0.0", 6);
add(campoCantidad);
add(new JLabel("Resultado"));
campoResultado = new JTextField("0.0", 6);
campoResultado.setEditable(false);
add(campoResultado);

JToggleButton moneda = new JToggleButton("Dolar (USD) a Pesos Argentinos (ARS)", false);
add(moneda);
moneda.addActionListener(new OyenteBotonConmutador());
JButton cambio = new JButton("Cambiar");
add(cambio);
cambio.addActionListener(new OyenteCambio());
}

class OyenteCambio implements ActionListener {

@Override
public void actionPerformed(ActionEvent e) {
double dinero = Double.parseDouble(campoCantidad.getText());
dinero = dinero * cambioEfectivo;
String cadena = String.format("%6.2f", dinero);
campoResultado.setText(cadena);
}

}


class OyenteBotonConmutador implements ActionListener {

@Override
public void actionPerformed(ActionEvent e) {
// ES NECESARIO OBTENER EL ORIGEN DEL EVENTO
JToggleButton boton = (JToggleButton) e.getSource();
if (boton.isSelected()) {
boton.setText("Pesos Argentinos(ARS) a Dolar(USD)");
cambioEfectivo = 1 / TASA_CAMBIO;
} else {
boton.setText("Dolar (USD) a Pesos Argentinos (ARS)");
cambioEfectivo = TASA_CAMBIO;
}
}

}

public static void main(String[] args) {
// SE CREA LA VENTANA PRINCIPAL DE LA APLICACIÓN
JFrame ventana = new JFrame("Calculadora cambio de monedas");
// SE CREA OBJETO DE TIPO CALCULADORA Y SE AÑADE A LA VENTANA PRINCIPAL
Convertidor calc = new Convertidor();
ventana.add(calc);
ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
ventana.setSize(400, 200);
ventana.setVisible(true);

}

}