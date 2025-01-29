package javas.basics;
abstract class Car
{
	protected boolean isSedan;
	protected String seats;
	
	public Car(boolean isSedan, String seats) {
		this.isSedan = isSedan;
		this.seats = seats;
	}
	public boolean getIsSedan() {
		return isSedan;
	}
	public String getSeats() {
		return seats;
	}
	
	public abstract String getMileage();
	
	public void printCar(String name) {
        System.out.println(
            "A " + name + " is " + (this.getIsSedan() ? "" : "not ")
            + "Sedan, is " + this.getSeats() + "-seater, and has a mileage of around "
            + this.getMileage() + ".");
    }

	
}
class WagonR extends Car{
	private int mileage;
	
	public WagonR(int mileage) {
		super(false, "4");
		this.mileage = mileage;
	}

	public String getMileage() {
		return mileage+" kmpl";
	}
	
}

class HondaCity extends Car
{
	private int mileage;
	
	public HondaCity(int mileage) {
		super(true, "4");
		this.mileage = mileage;
	}

	public String getMileage() {
		return mileage+" kmpl";
	}
}

class InnovaCrysta extends Car{
	
	private int mileage;
	
	public InnovaCrysta(int mileage) {
		super(false, "6");
		this.mileage = mileage;
	}

	public String getMileage() {
		return mileage+" kmpl";
	}
	
}
public class CarMain {
	
	public static void main(String[] args) {
		
		Car wagonR = new WagonR(22);
		wagonR.printCar("WagonR");
		
		Car hondaCity = new HondaCity(28);
		hondaCity.printCar("HondaCity");
		
		Car innovaCrysta = new InnovaCrysta(20);
		innovaCrysta.printCar("InnovaCrysta");
		
	}

}
