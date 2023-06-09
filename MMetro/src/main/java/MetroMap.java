import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class MetroMap {
	private TreeSet<Line> lines;
	private TreeSet<Station> stations;
//	private TreeMap<Station, List<Line>> connections;
	
	public MetroMap() {
		lines = new TreeSet<>();
		stations = new TreeSet<>();
//		connections = new TreeMap<>();
	}
	
	public void addLine(String number, String name) {
		Line line = new Line(number, name);
		
		lines.add(line);
	}
	
	public void addStation(String lineNumber, String name) {
		Station station = new Station(lineNumber, name);
		
		stations.add(station);
	}
	
	public void addStation(Station station) {
		stations.add(station);
	}
	
//	public void addConnecion(Station station, Line line1, Line line2){
//		List<Line>connectedL = new ArrayList<>();
//		connectedL.add(line1);
//		connectedL.add(line2);
//		
//		connections.put(station, connectedL);
//	}
	
	public TreeSet<Line> getLines() {
		return this.lines;
	}
	
	public TreeSet<Station> getStations() {
		return this.stations;
	}
	
//	public TreeMap<Station, List<Line>> getConnections() {
//		return this.connections;
//	}
}
