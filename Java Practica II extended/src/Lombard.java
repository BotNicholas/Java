/**Class Lombard that implements ILombard interface
 * @author Nicholas
 * @version 1.0
 * @since 06.06.2022
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


public class Lombard implements ILombard{
	
	//Lombard class fields
	private String name;
	private String adres;
	private String telephone;
	private int number_of_workers;
	private int warehouse_space;
	private float money;
	private float workers_salary;
	
	Scanner in = new Scanner(System.in);
	
	private ArrayList <Contract> contracts = new ArrayList<Contract>();//?
	private Worker [] workers;
	private SellAgent agent;
	

	//constructor without parameters (default constructor)
	
	public Lombard() {
		this.name = "no_name";
		this.adres = "unknown_adres";
		this.telephone = "unknown_telephone";
		this.number_of_workers = 1;
		this.warehouse_space = 0;
		this.money = 0f;
		this.workers_salary = 0f;
		
		
		String Wname;
		String Wsurname;
		String Wfather_name;
		String WIDNP;
		String Whome_adres;
		String Wtelephone;
		
		String SAname;
		String SAsurname;
		String SAfather_name;
		String SAIDNP;
		String SAhome_adres;
		String SAtelephone;
		float SApercent;
		
		
		workers = new Worker[this.number_of_workers];
		for(int i=0; i<this.number_of_workers; i++) {
			
		    System.out.print("Input " + (i+1) + " lombard worker's name: ");
		    Wname = in.nextLine();

		    System.out.print("Input " + (i+1) + " lombard worker's surname: ");
		    Wsurname = in.nextLine();

		    System.out.print("Input " + (i+1) + " lombard worker's father name: ");
		    Wfather_name = in.nextLine();

		    System.out.print("Input " + (i+1) + " lombard worker's IDNP: ");
		    WIDNP = in.nextLine();

		    System.out.print("Input " + (i+1) + " lombard worker's home adres: ");
		    Whome_adres = in.nextLine();

		    System.out.print("Input " + (i+1) + " lombard worker's telephone: ");
		    Wtelephone = in.nextLine();
		    
			
			workers[i] = new Worker(Wname, Wsurname, Wfather_name, WIDNP, Whome_adres, Wtelephone);
			
			System.out.println("\n");
		}
			
		System.out.print("Input lombard sale agent's name: ");
	    SAname = in.nextLine();

	    System.out.print("\"Input lombard sale agent's surname: ");
	    SAsurname = in.nextLine();

	    System.out.print("Input lombard sale agent's father name: ");
	    SAfather_name = in.nextLine();

	    System.out.print("Input lombard sale agent's IDNP: ");
	    SAIDNP = in.nextLine();

	    System.out.print("Input lombard sale agent's home adres: ");
	    SAhome_adres = in.nextLine();

	    System.out.print("Input lombard sale agent's telephone: ");
	    SAtelephone = in.nextLine();
	    
	    System.out.print("Input lombard sale agent's contract's income percent: ");
	    SApercent = in.nextFloat();
	    in.nextLine();
		
		
		agent = new SellAgent(SAname, SAsurname, SAfather_name, SAIDNP, SAhome_adres, SAtelephone, SApercent);
	}
	
	//constructor with some parameters
	
	public Lombard(String name, String adres, String telephone){
		this.name = name;
		this.adres = adres;
		this.telephone = telephone;
		this.number_of_workers = 1; //default workers number
		this.warehouse_space = 100; //default warehouse capacity
		this.money = 20000f; //default money bank
		this.workers_salary = 2000f;
		
		
		
		String Wname;
		String Wsurname;
		String Wfather_name;
		String WIDNP;
		String Whome_adres;
		String Wtelephone;
		
		String SAname;
		String SAsurname;
		String SAfather_name;
		String SAIDNP;
		String SAhome_adres;
		String SAtelephone;
		float SApercent;
		
		
		
		workers = new Worker[this.number_of_workers];
			for(int i=0; i<this.number_of_workers; i++) {
			
		    System.out.print("Input " + (i+1) + " lombard worker's name: ");
		    Wname = in.nextLine();

		    System.out.print("Input " + (i+1) + " lombard worker's surname: ");
		    Wsurname = in.nextLine();

		    System.out.print("Input " + (i+1) + " lombard worker's father name: ");
		    Wfather_name = in.nextLine();

		    System.out.print("Input " + (i+1) + " lombard worker's IDNP: ");
		    WIDNP = in.nextLine();

		    System.out.print("Input " + (i+1) + " lombard worker's home adres: ");
		    Whome_adres = in.nextLine();

		    System.out.print("Input " + (i+1) + " lombard worker's telephone: ");
		    Wtelephone = in.nextLine();
		    
			
			workers[i] = new Worker(Wname, Wsurname, Wfather_name, WIDNP, Whome_adres, Wtelephone);
			
			System.out.println("\n");
		}
			
		System.out.print("Input lombard sale agent's name: ");
	    SAname = in.nextLine();

	    System.out.print("\"Input lombard sale agent's surname: ");
	    SAsurname = in.nextLine();

	    System.out.print("Input lombard sale agent's father name: ");
	    SAfather_name = in.nextLine();

	    System.out.print("Input lombard sale agent's IDNP: ");
	    SAIDNP = in.nextLine();

	    System.out.print("Input lombard sale agent's home adres: ");
	    SAhome_adres = in.nextLine();

	    System.out.print("Input lombard sale agent's telephone: ");
	    SAtelephone = in.nextLine();
	    
	    System.out.print("Input lombard sale agent's contract's income percent: ");
	    SApercent = in.nextFloat();
		
		
		agent = new SellAgent(SAname, SAsurname, SAfather_name, SAIDNP, SAhome_adres, SAtelephone, SApercent);
	}
	
	//constructor with all parameters
	
	public Lombard(String name, String adres, String telephone, int number_of_workers, int warehouse_space, float money, float workers_salary){
		this.name = name;
		this.adres = adres;
		this.telephone = telephone;
		this.number_of_workers = number_of_workers;
		this.warehouse_space = warehouse_space;
		this.money = money;
		this.workers_salary = workers_salary;
		
		
		String Wname;
		String Wsurname;
		String Wfather_name;
		String WIDNP;
		String Whome_adres;
		String Wtelephone;
		
		String SAname;
		String SAsurname;
		String SAfather_name;
		String SAIDNP;
		String SAhome_adres;
		String SAtelephone;
		float SApercent;
		
		
		
		workers = new Worker[this.number_of_workers];
		for(int i=0; i<this.number_of_workers; i++) {
			
		    System.out.print("Input " + (i+1) + " lombard worker's name: ");
		    Wname = in.nextLine();

		    System.out.print("Input " + (i+1) + " lombard worker's surname: ");
		    Wsurname = in.nextLine();

		    System.out.print("Input " + (i+1) + " lombard worker's father name: ");
		    Wfather_name = in.nextLine();

		    System.out.print("Input " + (i+1) + " lombard worker's IDNP: ");
		    WIDNP = in.nextLine();

		    System.out.print("Input " + (i+1) + " lombard worker's home adres: ");
		    Whome_adres = in.nextLine();

		    System.out.print("Input " + (i+1) + " lombard worker's telephone: ");
		    Wtelephone = in.nextLine();
		    
			
			workers[i] = new Worker(Wname, Wsurname, Wfather_name, WIDNP, Whome_adres, Wtelephone);
			
			System.out.println("\n");
		}
			
		System.out.print("Input lombard sale agent's name: ");
	    SAname = in.nextLine();

	    System.out.print("\"Input lombard sale agent's surname: ");
	    SAsurname = in.nextLine();

	    System.out.print("Input lombard sale agent's father name: ");
	    SAfather_name = in.nextLine();

	    System.out.print("Input lombard sale agent's IDNP: ");
	    SAIDNP = in.nextLine();

	    System.out.print("Input lombard sale agent's home adres: ");
	    SAhome_adres = in.nextLine();

	    System.out.print("Input lombard sale agent's telephone: ");
	    SAtelephone = in.nextLine();
	    
	    System.out.print("Input lombard sale agent's contract's income percent: ");
	    SApercent = in.nextFloat();
		
		
		agent = new SellAgent(SAname, SAsurname, SAfather_name, SAIDNP, SAhome_adres, SAtelephone, SApercent);
	}
	
	//Writing getters
	
	public String GetName() {
		
		return this.name;
	}
	
	public String GetAdres() {
		
		return this.adres;
	}

	public String GetTelephone() {
	
		return this.telephone;
	}

	public int GetNumberOfWorkers() {
	
		return this.number_of_workers;
	}

	public int GetWarehouseSpace() {
	
		return this.warehouse_space;
	}

	public float GetBank() {
	
		return this.money;
	}
	
	public float GetWorkersSalary() {
		return this.workers_salary;
	}
	
	
	public float GetCurentContractCost(String client_name, String client_surname, String client_father_name) {
		
		for(int i=0; i<Contract.GetTotalNumberOfContracts(); i++)
			if(this.contracts.get(i).GetClient().GetName().equals(client_name) && this.contracts.get(i).GetClient().GetSurname().equals(client_surname) && this.contracts.get(i).GetClient().GetFatherName().equals(client_father_name)) {
				if(!this.contracts.get(i).checkObjectsStatus()) {
					return this.contracts.get(i).ReturnContractCost();
				}else
					System.out.println("Object has olready sold...");
			}
		
		return -1;
	}
	
	
	
	//Writing setters
	
	public void SetName(String name) {
		this.name = name;
	}
	
	public void SetAdres(String adres) {
		this.adres = adres;
	}
	
	public void SetTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void SetNumberOfWorkers(int number_of_workers) {
		
		Worker [] workers2 = new Worker[number_of_workers];
		
		for(int i=0; i<this.number_of_workers; i++)
			workers2[i] = this.workers[i];
		
		workers = workers2;
		
		this.number_of_workers = number_of_workers;
	}

	public void SetWarehouseSpace(int warehouse_space) {
		this.warehouse_space = warehouse_space;
	}

	public void SetBank(float money) {
		this.money = money;
	}
	
	public void SetWorkersSalary(float workers_salary) {
		this.workers_salary = workers_salary;
	}
	
	
	//Writing other methods
	
	public void Income(int income) {
		this.money += income;
	}
	
	public void Outcome(int outcome) {
		this.money -= outcome;
	}
	
	
	public void createNewContract() {
		this.contracts.add(Contract.create());
		System.out.println("\n\n\nNew contract was successfully added!");
	}
	
	
	
	public void create20Contracts() {
		for(int i=0; i<20; i++) {
		this.contracts.add(Contract.create());
		System.out.println("\n\n\n" + (i+1) + "st contract was successfully added!\n");
		}
	}
	
	
	public void AddNewWorker() {
		//System.out.println(workers[number_of_workers-1].GetIDNP());
		
		
		for(int i=0; i<this.number_of_workers; i++)
			this.workers[i].showWorkersInfo();
		
		
		
		Worker [] workers2 = new Worker[this.number_of_workers+1];
		
		for(int i=0; i<this.number_of_workers; i++)
			workers2[i] = this.workers[i];
		
		
		
		
		
		
		
		//Input data 
		in.nextLine();
		System.out.print("\n\nEnter new worker's name: ");
		String name = in.nextLine();
		
		System.out.print("Enter new worker's surname: ");
		String surname = in.nextLine();

		System.out.print("Enter new worker's father name: ");
		String father_name = in.nextLine();

		System.out.print("Enter new worker's INDP: ");
		String IDNP = in.nextLine();

		System.out.print("Enter new worker's home adres: ");
		String home_adres = in.nextLine();

		System.out.print("Enter new worker's telephone: ");
		String telephone = in.nextLine();

		System.out.print("Enter new worker's age: ");
		int age = in.nextInt();
		in.nextLine();

		System.out.print("Enter new worker's salary: ");
		float salary = in.nextFloat();
		in.nextLine();
		
		workers2[number_of_workers] = new Worker(name, surname, father_name, IDNP, home_adres, telephone, age, salary);
		
		
		
		this.workers = workers2;
		
		this.number_of_workers++;
		
		System.out.println("\n\n\nNew worker was successfully added!");

		
		
		
		for(int i=0; i<this.number_of_workers; i++)
			this.workers[i].showWorkersInfo();
		
		
		//System.out.println(workers[number_of_workers-1].GetIDNP());
	}
	
	public void FireAWorker() {
		
		
		
		
		for(int i=0; i<this.number_of_workers; i++)
			this.workers[i].showWorkersInfo();
		
		
		
		if(this.number_of_workers>=1) {
			
		System.out.print("\n\nEnter worker's IDNP, you want to fire: ");
		String IDNP = in.nextLine();
		boolean flag = false;
		int wid=0;
		
		for(int i=0; i<this.number_of_workers; i++)
			if(this.workers[i].GetIDNP().equals(IDNP)) {
				flag = true;
				wid = i;
			}
		
		if(flag) {
			System.out.println("\n\n\nSuch worker was found!");
			System.out.println("His ID = " + wid);
		
		
		
		//System.out.println(workers[number_of_workers-1].GetIDNP());
		
		Worker [] workers2 = new Worker[this.number_of_workers-1];
		
		for(int i=0; i<wid; i++)
			workers2[i] = workers[i];
		
		for(int i=wid+1; i<this.number_of_workers; i++)
			workers2[i-1] = workers[i];
			
				
		workers = workers2;
		
		this.number_of_workers--;
		
		System.out.println("\nWorker was successfully fired!");
		}
		else System.out.println("\n\n\nSuch worker was not found!");
		}else System.out.println("There's no workers left!");

		
		
		
		
		for(int i=0; i<this.number_of_workers; i++)
			this.workers[i].showWorkersInfo();
		
		
		
		//System.out.println(workers[number_of_workers-1].GetIDNP());
		
	}
	
	
	public void AgentsIncomeForContracts() {
		
		//Make contract[1]'s object status: It wasn't sold yet
				this.contracts.get(1).SetContractClosingDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().plusDays(60).getDayOfMonth());
				
		for(int i=0; i<Contract.GetTotalNumberOfContracts(); i++) {
			System.out.println(i + " contract is good (the object was sold to lombard) - " + this.contracts.get(i).isContractGood());
			if(this.contracts.get(i).isContractGood())
			System.out.println("Agent's income for contract Nr." + (this.contracts.get(i).GetContractID()+1) + " = " + this.contracts.get(i).ReturnContractCost()*this.agent.GetAgentsPercent() + "\n");
		}
	}
	
	public void payContract(String client_name, String client_surname, String client_father_name, float money_to_pay) {
		
				
		for(int i=0; i<Contract.GetTotalNumberOfContracts(); i++) {
			if(this.contracts.get(i).GetClient().GetName().equals(client_name) && this.contracts.get(i).GetClient().GetSurname().equals(client_surname) && this.contracts.get(i).GetClient().GetFatherName().equals(client_father_name)) {
				System.out.println("Total Contract Cost = " + this.contracts.get(i).ReturnContractCost());
				this.contracts.get(i).PayMoney(money_to_pay);
				
				System.out.println(this.contracts.get(i).ReturnContractCost()+ " $ left to pay;");
			}
		}
		
		
	}
	
	
	
	
	public void CheckObjectStatus(String name){
		boolean flag = false;
		for(int i=0; i<Contract.GetTotalNumberOfContracts(); i++) {
			if(this.contracts.get(i).GetObject().GetName().equals(name)) {
				flag = true;
				if(this.contracts.get(i).checkObjectsStatus() && this.contracts.get(i).GetObject().GetOccupiedPlace()>0) {
					System.out.println("This object was sold!!!");
					System.out.println("It's contract number: " + this.contracts.get(i).GetContractID());
					System.out.println("Previous owner " + this.contracts.get(i).GetClient().GetName() + " "  + this.contracts.get(i).GetClient().GetSurname() + " " + this.contracts.get(i).GetClient().GetFatherName());
				}
				
				if(this.contracts.get(i).checkObjectsStatus() && this.contracts.get(i).GetObject().GetOccupiedPlace()==0) {
					System.out.println("This object was returned to owner!!!");
					System.out.println("It's contract number: " + this.contracts.get(i).GetContractID());
					System.out.println("The owner " + this.contracts.get(i).GetClient().GetName() + " "  + this.contracts.get(i).GetClient().GetSurname() + " " + this.contracts.get(i).GetClient().GetFatherName());
				}
				
				if(!this.contracts.get(i).checkObjectsStatus()) {
					System.out.println("This object hasn't sold yet!!!");
					System.out.println("It's contract number: " + this.contracts.get(i).GetContractID());
					System.out.println("It's owner " + this.contracts.get(i).GetClient().GetName() + " "  + this.contracts.get(i).GetClient().GetSurname() + " " + this.contracts.get(i).GetClient().GetFatherName());
				}
				
			}
			
		}
		if(!flag) System.out.println("Such object wasn't found!");
	}
	
	
	
	public void showClientsInfo(String client_IDNP) {
		boolean flag = false;
		for(int i=0; i<Contract.GetTotalNumberOfContracts(); i++) {
			if(this.contracts.get(i).GetClient().GetIDNP().equals(client_IDNP)) {
				flag = true;
				System.out.println("\nSuch client was found! Here is his data:");
				System.out.println("Name: " + this.contracts.get(i).GetClient().GetName());
				System.out.println("Surame: " + this.contracts.get(i).GetClient().GetSurname());
				System.out.println("Father name: " + this.contracts.get(i).GetClient().GetFatherName());
				System.out.println("IDNP: " + this.contracts.get(i).GetClient().GetIDNP());
				System.out.println("Home adres: " + this.contracts.get(i).GetClient().GetHomeAdres());
				System.out.println("Telephone: " + this.contracts.get(i).GetClient().GetTelephone());
				System.out.println("Age: " + this.contracts.get(i).GetClient().GetAge());
				System.out.println("Salary: " + this.contracts.get(i).GetClient().GetSalary());
				System.out.println("\nClient's object name: " + this.contracts.get(i).GetObject().GetName());
				System.out.println("Client's object type: " + this.contracts.get(i).GetObject().GetType());
				System.out.println("Client's object price: " + this.contracts.get(i).GetObject().GetPrice());
				System.out.println("Client's object woreness: " + this.contracts.get(i).GetObject().GetWoreness());
				System.out.println("Client's object weight: " + this.contracts.get(i).GetObject().GetWeight());
			}
				
		}
		if(!flag) System.out.println("Such client was not found!!!");
	}
	
	
	
	
	
	public void showContractsInfo(int contract_num) {
		boolean flag = false;
		
		for(int i=0; i<Contract.GetTotalNumberOfContracts(); i++) {
			if(this.contracts.get(i).GetContractID() == contract_num) {
				flag = true;
				System.out.println("\nThis contract was found! Here is it's data: ");
				System.out.println("Contract signing date: " + this.contracts.get(i).GetContractSigningDate());
				System.out.println("Contract closing date: " + this.contracts.get(i).GetContractClosingDate());
				System.out.println("\nContract object's name: " + this.contracts.get(i).GetObject().GetName());
				System.out.println("Contract object's type: " + this.contracts.get(i).GetObject().GetType());
				System.out.println("Contract object's price: " + this.contracts.get(i).GetObject().GetPrice());
				System.out.println("Contract object's weight: " + this.contracts.get(i).GetObject().GetWeight());
				System.out.println("Number of contract object's warehouse storing place: " + this.contracts.get(i).GetObject().GetOccupiedPlace());
				System.out.println("Contract object's woreness: " + this.contracts.get(i).GetObject().GetWoreness());
				
				
				System.out.println("\nContract object's status: ");
				this.CheckObjectStatus(this.contracts.get(i).GetObject().GetName());
				
				
				System.out.println("\nLombard contract comission: " + this.contracts.get(i).GetLombardComission());
				System.out.println("Contract price: " + this.contracts.get(i).ReturnContractCost());
				System.out.println("\nClient's name: " + this.contracts.get(i).GetClient().GetName());
				System.out.println("Client's surname: " + this.contracts.get(i).GetClient().GetSurname());
				System.out.println("Client's father name: " + this.contracts.get(i).GetClient().GetFatherName());
				System.out.println("Client's IDNP: " + this.contracts.get(i).GetClient().GetIDNP());
				System.out.println("Client's home adres: " + this.contracts.get(i).GetClient().GetHomeAdres());
				System.out.println("Client's telephone: " + this.contracts.get(i).GetClient().GetTelephone());
				System.out.println("Client's age: " + this.contracts.get(i).GetClient().GetAge());
				System.out.println("Client's salary: " + this.contracts.get(i).GetClient().GetSalary());
			}
		}
		
		if(!flag)
			System.out.println("Contract with such number wasn't found!!!");
	}
	
	
	
	public void whatIsStoringInTheWarehouse() {
		int count=0;
		for(int i=0; i<Contract.GetTotalNumberOfContracts(); i++)
			if(this.contracts.get(i).GetObject().GetOccupiedPlace()>0){
				count++;
				System.out.println("\n\nObject " + (i+1));
				System.out.println("Name: " + this.contracts.get(i).GetObject().GetName());
				System.out.println("Type: " + this.contracts.get(i).GetObject().GetType());
				System.out.println("Price: " + this.contracts.get(i).GetObject().GetPrice());
				System.out.println("It is sold (not retorned to client): " + this.contracts.get(i).GetObject().Is_it_sold());
				System.out.println("Weight: " + this.contracts.get(i).GetObject().GetWeight());
				System.out.println("Occuped space in warehouse: " + this.contracts.get(i).GetObject().GetOccupiedPlace());
				System.out.println("Woreness: " + this.contracts.get(i).GetObject().GetWoreness());
				
			}
		System.out.println("Total: " + count + " objects are storing in lombard's warehouse...");
	}
	
	
	
	
	public float GetTotalContractsCost() {
		float TotalSum=0;
		for(int i=0; i<Contract.GetTotalNumberOfContracts(); i++) {
			TotalSum+=this.contracts.get(i).ReturnContractCost();
		}
		return TotalSum;
	}

	public void SellObject(String name) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		for(int i=0; i<Contract.GetTotalNumberOfContracts(); i++)
			if(this.contracts.get(i).GetObject().GetName().equals(name) && !this.contracts.get(i).GetObject().Is_it_sold()) {
				flag = true;
				//System.out.println(name + " before - " + this.contracts.get(i).GetObject().Is_it_sold());
				this.contracts.get(i).SetObjectIsSold(true);
				this.money+=this.contracts.get(i).GetObject().GetPrice();
				//System.out.println(name + " before - " + this.contracts.get(i).GetObject().Is_it_sold());
				
				System.out.println("The object was successfully sold!");
			}
		
		if(!flag) System.out.println("Such object was not found (it is not storing in warehouse)!");
		
		System.out.println("Lombard's bank: " + this.money);
		
	}

	
	public void ReturnObject(String name) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for(int i=0; i<Contract.GetTotalNumberOfContracts(); i++)
			if(this.contracts.get(i).GetObject().GetName().equals(name) && !this.contracts.get(i).GetObject().Is_it_sold()) {
				flag = true;
				//System.out.println(name + " before - " + this.contracts.get(i).GetObject().Is_it_sold());
				this.contracts.get(i).SetObjectIsSold(true);
				this.contracts.get(i).SetObjectOccupedSpace(0);
				//System.out.println(name + " before - " + this.contracts.get(i).GetObject().Is_it_sold());
				
				System.out.println("The object was successfully returned to owner!");
			}
		
		if(!flag) System.out.println("Such object was not found (it is not storing in warehouse)!");
		
	}

	
	public void PaySalary() {
		// TODO Auto-generated method stub
		if(this.money > 10000) {
			System.out.println("Lombard's bank before paying salaryes: " + this.money);
			//salary for default worker
			System.out.println("\nSalary for worker: " + this.workers_salary);
		for(int i=0; i<this.number_of_workers; i++)
			this.workers[i].ObtainSalary(this.workers_salary);
		
		//salary for default sell agent
		float salary = this.workers_salary;
		
		for(int i=0; i<Contract.GetTotalNumberOfContracts(); i++)
			salary = salary + this.contracts.get(i).ReturnContractCost() * this.agent.GetAgentsPercent();
		

		System.out.println("\nSalary for sell agent: " + salary);
		this.agent.ObtainSalary(salary);
		
		//- from lombard's bank
		this.money -= this.workers_salary*this.number_of_workers + salary;
		
		System.out.println("\n\nLombard's bank after paying salaryes: " + this.money);
		
		}else System.out.println("Less moneyLeft!! Sorry!!!!");
		
	}
	
	
	
	//if we will want to pay another salary
	public void PaySalary(float salary) {
		// TODO Auto-generated method stub
		
		if(this.money > 10000) {
		System.out.println("Lombard's bank before paying salaryes: " + this.money);
		//salary for default worker
		System.out.println("\nSalary for worker: " + salary);
				for(int i=0; i<this.number_of_workers; i++)
					this.workers[i].ObtainSalary(salary);
				
				//salary for default sell agent		
				float csalary = this.workers_salary;
				
				for(int i=0; i<Contract.GetTotalNumberOfContracts(); i++)
					csalary = csalary + this.contracts.get(i).ReturnContractCost() * this.agent.GetAgentsPercent();
				

				System.out.println("\nSalary for sell agent: " + csalary);
				this.agent.ObtainSalary(csalary);
				
				//- from lombard's bank
				this.money -= salary*this.number_of_workers + csalary;
				
				System.out.println("\n\nLombard's bank after paying salaryes: " + this.money);
				
		}else System.out.println("Less moneyLeft!! Sorry!!!!");
	}
	
	
	
	
	
	
	
	public void writeContractsInFile() throws IOException{
		BufferedWriter f = new BufferedWriter(new FileWriter("ContractsInfo.txt"));
		
		for(int i=0; i<Contract.GetTotalNumberOfContracts(); i++) {		
		f.write(Integer.toString(this.contracts.get(i).GetContractID()));
		f.newLine();
		f.write(this.contracts.get(i).GetContractSigningDate().toString());
		f.newLine();
		f.write(this.contracts.get(i).GetObject().GetName());
		f.newLine();
		f.write(this.contracts.get(i).GetObject().GetType());
		f.newLine();
		f.write(Float.toString(this.contracts.get(i).GetObject().GetPrice()));
		f.newLine();
		
		if(!this.contracts.get(i).GetObject().Is_it_sold()) {
		f.write("0");
		f.newLine();
		}else {
			f.write("1");
			f.newLine();
		}
		
		f.write(Integer.toString(this.contracts.get(i).GetObject().GetWeight()));
		f.newLine();
		f.write(Integer.toString(this.contracts.get(i).GetObject().GetOccupiedPlace()));
		f.newLine();
		f.write(this.contracts.get(i).GetObject().GetWoreness());
		f.newLine();
		f.write(Float.toString(this.contracts.get(i).GetLombardComission()));
		f.newLine();
		f.write(this.contracts.get(i).GetContractClosingDate().toString());
		f.newLine();
		f.write(this.contracts.get(i).GetClient().GetName());
		f.newLine();
		f.write(this.contracts.get(i).GetClient().GetSurname());
		f.newLine();
		f.write(this.contracts.get(i).GetClient().GetFatherName());
		f.newLine();
		f.write(this.contracts.get(i).GetClient().GetIDNP());
		f.newLine();
		f.write(this.contracts.get(i).GetClient().GetHomeAdres());
		f.newLine();
		f.write(this.contracts.get(i).GetClient().GetTelephone());
		f.newLine();
		f.write(Integer.toString(this.contracts.get(i).GetClient().GetAge()));
		f.newLine();
		f.write(Float.toString(this.contracts.get(i).GetClient().GetSalary()));
		f.newLine();
		f.write(Float.toString(this.contracts.get(i).ReturnContractCost()));
		f.newLine();
		f.newLine();
		}
		f.flush();
		f.close();
		
		System.out.println("Contracts data was successfully written in file!!!");
	}
	
	
	public void readContractsInFile() throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("ContractsInfo.txt"));
		int i=0;
		int bool; 
		while(f.ready()) {
			this.contracts.add(Contract.createEpmtyContract());
			
			this.contracts.get(i).SetContractNumber(Integer.parseInt(f.readLine()));
			this.contracts.get(i).SetContractSigningDate(LocalDate.parse(f.readLine()));
			this.contracts.get(i).SetObjectName(f.readLine());
			this.contracts.get(i).SetObjectType(f.readLine());
			this.contracts.get(i).SetObjectPrice(Float.parseFloat(f.readLine()));
			
			
			bool = Integer.parseInt(f.readLine());
			if(bool == 1) this.contracts.get(i).SetObjectIsSold(true);
			else this.contracts.get(i).SetObjectIsSold(false);
			

			this.contracts.get(i).SetObjectWeight(Integer.parseInt(f.readLine()));
			this.contracts.get(i).SetObjectOccupedSpace(Integer.parseInt(f.readLine()));
			this.contracts.get(i).SetObjectWoreness(f.readLine());
			

			this.contracts.get(i).SetLombardComision(Float.parseFloat(f.readLine()));
			this.contracts.get(i).SetContractClosingDate(LocalDate.parse(f.readLine()));
			

			this.contracts.get(i).SetClientName(f.readLine());
			this.contracts.get(i).SetClientSurname(f.readLine());
			this.contracts.get(i).SetClientFatherName(f.readLine());
			this.contracts.get(i).SetClientIDNP(f.readLine());
			this.contracts.get(i).SetClientHomeAdres(f.readLine());
			this.contracts.get(i).SetClientTelephone(f.readLine());
			this.contracts.get(i).SetClientAge(Integer.parseInt(f.readLine()));
			this.contracts.get(i).SetClientSalary(Float.parseFloat(f.readLine()));
			
			
			this.contracts.get(i).SetContractCost(Float.parseFloat(f.readLine()));
			f.readLine();
			i++;
		}
		
		System.out.println("Contracts data was successfully red from file!!!");
	}

	public void SerializeContractsInFile() throws IOException{
		ObjectOutputStream f = new ObjectOutputStream(new FileOutputStream("SContractsData.txt"));
		f.writeInt(Contract.GetTotalNumberOfContracts());
		f.writeObject(this.contracts);
		
		f.flush();
		f.close();
		

		System.out.println("Contracts data was successfully serialized in file!!!");
	}
	
	

	
	public void DeserializeContractsInFile() throws IOException, ClassNotFoundException{
	ObjectInputStream f = new ObjectInputStream(new FileInputStream("SContractsData.txt"));
	
	Contract.SetTotalNumberOfContracts((Integer) f.readInt());
	this.contracts = (ArrayList<Contract>) f.readObject();
	
	f.close();

	System.out.println("Contracts data was successfully deserialized from file!!!");
	
	System.out.println(Contract.GetTotalNumberOfContracts());
	
//	if(!this.contracts.isEmpty()) {
//		Contract.SetTotalNumberOfContracts(this.contracts.get(0).GetNumOfContracts());
//	}
//	
//	System.out.println(Contract.GetTotalNumberOfContracts());
	
//	System.out.println(this.contracts.get(0).GetContractID());
//	System.out.println(this.contracts.get(0).GetClient().GetName());
//
//	System.out.println(this.contracts.get(1).GetContractID());
//	System.out.println(this.contracts.get(1).GetClient().GetName());
}

	
	public boolean IsObjectSold(String client_name, String client_surname,String client_father_name){
		for(int i=0; i<Contract.GetTotalNumberOfContracts(); i++)
		if(this.contracts.get(i).GetClient().GetName().equals(client_name) && this.contracts.get(i).GetClient().GetSurname().equals(client_surname) && this.contracts.get(i).GetClient().GetFatherName().equals(client_father_name))
			return this.contracts.get(i).checkObjectsStatus();
		
		return true;
	}
	
}
