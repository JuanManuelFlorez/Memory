import java.util.Scanner;
import java.util.ArrayList;

import java.util.Collections;

public class Tablero {

	private int fila, columna;
	ArrayList<Carta> lista;
	Scanner scan = new Scanner(System.in);


	public Tablero(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
		lista = new ArrayList<Carta>();
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}
	
	//Funcion para imprimir las letras del tablero
	public void Alfabeto() {
		char[] alpha = new char[26];
				int k = 0;
				for(int i = 0; i < columna; i++){
				    alpha[i] = (char)(65 + (k++));
				    if (i == 0) {
				    	System.out.print("    " + alpha[i] );
				    }
				    else {
				    	System.out.print("  " + alpha[i]);
				    }
				}
				System.out.println();
				System.out.println();

	}
	//Agregamos en el Arraylist los valores de las cartas y las mezclamos
	public void Cartas() {
		// Creacion de las cartas y add en la lista
		int aux = fila * columna;
		for (int i = 0; i < (aux / 2); i++) {
			lista.add(new Carta(i));
			lista.add(new Carta(i));

			// Mezclar cartas
		}
		Collections.shuffle(lista);
	}
	//Funcion para pasar a numeros las posciones introducidas por consola
	public void posicionCarta(String p) {
		String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		
		//Elimino el guion 
		String x = p.substring(0,p.indexOf('-'));
		String y = p.substring(p.indexOf('-')+1,p.length());		
		
		//Separo y convierto variables en integers
		String x1= x.substring(0,1);
		String x2= x.substring(1,x.length());
		int p1 = letras.indexOf(x1)+1;
		int p2 = Integer.parseInt(x2);
		
		String y1= y.substring(0,1);
		String y2= y.substring(1,x.length());
		int p3 = letras.indexOf(y1)+1;
		int p4 = Integer.parseInt(y2);
		imprimirTablero(p1,p2,p3,p4);
	}
	
	//Tablero que muestra nuestro avance en el juego
	public void TableroFijo() {
		int aux5=0;
		Alfabeto();
		for (int i = 0; i < fila; i++) {
			System.out.print((i+1) + "   ");
			for (int j = 0; j < columna; j++) {
				if (lista.get(aux5).getEstado()==true) {
					System.out.print(lista.get(aux5).getCodi() + "  ");
				}else {
					System.out.print('*' +  "  ");
				}
				aux5++;
			}
			System.out.println();
		}		
		//Comprobacion de final de juego o continuar
		int contador=0;
		for( int i = 0 ; i < lista.size() ; i++ ){
			if (lista.get(i).getEstado()==true) {
				contador++;
			}
		}
		if (contador==(columna*fila)) {
			System.out.println("----------------------------------------");
			System.out.println("-           !!!HAS GANADO!!!           -");
			System.out.println("----------------------------------------");

		}else {
			System.out.println("----------------------------------------");
			System.out.println("-         Posicion: (ej.A1-B2)          -");
			System.out.println("----------------------------------------");
	
			String pos = scan.nextLine();
			posicionCarta(pos);
		}
	}

	//Funcion para mostrar el tablero cada vez que hacemos un intento
	public void imprimirTablero(int p1, int p2, int p3, int p4){
		
		//Formula para conseguir la posicion exacta en el Arraylist
		int x=((p2-1)*columna+p1)-1;
	    int y=((p4-1)*columna+p3)-1;

		Alfabeto();
		int aux = 0;
		int f1=0;
		int f2=0;
		
		for (int i = 0; i < fila; i++) {
			System.out.print((i+1) + "   ");
			for (int j = 0; j < columna; j++) {
				if (x==aux) {
					System.out.print(lista.get(aux).getCodi() + "  ");
					f1=lista.get(aux).getCodi();
				}
				else if (y==aux) {
					System.out.print(lista.get(aux).getCodi() + "  ");
					f2=lista.get(aux).getCodi();
				}
				else {
					System.out.print('*' +  "  ");
				}	
				aux++;
			}
			System.out.println();
		}
		//Cambio de estado de las cartas si son iguales
		if (f1==f2) {
			lista.get(x).setEstado(true);
			lista.get(y).setEstado(true);
			System.out.println("----------------------------------------");
			System.out.println("-               ACERTASTE!!!           -");
			System.out.println("----------------------------------------");


		}else {
			System.out.println("----------------------------------------");
			System.out.println("-            Prueba otra vez           -");
			System.out.println("----------------------------------------");

		}
		try { Thread.sleep(3000); TableroFijo(); } catch (InterruptedException e) {}
	}
		
}
