
public class CalcAreaAndPerim {

	public static void main(String[] args)
	{
		// para guardar el numero del width
		int width;
		// para guardar el numero del height
		int height;
		// para guardar el numero del area
		int area;
		// para guardar el numero del perimetro
		int perim;

		//Input
		width=getW();
		height=getH();

		//process
		area=calcArea(width,height);
		perim=calcPerim(width,height);

		//output
		showR(area,perim);

	}//aqui termina main end of main en el main tu invocas los metodos y initializa las variables

	public static int getW()
	{
		int width;
		width=35;
		return width ;
	}//exit of get w

	public static int getH()
	{
		int height;
		height=48;
		return height ;
	}//exit of get h

	// metodo para calcular Area
	public static int calcArea(int w , int h )
	{
	    int area;
			// formular para calcular el area
	    area= w*h;
		return area ;
	}//exit of calcArea

	// metodo para calcular Perimetro
	public static int calcPerim(int w , int h )
	{
		int perimetro;
		// formula para calcular el perimetro
		perimetro=2*(w+h);
		return perimetro;
	}//exit of perim
	
	// metod para mostar el Perimetro
	public static void showR(int area , int perimetro)// aqui los parametros los que recibe es area y perimetro
	{
		System.out.println("Area : " + area );
		System.out.println("Perimetro es : "+ perimetro );

	}//Exit of showR

}
