/**Class Contract 
 * has client and lombard object objects
 * uses LocalDate
 * @author Nicholas
 * @version 1.0
 * @since 06.06.2022
 */

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;


public class Contract implements Serializable{

	//Contract class fields
	private int contract_number;
	private static int num=0;
	private int num_of_contracts;
	private LocalDate contract_signing_date; //date format yyyy-mm-dd
	private Lombard_object object;
	private float Lombard_comission;
	private LocalDate contract_closing_date;
	private Client client;
	private float ContrctsCost;
	
	private static Scanner in = new Scanner(System.in);
	
	
	//Constructor without parameters
	
	//We should create clients data variables here because in contract must be clients data, otherwise it will be wrong and unusual document
	public Contract() {
		
		String client_name;
		String client_surname;
		String client_father_name;
		String client_IDNP;
		String client_home_adres;
		String client_telephone;
		
		

		contract_number = num++;
		this.contract_signing_date = LocalDate.now();
		this.contract_closing_date = this.contract_signing_date.plusDays(30);
		this.object = new Lombard_object();
		this.Lombard_comission = 1.5f;
		
		//We can make an object firstly, and then initialize its fields through setters
		System.out.println("Input object's name: ");
			this.object.SetName(in.nextLine());
		
		System.out.println("Input object's price: ");
			this.object.SetPrice(in.nextInt());
			in.nextLine();
		
		System.out.println("Input object's woreness: ");
			this.object.SetWoreness(in.nextLine());
		
		
			
		//Or we can make this way
		System.out.print("Input client's name: ");
			client_name = in.nextLine();
		System.out.print("Input client's surname: ");
			client_surname = in.nextLine();
		System.out.print("Input client's father name: ");
			client_father_name = in.nextLine();
		System.out.print("Input client's IDNP: ");
			client_IDNP = in.nextLine();
		System.out.print("Input client's home adres: ");
			client_home_adres = in.nextLine();
		System.out.print("Input client's telephone: ");
			client_telephone = in.nextLine();
		
			
		this.client = new Client(client_name, client_surname, client_father_name, client_IDNP, client_home_adres, client_telephone);
		
		this.ContrctsCost = this.object.GetPrice() * this.Lombard_comission;
		this.num_of_contracts = num;
	}
	
	
	//Constructor with some parameters
	
	public Contract(String object_name, String type, int price, int weight, String client_name, String surname, String father_name, String IDNP, String home_adres, String telephone/*, int year, int month, int day*/) {

		contract_number = num++;
		//this.contract_signing_date = LocalDate.of(year, month, day);
		this.contract_signing_date = LocalDate.now();
		this.contract_closing_date = this.contract_signing_date.plusDays(30);
		this.object = new Lombard_object(object_name, type, price, weight);
		this.Lombard_comission = 1.5f;
		this.client = new Client(client_name, surname, father_name, IDNP, home_adres, telephone);
		
		this.ContrctsCost = this.object.GetPrice() * this.Lombard_comission;
		this.num_of_contracts = num;
	}
	
	//Constructor with all parameters

	public Contract(String object_name, String type, int price, boolean is_soled, int weight, int number_of_warehouse_space, String woreness, String client_name, String surname, String father_name, String IDNP, String home_adres, String telephone, int age, int salary, /*int year, int month, int day,*/ float Lombard_comission, int days_for_credit) {

		contract_number = num++;
		//this.contract_signing_date = LocalDate.of(year, month, day);
		this.contract_signing_date = LocalDate.now();
		this.contract_closing_date= this.contract_signing_date.plusDays(days_for_credit);
		this.object = new Lombard_object(object_name, type, price, is_soled, weight, number_of_warehouse_space, woreness);
		this.Lombard_comission = Lombard_comission;
		this.client = new Client(client_name, surname, father_name, IDNP, home_adres, telephone, age, salary);
		
		this.ContrctsCost = this.object.GetPrice() * this.Lombard_comission;
		this.num_of_contracts = num;
	}
	
	
	//Writing getters
	
	public LocalDate GetContractSigningDate() {
		return this.contract_signing_date;
	}

	//If only we don't want to change the Class object's field
	public Lombard_object GetObject() {
		//We have to make a copy for this field (class object), otherwise fields in this.oject object will be changed from any other place, but this distrupts the OOP encapsulation princip...
		Lombard_object CObject = new Lombard_object(this.object.GetName(), this.object.GetType(), this.object.GetPrice(), this.object.Is_it_sold(), this.object.GetWeight(), this.object.GetOccupiedPlace(), this.object.GetWoreness());
		return CObject;
	}
	
	
	
