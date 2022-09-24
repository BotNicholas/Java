import java.io.Serializable;

/**Abstract class Human that has one abstract method (because its realization can be different) and some default
 * @author Nicholas
 * @version 1.0
 * @since 06.06.2022
 */

public abstract class Human implements Serializable{
	protected String name;
	protected String surname;
	protected String father_name;
	protected String IDNP;
	protected String home_adres;
	protected String telephone;
	protected int age;
	protected float salary;
	
	//Abstract method because SellAgent's salary is counting other way => returning other way
	public abstract float GetSalary();
	
	
	
	
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
	
}
