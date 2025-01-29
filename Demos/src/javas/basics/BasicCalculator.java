package javas.basics;

abstract class ArithmaticCaluctor
{
	abstract int addation(int n1, int n2);
}

class Addation extends ArithmaticCaluctor{

	@Override
	int addation(int n1, int n2) {
		System.out.println("Adding integers: " + n1 + " " + n2);
		return n1+n2;
	}
	
}

class Multiplication  {
	
	int multiplication(int n, int m,ArithmaticCaluctor caluctor)
	{
		int product = n;
		for(int i=0;i<m-1;i++)
			product = caluctor.addation(product, n);
		
		return product;
	}
	
}

 public class BasicCalculator {
	 
	 public static void main(String[] args) {
		 ArithmaticCaluctor add = new Addation();
		
		 System.out.println("Sum = "+add.addation(7, 4));
		 Multiplication mul = new Multiplication();
		 System.out.println("Product = "+mul.multiplication(7, 4, add));
	}
	
	
}
