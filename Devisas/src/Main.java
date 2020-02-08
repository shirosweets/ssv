// AWT
import java.awt.event.ActionEvent; // Escucha eventos (clicks)
import java.awt.event.ActionListener; // Escucha botones
// SWING
import javax.swing.JButton; // Utilizar botones
import javax.swing.JFrame; // Crear ventanas
import javax.swing.JLabel; // Crear etiquetas
//import javax.swing.JTextPane; // Crear texto de ventana
import javax.swing.JToggleButton; // Switcheo botones
import javax.swing.JTextField; // Cajas de texto
import javax.swing.JPanel;

public class Main extends JPanel { // Convertir dólares(USD) a pesos argentinos(ARS)
	private final double tasaDeCambio = 44.44;
	private double cambioEfectivo = tasaDeCambio;
	private JTextField campoCant; // Campo de texto
	private JTextField campoResult; // Campo de texto
	public Main(){
		add(new JLabel("Cantidad a convertir "));
		campoCant = new JTextField("0.0", 6);
		add(campoCant); // Agrega al contenedor
		add(new JLabel("Resultado"));
		campoResult = new JTextField("0.0", 6);
		add(campoResult); // Agrega al contenedor
		campoResult.setEditable(false);
		add(campoResult); // El botón convertidor por default no está seleccionado
		JToggleButton moneda = new JToggleButton("Dólar (USD) a pesos argentinos (ARS)", false);
		add(moneda); // Agrega al contenedor
		// Falta que nos escuche este wey, que pendejo - Wendy 29/05/2019
		moneda.addActionListener(new oyenteBConvt()); // Escucha al botón moneda
		JButton cambio = new JButton("Cambiar");
		add(cambio); // Agrega al contenedor
		cambio.addActionListener(new oyenteBCambio()); // Escucha al botón cambio
	}
	// Hacemos que oyenteBCambio (un botón) sea capaz de usar ActionListener (escuchar)
	class oyenteBCambio implements ActionListener{ 
		@Override // Forzar que el compilador
		public void actionPerformed (ActionEvent e) {
			double dinero = Double.parseDouble(campoCant.getText());
			dinero = dinero*cambioEfectivo;
			String cadena = String.format("%6.2f", dinero); //**
			campoResult.setText(cadena); //**
		}
	}
	class oyenteBConvt implements ActionListener{ 
		@Override
		public void actionPerformed (ActionEvent e) {
			JToggleButton button = (JToggleButton) e.getSource(); // **
			if (button.isSelected()) {
				button.setText("Pesos argentinos (ARS) a dólar (USD)");
				cambioEfectivo = 1/tasaDeCambio;
			}
			else {
				button.setText("Dólar (USD) a pesos argentinos (ARS)");
				cambioEfectivo = tasaDeCambio;
			}
		}
	}
	public static void main(String[] args) {
		// Creamos la ventana principal de la aplicación
		JFrame ventana = new JFrame("Calculadora de cambio de monedas v1");
		Main calc = new Main(); //**
		ventana.add(calc);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // _ [] X
		ventana.setSize(400, 100); // 400x200 AnchoxAlto
		ventana.setVisible(true);
		
	}
}
