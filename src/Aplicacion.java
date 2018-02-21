import java.util.Scanner;

public class Aplicacion {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("----------------------------------------");
		System.out.println("-             Memory game              -");

		Boolean ok = true;
		Boolean ok1 = false;
		int c=1, f=1;
		//Comprobacion de que las casillas sean pares
		while(ok) { 			
			System.out.println("----------------------------------------");
			System.out.println("-  Introduzca Columna y fila:(ej.4x4)  -");
			System.out.println("----------------------------------------");

			String t = scan.nextLine();
		
			String [] partes = t.split("x");
			String cTemp = partes[0];
			String fTemp = partes[1];
			
			c = Integer.parseInt(cTemp);
			f = Integer.parseInt(fTemp);
			
			int par = c*f;
			
			if (par % 2 ==0) {
				ok1=true;
				ok = false;
			}
			else {
				System.out.println("----------------------------------------");
				System.out.println("-      Las casillas no son pares       -");
			}
		}
		//Iniciamos el juego despues de comprobar que son pares las casillas
		if(ok1) {
			Tablero tabla = new Tablero(f, c);
			tabla.Cartas();
			tabla.TableroFijo();
			

		}
	}
}


