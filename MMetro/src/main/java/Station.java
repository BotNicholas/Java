public class Station implements Comparable<Station>{
	private String LineNumber;
	private String Name;
	
	public Station(String lineNumber, String Name) {
		this.LineNumber = lineNumber;
		this.Name = Name;
	}
	
	public String getLineNumber() {
		return this.LineNumber;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public void setLineNumber(String lineNumber) {
		this.LineNumber = lineNumber;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}

	@Override
	public int compareTo(Station o) {
		return this.Name.compareTo(o.getName());
	}
}
