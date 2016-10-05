
public class ProgramClassSumoofSquare {
public static void main (String arg[]){
	int number;
	int square;
	int sum = 0;
	System.out.println("\tNumbers\t\tSquares ");
	for (number = 1; number <=10; number++)
	{
		square= number * number ;
		System.out.println("\t" + number + "\t\t" + square);
		sum = sum + square;
	
	}
	System.out.println("\t\t\t\t-----");
	System.out.println("\t\t\t\t "+ sum);
}
}