	/*
	public String GetObjectName() {
		return this.object.GetName();
	}
	
	public boolean Is_it_sold() {
		return this.object.Is_it_sold();
	}
	
	public String GetWoreness() {
		return this.object.GetWoreness();
	}
	
	
	public int GetOccupedWarehouseSpace() {
		return this.object.GetOccupiedPlace();
	}
	
	
*/
	
	
	public float GetLombardComission() {
		return this.Lombard_comission;
	}

	public LocalDate GetContractClosingDate() {
		return this.contract_closing_date;
	}

	//If only we don't want to change the Class object's field
	public Client GetClient() {
		//We have to make a copy for this field  (class object), otherwise fields in this.client object will be changed from any other place, but this distrupts the OOP encapsulation princip...
		
		Client CClient = new Client(this.client.GetName(), this.client.GetSurname(), this.client.GetFatherName(), this.client.GetIDNP(), this.client.GetHomeAdres(), this.client.GetTelephone(), this.client.GetAge(), this.client.GetSalary());
		
		//but also we can make it this way:
		/*
		Client CClient = new Client();
		CClient.SetName(this.client.GetName());
		CClient.SetSurname(this.client.GetSurname());
		CClient.SetFatherName(this.client.GetFatherName());
		CClient.SetIDNP(this.client.GetIDNP());
		CClient.SetHomeAdres(this.client.GetHomeAdres());
		CClient.SetTelephone(this.client.GetTelephone());
		CClient.SetAge(this.client.GetAge());
		CClient.SetSalary(this.client.GetSalary());
		*/
		
		return CClient;
	}
	
	
	/*
	public String GetClientName() {
		return this.client.GetName();
	}
	
	public String GetClientSurname() {
		return this.client.GetSurname();
	}
	
	public String GetClientFatherName() {
		return this.client.GetFatherName();
	}
	
	public String GetClientIDNP() {
		return this.client.GetIDNP();
	}
	
	public String GetClientHomeAdres() {
		return this.client.GetHomeAdres();
	}
	
	public String GetClientTelephone() {
		return this.client.GetTelephone();
	}
	
	*/
	
	public int GetContractID() {
		return this.contract_number;
	}
	
	
	public static int GetTotalNumberOfContracts() {
		return num;
	}
	public int GetNumOfContracts() {
		
		return this.num_of_contracts;
	}
	
	public static void SetTotalNumberOfContracts(int num_of_contracts) {
		num = num_of_contracts;
	}
	
	
	//Writing setters
	public void SetObjectType(String type) {
		this.object.SetType(type);
	}
	public void SetObjectPrice(float price) {
		this.object.SetPrice(price);
	}
	public void SetObjectWeight(int weight) {
		this.object.SetWeight(weight);
	}
	public void SetClientName(String name) {
		this.client.SetName(name);
	}
	public void SetClientSurname(String surname) {
		this.client.SetSurname(surname);
	}
	public void SetClientFatherName(String father_name) {
		this.client.SetFatherName(father_name);
	}
	public void SetClientIDNP(String IDNP) {
		this.client.SetIDNP(IDNP);
	}
	public void SetClientHomeAdres(String home_adres) {
		this.client.SetHomeAdres(home_adres);
	}
	public void SetClientTelephone(String telephone) {
		this.client.SetTelephone(telephone);
	}
	public void SetClientAge(int age) {
		this.client.SetAge(age);
	}
	public void SetClientSalary(float salary) {
		this.client.SetSalary(salary);
	}
	public void SetContractCost(float contract_cost) {
		this.ContrctsCost = contract_cost;
	}
	
	
	public void SetContractSigningDate(int year, int month, int day) {
		this.contract_signing_date = LocalDate.of(year, month, day);
	}
	//overwriting
	public void SetContractSigningDate(LocalDate contract_signing_date) {
		this.contract_signing_date = contract_signing_date;
	}

	public void SetContractClosingDate(int year, int month, int day) {
		this.contract_closing_date = LocalDate.of(year, month, day);
	}
	//overwriting
	public void SetContractClosingDate(LocalDate contract_closing_date) {
		this.contract_closing_date = contract_closing_date;
	}

	public void SetLombardComision(float Lombard_comision) {
		this.Lombard_comission = Lombard_comision;
	}

	public void SetObjectName(String name) {
		this.object.SetName(name);;
	}

