import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class persona {

	private int edad;
	private String nombre;
	private char sexo;
	private fecha fechaNacimiento;
	
	public persona() {
		// TODO Auto-generated constructor stub
	}

	protected void pedirdatos() {
		boolean introducido=false;
		fechaNacimiento=new fecha();
		do{
			System.out.println("Introduce la fecha de nacimiento");
			fechaNacimiento.pedirdatos();
			if (fechaNacimiento.posterior()) introducido=true;
			else System.out.println("No puede introducir una fecha posterior a la del sistema. Introduce una anterior");
		}while(!introducido);
		calcularedad();
		System.out.println("Edad: " + edad + " años");
		introducido=false;
		do{
			System.out.println("Introduce el sexo");
			sexo=introducirdato().charAt(0);
			if (sexo=='H' || sexo=='M' || sexo=='V') introducido=true;
			else System.out.println("Introduce en Sexo, los valores V, H o M");
		}while(!introducido);
		introducido=false;
		do{
			System.out.println("Introduce el nombre");
			nombre=introducirdato();
			introducido=true;
		}while(!introducido);
	}

	private void calcularedad() {
		GregorianCalendar fActual= new GregorianCalendar();
		edad=fActual.get(Calendar.YEAR)-fechaNacimiento.getAnno();
		if (fActual.get(Calendar.MONTH)+1<fechaNacimiento.getMes()) edad--;
		else if(fActual.get(Calendar.MONTH)+1==fechaNacimiento.getMes() && fActual.get(Calendar.DAY_OF_MONTH)<fechaNacimiento.getDia()) edad--;
	}

	public void mostrardatos() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Edad: " + edad);
		System.out.println("Sexo: " + sexo);
	}
	
	public String getNombre(){
		return this.nombre;
	}

	public void modificarNombre() {
		System.out.println("Indique el nombre que desea que tenga");
		this.nombre=introducirdato();
	}

	public void modificarEdad() {
		System.out.println("Indique la edad que desa que tenga");
		boolean introducido=false;
		do{
			try{
				this.edad=Integer.parseInt(introducirdato());
				if (edad>=0 && edad<120) introducido=true;
				else System.out.println("La edad no puede ser negativa ni mayor o igual a 120 años");
			}catch(NumberFormatException ex){
				System.out.println("Introduce un número. No un carácter");
			}
		}while(!introducido);
	}
	
	private String introducirdato() {
		String teclado=new String();
		BufferedReader leer= new BufferedReader(new InputStreamReader(System.in));
		try {
			teclado=leer.readLine();
		} catch (IOException e) {
			
		}
		return teclado;
	}	

}
