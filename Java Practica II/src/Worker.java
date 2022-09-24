/**Class Worker that extends abstract class Human and implements interface IWorker
 * @author Nicholas
 * @version 1.0
 * @since 06.06.2022
 */

public class Worker extends Human implements IWorker{
	//private static int count=1;
	
	public Worker() {
		this.name = "Unknown";
		this.surname = "Unknown";
		this.father_name = "Unknown";
		this.IDNP = "Unknown";
		this.home_adres = "Unknown";
		this.telephone = "Unknown";
		this.age = 19;
		this.salary = 0f;
	}
	
	
	public Worker(String name, String surname, String father_name, String IDNP, String home_adres, String telephone) {
		this.name = name;
		this.surname = surname;
		this.father_name = father_name;
		this.IDNP = IDNP;
		this.home_adres = home_adres;
		this.telephone = telephone;
		this.age = 19;
		this.salary = 2000f;
	}
	
	public Worker(String name, String surname, String father_name, String IDNP, String home_adres, String telephone, int age, float salary) {
		this.name = name;
		this.surname = surname;
		this.father_name = father_name;
		this.IDNP = IDNP;
		this.home_adres = home_adres;
		this.telephone = telephone;
		this.age = age;
		this.salary = salary;
	}
	
	
	
	public float GetSalary() {
		return this.salary;
	}
	
	//Даже если создать объект наследника и присвоить его в объектную переменную родителя, если в потомке поле name изменяется (родителя), то при вызове этого метода вызовется именно измененная версия, а не начальная, так как ты уже еёизменил
	
	public String GetName() {
		return this.name;
	}

	public String GetSurname() {
		return this.surname;
	}

	public String GetFatherName() {
		return this.father_name;
	}

	public String GetIDNP() {
		return this.IDNP;
	}

	public String GetHomeAdres() {
		return this.home_adres;
	}

	public String GetTelephone() {
		return this.telephone;
	}
	
	
	
	
	
	public void SetName(String name) {
		this.name = name;
	}

	public void SetSurname(String surname) {
		this.surname = surname;
	}

	public void SetFatherName(String father_name) {
		this.father_name = father_name;
	}

	public void SetIDNP(String IDNP) {
		this.IDNP = IDNP;
	}

	public void SetHomeAdres(String home_adres) {
		this.home_adres = home_adres;
	}

	public void SetTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public void SetAge(int age) {
		this.age = age;
	}
	
	public void SetSalary(float salary) {
		this.salary = salary;
	}


	@Override
	public void ObtainSalary(float salary) {
		// TODO Auto-generated method stub
		this.salary = salary;
		
	}
	
	public void showWorkersInfo() {
		System.out.println("\n\nWorker's name: " + this.name);
		System.out.println("Worker's surname: " + this.surname);
		System.out.println("Worker's father name: " + this.father_name);
		System.out.println("Worker's IDNP: " + this.IDNP);
		System.out.println("Worker's home adres: " + this.home_adres);
		System.out.println("Worker's telephone: " + this.telephone);
		System.out.println("Worker's age: " + this.age);
		System.out.println("Worker's salary: " + this.salary);
	}
	
}
