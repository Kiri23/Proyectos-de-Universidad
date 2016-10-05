import java.util.Scanner;


public class SumofSquares {
	public static void main (String [] args){
		int exponent;
		int number;
		int power;
		Scanner kb = new Scanner(System.in);
		System.out.println("Entre el exponenete que quieren que se eleven los numeros del 1 al 10  ");
		exponent = kb.nextInt();
		if (exponent>0){
			for (number = 1 ; number <=10;number ++){
				power =(int) Math.pow(number, exponent);
				System.out.println("El numero es  "+ number+ "  Y su exponente es  "+ power);
			}//end for 
		}//end if 
		
		
		//else {
			while(exponent <=0){
			System.out.println("el exponente no puede ser negativo o 0  ");
			System.out.println("Entre el exponenete mayor que 0 y no sea negativo ");
			exponent = kb.nextInt();
			if (exponent>0){
				for (number = 1 ; number <=10;number ++){
					power =(int) Math.pow(number, exponent);
					System.out.println("El numero es  "+ number+ "  Y su exponente es  "+ power);
				}//end for 
			}//end if 
			}//end while 		
		//}//end else 
		kb.close();	
	
	}// end main 
    
	
}//end class
