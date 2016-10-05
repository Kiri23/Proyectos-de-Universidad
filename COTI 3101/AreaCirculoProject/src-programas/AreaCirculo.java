import java.util.Scanner;
import java.text.DecimalFormat;// estudiar java text
public class AreaCirculo {
	public static void main (String [] args)
	{
       double radius,area;
       final double PI = 3.14159;
			 // para darle formato a los numeros
       DecimalFormat df = new DecimalFormat ("###,##0.0000");// los # son numeros que tu los ultiliza, y elige cuantos numeros quieres en decimal
			 // para leer del teclado.
			 Scanner kb = new Scanner(System.in);
			 // for loop de 1 a 5
       for (int i = 1 ;i<=5; i++)
       {
	   //input
    	   System.out.println("Entre el radio del circulo "+ i);

	      radius = readRadius(kb);
	   //process
	      area = calcArea(radius, PI);
	   //output
	      System.out.println("El area del circulo " + i   + " es  ");
	      showArea(area,df);

        }// end for
       System.out.println("Fin del programa");
	}// end main

	// metodo para leer el radio(numero) del teclado
   public static double readRadius (Scanner kb){
	  // System.out.println("Entre el radio del circulo " );
		// lee del teclado un numero (el radio)
	   double radius = kb.nextDouble();
		 // devuelve el numero que se leyo del teclado
	   return radius;
   }
	 /**
	 metodo para calcular el area
	 **/
   public static double calcArea(double radius,double PI){
		 // formula de calcular area
		 //  PI = 3.14
	   double area1= Math.pow(radius, 2) * PI;//Math.pow(lo que quieres elevar(base),exponente al cual lo quieres elevar)
		 // devuelve el area
		 return area1;
   }

	 // metodo para mostrar el Area
   public static void  showArea (double area1,DecimalFormat df){

		 // df.format(area1)= formatea el area
		 // "\n = brinca a una nueva linea "
	   System.out.println(" "+df.format(area1) + " \n" );// df.format devuelve un string no un int pq tienes comas.
   }

}// end class
