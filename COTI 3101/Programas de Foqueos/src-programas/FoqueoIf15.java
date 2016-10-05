import java.util.Scanner;
public class FoqueoIf15 {
	public static void main(String [] args ){
		int number1;
		int number2;
		Scanner kb = new Scanner(System.in);
		System.out.println("Escriba el primer valor ");
		number1=kb.nextInt();
		System.out.println("Escriba el segundo valor ");
		number2 = kb.nextInt();
		if (number2<number1){
			for (int x = number2;x<=number1;x++){
				System.out.println(x);
			}//end for 
			
		}//end if 
		
		for (int x = number1;x <= number2;x++){
			System.out.println(x);
			
		}// end for 
		kb.close();
	}//end main 

}//end class
