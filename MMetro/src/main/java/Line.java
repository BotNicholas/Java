import java.util.ArrayList;
import java.util.List;

public class Line implements Comparable<Line>{
	private String number;
	private String name;
	private List<Station>stations;
	
	public Line(String number, String name) {
		this.number = number;
		this.name = name;
		stations = new ArrayList<>();
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<Station> getStations(){
		return this.stations;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	@Override
	public int compareTo(Line o) {
		return this.number.compareTo(o.getNumber());
	}
}
