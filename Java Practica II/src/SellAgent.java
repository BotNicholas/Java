/**Class Sell Agent that extends class Worker
 * @author Nicholas
 * @version 1.0
 * @since 06.06.2022
 */

public class SellAgent extends Worker{
	//SellAgent class fields
	//Fields from Parent-class and :
	private float percent;
	
	
	//Constructor without parameters (default constructor)
	public SellAgent() {
		super();
		this.percent = 2f;
	}

	//Constructor with some parameters	
	public SellAgent(String name, String surname, String father_name, String IDNP, String home_adres, String telephone) {
		super(name, surname, father_name, IDNP, home_adres, telephone);
		this.percent = 2f;
	}
	
	//Constructor with all parameters
	public SellAgent(String name, String surname, String father_name, String IDNP, String home_adres, String telephone, float percent) {
		super(name, surname, father_name, IDNP, home_adres, telephone);
		this.percent = percent;
	}
	
	//Writing getters
	//They are already written in Parent-class
	//But if you need, you can Override them
	/*
	@Overrid
	public String GetName() {
		return this.name;
	}
	*/
	public float GetAgentsPercent() {
		return this.percent;
	}
	
	
	//Writing setters
	//They are already written in Parent-class
	//But if you need, you can Override them
	/*
	@Override
	public String SetName(String name) {
		this.name = name;
	}
	*/
	public void SetAgentsPercent(float percent) {
		this.percent = percent;
	}
	
	
	
	//Other methods
	
}
