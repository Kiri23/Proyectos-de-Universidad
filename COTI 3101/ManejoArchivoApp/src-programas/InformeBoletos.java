import java.util.*;
import java.io.*;
public class InformeBoletos {

	public static void main(String[]args)throws IOException{
		//para escribir printwriter.leer de un archivo File.
		File boletosFile = new File("boletos.txt");//link to the file
		if (!boletosFile.exists()){
			System.out.println("No existe el archivo del boleto");
			System.out.println("fin del progrma..");
			System.exit(0);
		}//end if
		else{
			int cant,Max,Min;
			int edad;
			double costo,suma;
			String nombre;
			Max=Min=0;
			cant=0;
			suma=0;
			Scanner inFile = new Scanner(boletosFile);//open the file el archvo esta abierto
			inFile.useDelimiter(",");
			while (inFile.hasNext()){// has next verifica si hay adicional informacion trabaja como un seentinela.
				//mientras haiga adicional informacion entra al ciclo
			nombre =inFile.nextLine();
			edad = inFile.nextInt();
			costo = inFile.nextDouble();
			suma +=costo;
			if (Max==0){// cant++0;
				Max = edad;
				Min= edad;
			}//end if cantidad e== 0 
			else {
				if (edad> Max )// FileWritter se ultiliza para ecribir y no reemplazar
			   Max = edad;
				if (edad < Min)
				 Min = edad;
			}
			cant++;	
			System.out.println(" Nombre: "+ nombre + "\t Edad: " + edad +"\t Costo: " + costo );
			}// end while 
			System.out.println("\n El total de  " + cant + " boletos es  $" + suma);
			System.out.println("\n El mayor tiene  " + Max);
			System.out.println("\n El menor tiene " + Min);
			
			inFile.close();// close the file
			
			
		}// end else
	}
	
}
