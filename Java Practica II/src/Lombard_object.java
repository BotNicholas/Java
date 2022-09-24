import java.io.*;

/**Class Lombard object
 * @author Nicholas
 * @version 1.0
 * @since 06.06.2022
 */

public class Lombard_object implements Serializable{
	//Lombard_object class fields
	private String name;
	private String type;
	private float price;
	private boolean is_sold;
	private int weight;
	
	//If it is not sold and it takes some free warehouse's space - it is on warehouse. Otherwise it was returned to the client	
	private int number_of_warehouse_space; //measuring in grams 
	private String woreness; //Object's price will depend of it 
	
	
	//Constructor without parameters (default constructor)
	
	public Lombard_object() {
		this.name = "no_name";
		this.type = "unknown_type";
		this.price = 0f;
		this.is_sold = false;
		this.weight = 0;
		this.number_of_warehouse_space = 0;
		this.woreness = "unknown";
	}
	
	
	//Constructor with some parameters
	
	public Lombard_object(String name, String type, float price, int weight) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.is_sold = false;
		this.weight = weight;
		
		if(weight >0 && weight <=1000) this.number_of_warehouse_space = 1;
			else this.number_of_warehouse_space = 2;
		
		this.woreness = "satisfactory";
	}
	
	
	//Constructor with all parameters

	public Lombard_object(String name, String type, float price, boolean is_soled, int weight, int number_of_warehouse_space, String woreness) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.is_sold = is_soled;
		this.weight = weight;
		this.number_of_warehouse_space = number_of_warehouse_space;
		this.woreness = woreness;
	}
	
	
	//Writing Getters
	
	public String GetName() {
		return this.name;
	}

	public String GetType() {
		return this.type;
	}

	public float GetPrice() {
		return this.price;
	}

	public boolean Is_it_sold() {
		return this.is_sold;
	}

	public int GetWeight() {
		return this.weight;
	}

	public int GetOccupiedPlace() {
		return this.number_of_warehouse_space;
	}

	public String GetWoreness() {
		return this.woreness;
	}
	
	
	//Writing Setters
	
	public void SetName(String name) {
		this.name = name;
	}

	public void SetType(String type) {
		this.type = type;
	}

	public void SetPrice(float price) {
		this.price = price;
	}

	public void SetIsSold(boolean is_sold) {
		this.is_sold = is_sold;
	}

	public void SetWeight(int weight) {
		this.weight = weight;
	}

	public void SetOccupiedPlace(int number_of_warehouse_space) {
		this.number_of_warehouse_space = number_of_warehouse_space;
	}

	public void SetWoreness(String woreness) {
		this.woreness = woreness;
	}
	
	
	
	//Other methods
	void ObjectSelling() {
		this.is_sold = true;
	}
}
