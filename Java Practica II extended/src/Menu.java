import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class Menu implements KeyListener{

	Lombard lombard = new Lombard("Lombard1", "str.Puschin 5", "022334455", 3, 100, 20000, 5000);
	
	
	JFrame frame = new JFrame("important");
	TextArea text = new TextArea();
	int option=0;
	
	Scanner in = new Scanner(System.in);
	
	public Menu() {
		text.setText("Please don't hide this window, otherwise the program won't be working as it should!"
					+ "\n\nControls:"
					+ "\nUp/Down arrow key - select option;"
					+ "\nEnter - select the option;"
					+"\nEsc or X or menu option to finish the programm...");
		text.setEditable(false);
		text.setFocusable(false);
		text.setBounds(0, 0, 1000, 500);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.addKeyListener(this);
		//frame.setAlwaysOnTop(true);
		frame.toFront();
		frame.setAutoRequestFocus(true);
		
		
		frame.add(text);
		
		frame.setVisible(true);
		draw_menu(option);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		//Up = 38
		if(e.getKeyCode() == 38 && option>0) {
			--option;
			draw_menu(option);
		}
		//System.out.println(e.getKeyCode() + " = " + e.getKeyChar() + --option);
		//Down - 40
		if(e.getKeyCode() == 40 && option<17) {
			++option;
			draw_menu(option);
		}
			//System.out.println(e.getKeyCode() + " = " + e.getKeyChar() + ++option);
		//Enter - 10
		if(e.getKeyCode() == 10) {
			
			cclear();
			
			switch(option) {
			case 0:
				lombard.createNewContract();
				//in.nextLine();
				break;
			case 1:
				lombard.create20Contracts();
				//in.nextLine();
				break;
			case 2:
				lombard.AddNewWorker();
				//in.nextLine();
				break;
			case 3:			
				lombard.FireAWorker();
				//in.nextLine();
				break;
			case 4:
				lombard.AgentsIncomeForContracts();
				//in.nextLine();
				break;
			case 5:
				String object_name;
				
				System.out.print("Enter object's name, which status you would like to check: ");
				object_name = in.nextLine();
				
				lombard.CheckObjectStatus(object_name);

				//in.nextLine();
				break;
			case 6:
				String client_IDNP;

			    System.out.print("Input client's IDNP: ");
			    client_IDNP = in.nextLine();

				
			    lombard.showClientsInfo(client_IDNP);

				//in.nextLine();
				break;
			case 7:
				
				int contract_num;
				
				System.out.print("Enter number of contract, which information you would like to see: ");
				contract_num = in.nextInt();
				in.nextLine();
				
				lombard.showContractsInfo(contract_num);

				//in.nextLine();
				break;
			case 8:
				lombard.whatIsStoringInTheWarehouse();
				//in.nextLine();
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
				//in.nextLine();
				break;
			case 10:
				float salary;
				System.out.println("Input the salary for workers: ");
				salary = in.nextFloat();
				in.nextLine();
				
				lombard.PaySalary(salary);
				
				//also works
				//lombard.PaySalary();
				//in.nextLine();
				break;
			case 11:
				System.out.println("Enter object's name to sell (it wont be returned to owner)");
				object_name = in.nextLine();
				
				
				lombard.SellObject(object_name);

				//in.nextLine();
				break;
			case 12:
				System.out.println("Enter object's name to return (it wont be sold to lombard)");
				object_name = in.nextLine();
				
				
				lombard.ReturnObject(object_name);

				//in.nextLine();
				break;
			case 13:
				try {
				lombard.writeContractsInFile();
				//in.nextLine();
				}catch(Exception ex) {};
				break;
			case 14:
				try {
				lombard.readContractsInFile();
				//in.nextLine();
				}catch(Exception ex) {};
				break;
			case 15:
				try {
				lombard.SerializeContractsInFile();
				//in.nextLine();
				}catch(Exception ex) {};
				break;
			case 16:
				try {
				lombard.DeserializeContractsInFile();
				//in.nextLine();
				}catch(Exception ex) {};
				break;
			case 17:
				cclear();
				System.out.println("Thanks for using!");
				System.exit(0);
				break;
			}
			frame.toFront();
			//draw_menu(option);
		}
		//Esc - 27
		if(e.getKeyCode()==27) System.exit(0);
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void draw_menu(int option) {
		
		//System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		cclear();
		
		String [] menu = {"Create a new contract;",
						  "Create 20 new contracts;",
						  "Add new worker;",
						  "Fire a worker;",
						  "See sell agent's income for each contract;",
						  "Check if object, which name entered from keyboard, is already sold;",
						  "See all information about client, whoose IDNP was enteren from the keyboard;",
						  "See all informanion in contract, whose number was entered from the keyboard;",
						  "See which objects are storing in the warehouse;",
						  "Pay contract;",
						  "Pay salary to workers;",
						  "Sell object;",
						  "Return object;",
						  "Write contracts info in file;",
						  "Read contracts info from file;", 
						  "Serialize contracts info;",
						  "Deserialize contracts info;",
						  "Exit"};
		
		
		//cclear();
		for(int i=0; i<18; i++)
			if(i==option) System.out.println("> " + menu[i]);
			else System.out.println(menu[i]);
		
		//System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	
	
	public static void cclear() {
		for(int i=0; i<50; i++)
			System.out.println();
	}

}
