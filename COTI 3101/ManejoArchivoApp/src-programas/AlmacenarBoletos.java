import java.io.*;
import java.util.*;

public class AlmacenarBoletos {

	public static void main(String[] args) throws IOException {// throw FileNotFoundInception.

		int edad, cant;
		String nombre;
		double boleto, sum;
		// para crear un archivo 
		PrintWriter outFile =new PrintWriter("boletos.txt");//outfile se conoce como nombre loqico del archivo. //"boletos.txt seria el nombre fisico del archivo.
		   
		  // para leer del teclado
		  Scanner in = new Scanner(System.in);
				
		sum = 0;
		cant = 0;
		
		// leer la edad del teclado
		edad = getAge(in);
		
		// Mientras edad no sea -1, sigue preguntando la edad,el nombre y calculando el   precio del boleto 
		while( edad != -1 )
		{
			// lee el nombre del teclado 
			nombre = getName(in);
			
			// si edad es menor o igual a 18, el boleto sale en $15
			if(edad <= 18)
				boleto = 15;
			// else si la edad no es 18 y es menor de 60 años, el precio del boleto es $25 
			else if(edad <= 60)
				boleto = 25;
		       
			// else si la edad es mayor de	60 , el precio del boleto es $10
			else
				boleto = 10;
			
			// la cantidad total de todos los boletos 
			sum += boleto;
			// la cantidad de boletos que se compro 
			cant++;
			// escribir al archivo el nombre , la edad y el precio del boleto 
			outFile.print(nombre+","+edad +","+boleto+ ",");
			
			// Muestra en pantalla el nombre y el costo del boleto
			System.out.println("Nombre: " + nombre + "\tCosto: " + boleto);

			// pregunta la edad de nuevo y la lee del teclado 
			edad = getAge(in);
			
		}    
		// El precio total en boletos y la cantidad de boletos que se compro   
		System.out.println("Total: " + sum + "\tCantidad: " + cant);
		
		in.close();
		outFile.close();//todo archivo se abre y se cierra . al igual que scanner se abre y se cierra
	    System.out.println("Los datos fueron almacenado ");
	}
	
	public static int getAge(Scanner kb)
	{
		int age;
		
		System.out.print("Entre edad <-1 Salir>: ");
		// lee la edad del teclado 
		age = kb.nextInt();
		
		// Mientras la edad no sea menor que -1 o mayor que 110, pregunta de nuevo la edad 
		while( age < -1 || age > 110 )
		{

			System.out.print("Incorrecto. Entre edad <-1 Salir>: ");
			// lee de nuevo la edad del teclado
			age = kb.nextInt();
			
		}
		// devuelve la edad 
		return age;
		

	}
	
	
	public static String getName(Scanner kb)
	{
		String name;
		System.out.print("Entre el nombre: ");
		 // lee el nombre del teclado
		name = kb.next();
	       // devuelve el nombre 
		return name;
	}

}
