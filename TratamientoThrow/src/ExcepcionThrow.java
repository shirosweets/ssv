import java.io.*; // para poder llamar a throw

public class ExcepcionThrow {  //  throw = lanzar
	// throw>> Detiene el programa
	public static void main (String[] args) {
		double op1, op2, resd;
		// Lector de buffer (lo que corre en memoria)
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.println("Nueva divisi�n");
				System.out.println("Numerador");
				op1 = Double.parseDouble(entrada.readLine());
				System.out.println("Denominador");
				op2 = Double.parseDouble(entrada.readLine());
				//resd = op1/op2;
				if(op2==0) throw new ArithmeticException(); {
					resd = op1/op2;
					System.out.println("El resultado es: " + Double.toString(resd)); // Double. para usar m�todos	
				}	
			}
			catch (ArithmeticException ae){ // ae para hacer referencia a Excepciones Aritm�ticas (por buena programaci�n)
				System.out.println("Error aritm�tico " + ae.toString());
			}
			catch (NumberFormatException nfe) { // nfe NumberFormatException
				System.out.println("Error de formato num�rico " + nfe.toString());
			}
			catch (IOException ioe) { //ioe IO>> Input Output (controlar entrada y salida de datos)
				System.out.println("Error de entrada y salida " + ioe.toString());
			}
			catch (Exception e){
				System.out.println("Error inexistente" + e.toString());
			}
		}
	}
}
