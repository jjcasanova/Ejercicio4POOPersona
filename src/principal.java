import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class principal {

	private static int maxpersonas=30;
	private static int numpersonas;
	
	public static void main(String[] args) {
		numpersonas=numpersonas();
		int opcion=0;
		persona[] mipersona=new persona[maxpersonas];
		mipersona=rellenar(numpersonas);
		do{
			menu();
			opcion=opcion();
			eleccion(opcion,mipersona);
		}while(opcion!=5);
		System.out.println("Adiós");
	}

	private static int numpersonas() {
		int numpersonas=0;
		boolean introducido=false;
		do{
			System.out.println("Introduce el número de personas. Ha de ser menor o igual que 30");
			try{
				numpersonas=Integer.parseInt(introducirdato());
				if (numpersonas>0 && numpersonas<=maxpersonas) introducido=true;
				else System.out.println("Por favor introduce un número menor o igual a 30 y mayor que cero");
			}catch(NumberFormatException ex){
				System.out.println("Introduce un número, no un carácter");
			}
		}while(!introducido);
		return numpersonas;
	}

	private static void eleccion(int opcion,persona[] mipersona) {
		boolean introducido=false;
		int posicion=0;
		switch(opcion){
		case 1:
			posicion=posicion(mipersona);
			mipersona[posicion-1].mostrardatos();
			break;
		case 2:
			posicion=posicion(mipersona);
			int subopcion=0;
			introducido=false;
			do{
				submenu();
				try{
					subopcion=opcion();
					if (subopcion==1 || subopcion==2) introducido=true;
					else System.out.println("Por favor, introduce 1 ó 2");
				}catch(NumberFormatException ex){
					System.out.println("Introduce un número, no un carácter");
				}
			}while(!introducido);
			switch(subopcion){
				case 1: mipersona[posicion-1].modificarNombre(); break; // PONER MIPERSONA[].MOSTRARNOMBRE() Y CONFIRMAR
				case 2: mipersona[posicion-1].modificarEdad(); break; // PONER MIPERSONA[].MOSTRAREDAD() Y CONFIRMAR
				default: System.out.println("Opción incorrecta"); break; 
			}
			break;
		case 3:
			String nombre=null;
			System.out.println("Introduce un nombre");
			nombre=introducirdato();
			System.out.println ("El número de personas con el nombre " +nombre+ " es " +contarpersonas(nombre,mipersona,numpersonas));
			break;
		case 4:
			if (numpersonas<maxpersonas){
				System.out.println("Puede introducir " + (maxpersonas-numpersonas) + " personas más");
				numpersonas+=nuevapersona(mipersona);
			}
			else System.out.println("No puede introducir ninguna persona más");
			break;
		case 5:
			System.out.println("Salimos del programa");
			break;
		default:
			
			break;
		}
	}
	
	
	private static int nuevapersona(persona[] mipersona) {
		mipersona[numpersonas]=new persona();
		mipersona[numpersonas].pedirdatos();
		return 1;
	}

	private static int contarpersonas(String nombre, persona[] mipersona, int numpersonas) { 		
		int num=0;
		int i=0;
		do{
			if (nombre.equals(mipersona[i].getNombre())){
				num++;
			}
			i++;
		}while(i<numpersonas);
		return num;
	}
	

	private static void submenu() {
		System.out.println("1. Modificar nombre");
		System.out.println("2. Modificar edad");
	}

	private static int posicion(persona[] mipersona){
		int posicion=0;
		boolean introducido=false;
		introducido=false;
		do{
			System.out.println("Indique la posición de la persona de la que desea visualizar o modificar los datos");
			try{
				posicion=Integer.parseInt(introducirdato());
				if (posicion>0 && posicion<=numpersonas) introducido=true;
				else System.out.println("No existe esa posición. Hay " + numpersonas + " personas");
			}catch(NumberFormatException ex){
				System.out.println("Por favor, introduce un número, no un carácter");
			}
		}while(!introducido);
		return posicion;
	}

	private static int opcion() {
		int opcion=0;
		System.out.println("Introduce la opción");
		try {
			opcion=Integer.parseInt(introducirdato());
		}catch(NumberFormatException ex) {
			System.out.println("Por favor, introduce un número. No un carácter");
		}
		return opcion;
	}

	private static void menu() {
		System.out.println("1. Mostrar datos de una persona");
		System.out.println("2. Modificar datos de una persona");
		System.out.println("3. Indicar número de personas con un nombre");
		System.out.println("4. Añadir nueva persona (puede haber un máximo de treinta personas, no más)");
	}

	private static persona[] rellenar(int numpersonas) {
		persona[] mipersona= new persona[maxpersonas];
		for (int i=0;i<numpersonas;i++){
			mipersona[i]= new persona();
			mipersona[i].pedirdatos();
		}
		return mipersona;
	}

	private static String introducirdato() {
		String teclado=new String();
		BufferedReader leer= new BufferedReader(new InputStreamReader(System.in));
		try {
			teclado=leer.readLine();
		} catch (IOException e) {
			
		}
		return teclado;
	}

}
