import java.util.Scanner;
public class Foqueo16ProgramaEdadesMayorYMenor {
	public static void main (String args[]){
		int x;
		Scanner kb=new Scanner (System.in);
		int accumulator=0;//Estas tres cosas tienen que estar inicializados 
		int count=0;//Estas tres cosas tienen que estar inicializados 
		int edades= 0;//Estas tres cosas tienen que estar inicializados 
		for (x = 1;x <=10;x++){
			edades=getAge(kb);
			if (edades<18){
				accumulator++;
				}//end if 
			else {
				count++;
			}//end else 
		}//end for
		
		System.out.println("Hay "+accumulator+ " menores ");
		System.out.println("Hay"+count+" mayores ");
	kb.close();	
	}//end main 
	
 public static int getAge(Scanner kb){
 int age;
 System.out.print("Entre su edad  ");
	age=kb.nextInt();
	while(age<=0|| age>=100){
		System.out.print("Entre su edad mayor que 0 y menor que 100 ");
		age=kb.nextInt();
	}//end whilee este while va despues que ya se halla preguntado  
	return age;
 
 }//end metodo getAge


}// end class 
