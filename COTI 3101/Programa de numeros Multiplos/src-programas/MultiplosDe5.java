
public class MultiplosDe5 {
	public static void main (String []args ){
		int x;
		int count = 0;
		int sum = 0 ;
		for (x=1;x<=100;x++){
			count = count + 1 ;
			sum = sum + x;
			
			if (x%5==0){ 
			System.out.println(x);
		    System.out.println("La multliplicacion de  "+ x + " por " + x + " es " + x*x);
		}
		}
	
		System.out.println("Estos son todos los multiplos de 5 del 1  hasta el 100." + " \n --------------");
	    System.out.println("Esta es la cantida de multiplos que hay :");
		System.out.println( (x- 1) /5 + " \n");
		// esta parte es hecha por el maestro   
		System.out.println("los multiplos de 5 fueron " + count);
		System.out.println("la suma de los multiplos de 5 es "+ sum);// que sume los multiplos de 5 
		
		

	}


}
