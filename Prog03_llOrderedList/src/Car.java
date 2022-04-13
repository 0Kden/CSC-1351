/**
* Objects constructor for the Car object
*
* CSC 1351 Programming Project No 01
* Section 002
*
* @author Kaden Wyble
* @since 02/01/19
*
*/

public class Car implements Comparable<Car> {

	private String make;
	private int year;
	private int price; 

	//Sets the values of the object
	public Car(String Make, int Year, int Price) {
		make = Make;
		year = Year;
		price = Price;
	}
		
	public String getMake() {				//returns the value of make
		return make;
	}
		
	public int getYear() {					//returns the value of year
		return year;
	}
		
	public int getPrice() {					//returns the value of price
		return price;
	}
		
	public int compareTo(Car other) {	//compares two objects
			
		if(make.compareTo(((Car) other).getMake())>0) {
			return 1;
		}
		else if(make.compareTo(((Car) other).getMake())<0) {
			return -1;
		}
		else {
			if(year<((Car) other).getYear())
				return-1;
			else if(year == ((Car) other).getYear())
				return 0;
			else
				return 1;
			}
		
	}
		
	public String toString(){				//returns the newCar as a string 
		return String.format("Make: " +make+ ", Year: " +year+ ", Price: $" +price+ ";");
		
	}


}