import java.io.Serializable;

import java.io.*;

/**Class Client that extends abstract class Human
 * @author Nicholas
 * @version 1.0
 * @since 06.06.2022
 */

public class Client extends Human implements Serializable{
	
	//Client class fields
	
	
	
	//Constructor without parameters (default constructor)
	
	public Client() {
		this.name = "no_name";
		this.surname = "no_surname";
		this.father_name = "no_father_name";
		this.IDNP = "unknown";
		this.home_adres = "unknown";
		this.telephone = "unknown";
		this.age = 0;
		this.salary = 0f;
	}
	
	
	//Constructor with some parameters
	
	public Client(String name, String surname, String father_name, String IDNP, String home_adres, String telephone) {
		this.name = name;
		this.surname = surname;
		this.father_name = father_name;
		this.IDNP = IDNP;
		this.home_adres = home_adres;
		this.telephone  = telephone;
		this.age = 18; //Minimal allowed age
		this.salary = 2500f; //Minimal salary
	}
	
	//Constructor all parameters
	
	public Client(String name, String surname, String father_name, String IDNP, String home_adres, String telephone, int age, float salary) {
		this.name = name;
		this.surname = surname;
		this.father_name = father_name;
		this.IDNP = IDNP;
		this.home_adres = home_adres;
		this.telephone  = telephone;
		this.age = age;
		this.salary = salary;
	}
	
	
	//Writing getters
	
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
	
	public int GetAge() {
		return this.age;
	}
	
	public float GetSalary() {
		return this.salary;
	}
	
	
	//Writing setters
	
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
	
	
	
	//Other methodds
	
}