	public void SetObjectIsSold(boolean is_sold) {
		this.object.SetIsSold(is_sold);;
	}

	public void SetObjectWoreness(String woreness) {
		this.object.SetWoreness(woreness);
	}
	
	public void SetObjectOccupedSpace(int number_of_warehouse_space) {
	this.object.SetOccupiedPlace(number_of_warehouse_space);
	}
	
	public void SetContractNumber(int contract_number) {
		this.contract_number = contract_number;
	}
	
	//Other methods
	
	public float ReturnContractCost() {
		return this.ContrctsCost;
	}
	
	public void PayMoney(float money) {
		if(!checkObjectsStatus()) {
		if(this.ReturnContractCost() != 0 && !this.contract_closing_date.equals(todaysDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()+5))) {
			this.ContrctsCost -= money;
		}
		if(this.ReturnContractCost() == 0 && !this.contract_closing_date.equals(todaysDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()+5))) {
			this.object.SetIsSold(true);
			this.object.SetOccupiedPlace(0);
		}
		}else System.out.println("Your object has already sold - " + checkObjectsStatus());
	}
	
	
	public boolean checkObjectsStatus() {
		/*
		//if the time is over
		if(!(this.object.Is_it_sold()) && this.contract_closing_date.equals(todaysDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()+5))) {
			this.object.SetIsSold(true);
			return this.object.Is_it_sold();
		}
		
		
		*/
		
		
		//If you need all objects to be sold
		
		///*
		if(!this.object.Is_it_sold() && this.contract_closing_date.equals(todaysDate())) {
			this.object.SetIsSold(true);
			return this.object.Is_it_sold();
		}
		return this.object.Is_it_sold();
}
	
	
/*

	public boolean checkObjectsStatus() {
		\*
		//if the time is over
		if(!Is_it_sold() && this.contract_closing_date.equals(todaysDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()+5))) {
			this.object.SetIsSold(true);
			return this.Is_it_sold();
		}
		
		
		*\
		
		
		//If you need all objects to be sold
		
		//\*
		if(!Is_it_sold() && this.contract_closing_date.equals(todaysDate())) {
			this.object.SetIsSold(true);
			return this.Is_it_sold();
		}
		//*\
		
		\**
		if(Is_it_sold() && this.object.GetOccupiedPlace()>0) {
			return this.Is_it_sold();
		}
		
		
		//if it is returned to client
		if(Is_it_sold() && this.object.GetOccupiedPlace()==0) {
			return this.Is_it_sold();
		}
		
		//if it is still not sold
		if(!Is_it_sold() && !this.contract_closing_date.equals(todaysDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()+5))) {
			return this.Is_it_sold();
		}
		*\
		return this.Is_it_sold();
}	
	
*/
	


public static LocalDate todaysDate(int year, int month, int day) {
	return LocalDate.of(year, month, day);
	//return LocalDate.now();
}

public static LocalDate todaysDate() {
	return LocalDate.now().plusDays(30);
	//return LocalDate.now();
}	



public static Contract create(){
	
	String object_name;
	String type;
	int price;
	int weight;
	String client_name;
	String surname;
	String father_name;
	String IDNP;
	String home_adres;
	String telephone;
	
	System.out.print("Input object's name: ");
	object_name = in.nextLine();

	System.out.print("\nInput object's type: ");
	type = in.nextLine();

	System.out.print("\nInput object's price: ");
	price = in.nextInt();
	in.nextLine();

	System.out.print("\nInput object's weight: ");
	weight = in.nextInt();
	in.nextLine();
	
	System.out.print("\nInput client's name: ");
	client_name = in.nextLine();

	System.out.print("\nInput client's surname: ");
	surname = in.nextLine();

	System.out.print("\nInput client's father name: ");
	father_name = in.nextLine();

	System.out.print("\nInput client's IDNP: ");
	IDNP = in.nextLine();

	System.out.print("\nInput client's home adres: ");
	home_adres= in.nextLine();

	System.out.print("\nInput client's telephone: ");
	telephone = in.nextLine();
	
	return new Contract(object_name, type, price, weight, client_name, surname, father_name, IDNP, home_adres, telephone);
	
}

public boolean isContractGood() {
	return this.object.Is_it_sold() && this.object.GetOccupiedPlace()>0;
}

public static Contract createEpmtyContract() {
	return new Contract("Empty", "Empty", 0, 0, "Empty", "Empty", "Empty", "Empty", "Empty", "Empty");
}

}