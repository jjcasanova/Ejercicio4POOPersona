import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class fecha {

	private int dia, mes, anno;

	public fecha() {
		
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}


	public int getAnno() {
		return anno;
	}


	public void pedirdatos() {
		boolean introducido=false;
		do{
			System.out.println("Introducir día, mes y año de nacimiento");
			System.out.println("Día");
			this.dia=introducirdato();
			System.out.println("Mes");
			this.mes=introducirdato();
			System.out.println("Año");
			this.anno=introducirdato();
		}while(!comprobar());
	}
	
	private boolean comprobar() {
		boolean comprobar=false;
		switch(mes){
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			if (dia<=31) comprobar=true;
		break;
		case 4: case 6: case 9: case 11:
			if (dia<=30) comprobar=true;
		break;	
		case 2:
			if (bisiesto() && dia==29) comprobar=true;
			else if (dia<=28) comprobar=true;
		break;
		}
		return comprobar;
	}

	private boolean bisiesto() {
		if ((anno%4==0)&&(anno%100!=0 || anno%400==0)) return true;
		else return false;
	}

	private int introducirdato() {
		int teclado=0;
		BufferedReader leer= new BufferedReader(new InputStreamReader(System.in));
		try {
			teclado=Integer.parseInt(leer.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Por favor, introduce un número, no un carácter");
		} catch(IOException e){
			
		}
		return teclado;
	}

	public boolean posterior() {
		boolean posterior=false;
		int diasys, messys, annosys;
		GregorianCalendar actual=new GregorianCalendar();
		GregorianCalendar nacimiento= new GregorianCalendar();
		diasys= actual.get(Calendar.DAY_OF_MONTH);
		messys=actual.get(Calendar.MONTH)+1;
		annosys=actual.get(Calendar.YEAR);
		if (annosys==anno && messys==mes && diasys==dia) posterior=true;
		else{
			if (annosys>anno){
				posterior=true;
			}else{
				if (annosys==anno && messys>mes){
					posterior=true;
				}else{
					if (annosys==anno && messys==mes && diasys>dia){
						posterior=true;
					}
				}
			}
		}
		return posterior;
	}
}
