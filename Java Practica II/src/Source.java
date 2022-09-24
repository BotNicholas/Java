/** this is the 2nd practical task - Java program
 * Class Source - the main class
 * @author Nicholas
 * @version 1.0
 * @since 06.06.2022
 */

import java.io.*;
import java.util.Scanner;


public class Source{
	public static void main(String [] args) throws IOException, ClassNotFoundException{
		Lombard lombard = new Lombard("Lombard1", "str.Puschin 5", "022334455", 3, 100, 20000, 5000);
		
		Scanner in = new Scanner(System.in);
		
		
		int option;
		
		
		do {
			//for console "cleaning"
		cclear();
		
		System.out.println("0.Create a new contract;");
		System.out.println("1.Create 20 new contracts;");		
		System.out.println("2.Add new worker;");
		System.out.println("3.Fire a worker;");
		System.out.println("4.See sell agent's income for each contract;");
		System.out.println("5.Check if object, which name entered from keyboard, is already sold;");
		System.out.println("6.See all information about client, whoose IDNP was enteren from the keyboard;");
		System.out.println("7.See all informanion in contract, whose number was entered from the keyboard;");
		System.out.println("8.See which objects are storing in the warehouse;");
		System.out.println("9.Pay contract;");
		System.out.println("10.Pay salary to workers;");
		System.out.println("11.Sell object;");
		System.out.println("12.Return object;");
		System.out.println("13.Write contracts info in file;");
		System.out.println("14.Read contracts info from file;");
		System.out.println("15.Serialize contracts info;");
		System.out.println("16.Deserialize contracts info;");
		System.out.println("17.Exit");
		System.out.print("> ");
		option = in.nextInt();
		in.nextLine();
		
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		//cclear();
		
		switch(option) {
		case 0:
			lombard.createNewContract();
			in.nextLine();
			break;
		case 1:
			lombard.create20Contracts();
			in.nextLine();
			break;
		case 2:
			lombard.AddNewWorker();
			in.nextLine();
			break;
		case 3:			
			lombard.FireAWorker();
			in.nextLine();
			break;
		case 4:
			lombard.AgentsIncomeForContracts();
			in.nextLine();
			break;
		case 5:
			String object_name;
			
			System.out.print("Enter object's name, which status you would like to check: ");
			object_name = in.nextLine();
			
			lombard.CheckObjectStatus(object_name);

			in.nextLine();
			break;
		case 6:
			String client_IDNP;

		    System.out.print("Input client's IDNP: ");
		    client_IDNP = in.nextLine();

			
		    lombard.showClientsInfo(client_IDNP);

			in.nextLine();
			break;
		case 7:
			
			int contract_num;
			
			System.out.print("Enter number of contract, which information you would like to see: ");
			contract_num = in.nextInt();
			in.nextLine();
			
			lombard.showContractsInfo(contract_num);

			in.nextLine();
			break;
		case 8:
			lombard.whatIsStoringInTheWarehouse();
			in.nextLine();
			break;
		case 9:
			String client_name;
			String client_surname;
			String client_father_name;
			float money_to_pay;
			
			System.out.print("Enter your name: ");
			client_name = in.nextLine();

			System.out.print("Enter your surname: ");
			client_surname = in.nextLine();

			System.out.print("Enter your father name: ");
			client_father_name = in.nextLine();

			
			if(!lombard.IsObjectSold(client_name, client_surname, client_father_name)) {
			
			System.out.println("Money to pay - " + lombard.GetCurentContractCost(client_name, client_surname, client_father_name));
			
			
			System.out.print("Enter how much money you would like to pay for contract: ");
			money_to_pay = in.nextFloat();
			in.nextLine();
			
			lombard.payContract(client_name, client_surname, client_father_name, money_to_pay);
			}
			else
				System.out.println("This object was already sold!");
			in.nextLine();
			break;
		case 10:
			float salary;
			System.out.println("Input the salary for workers: ");
			salary = in.nextFloat();
			in.nextLine();
			
			lombard.PaySalary(salary);
			
			//also works
			//lombard.PaySalary();
			in.nextLine();
			break;
		case 11:
			System.out.println("Enter object's name to sell (it wont be returned to owner)");
			object_name = in.nextLine();
			
			
			lombard.SellObject(object_name);

			in.nextLine();
			break;
		case 12:
			System.out.println("Enter object's name to return (it wont be sold to lombard)");
			object_name = in.nextLine();
			
			
			lombard.ReturnObject(object_name);

			in.nextLine();
			break;
		case 13:
			lombard.writeContractsInFile();
			in.nextLine();
			break;
		case 14:
			lombard.readContractsInFile();
			in.nextLine();
			break;
		case 15:
			lombard.SerializeContractsInFile();
			in.nextLine();
			break;
		case 16:
			lombard.DeserializeContractsInFile();
			in.nextLine();
			break;
		case 17:
			cclear();
			System.out.println("Thanks for using!");
			break;
		default:
			cclear();
			System.out.println("Choose an option from the menu!!!");
			in.nextLine();
		}
		
		}while(option!=17);
		
}
	
	
	public static void cclear() {
		for(int i=0; i<50; i++)
			System.out.println();
	}
}