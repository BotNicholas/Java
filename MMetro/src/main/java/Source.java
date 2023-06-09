import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Source {
	@SuppressWarnings("unchecked")
	public static void main(String [] args) {
		String answer="";
		Scanner scanner = new Scanner(System.in);
		
		while(!answer.equals("exit")){
			System.out.println("Type \"create\" or \"open\" Json file. \"exit\" to exit...");
			System.out.print("> ");
			
			answer = scanner.nextLine();
			
			switch(answer) {
				case "create":
					
					MetroMap map = new MetroMap();
					
					try {
						Document document = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();
						
						Elements elements = document.select("#metrodata");
						Elements lines = document.select(".js-metro-line");
						Elements stations = document.select(".js-metro-stations");
						
						//Lines
						lines.forEach((line)->{
							map.addLine(line.attr("data-line"), line.text());
						});
						
						//Stations and Lines
						stations.forEach((s)->{
							String lineNumber = s.attr("data-line");
							
							ArrayList<Station> stationsList = new ArrayList<>();
							
							s.select("a").select(".name").forEach((a)->stationsList.add(new Station(lineNumber, a.text())));
							
							map.getStations().addAll(stationsList);
							
							map.getLines().forEach((line)->{
								if(line.getNumber().equals(lineNumber)) {
									line.setStations(stationsList);
								}
							});
						});						
						
//						//Connections
//						int linesCount = map.getLines().size();
//
//						for(int i=0; i<linesCount; i++) {
//							//System.out.println(map.getLines().get(i).getName() + " with: ");
//							for(Station station : map.getLines().get(i).getStations()) {
//								for(int j=i+1; j<linesCount; j++) {
//									for(Station st : map.getLines().get(j).getStations()){
//										if(st.getName().equals(station.getName())) {
//											
//											System.out.println(station.getName() + " from " + map.getLines().get(i).getName() + " ==" + st.getName() + " from "+ map.getLines().get(j).getName());
//											
//											map.addConnecion(station, map.getLines().get(i), map.getLines().get(j));
//										}
//									};
//								}
//							}
//						}
//						
//						map.getConnections().keySet().forEach((key)->{
//							System.out.println(key.getName() + " -> " + map.getConnections().get(key).get(0).getName() + ", " + map.getConnections().get(key).get(1).getName());
//						});
						

						JSONObject mainObj = new JSONObject();
						JSONObject linesObj = new JSONObject();
						
						map.getLines().forEach((line)->linesObj.put(line.getNumber(), line.getName()));
						
						JSONObject stationsObj = new JSONObject();
						
						map.getLines().forEach((line)->{
							JSONArray stationsArray = new JSONArray();
							line.getStations().forEach((station)->stationsArray.add(station.getName()));
							stationsObj.put(line.getNumber(), stationsArray);
						});
						
						
						mainObj.put("lines", linesObj);
						mainObj.put("stations", stationsObj);
						
						
//						Files.writeString(Paths.get("data/MMetro.json"), mainObj.toJSONString(), null);
						BufferedWriter file = new BufferedWriter(new FileWriter("data/MMetro.json"));
						
						file.write(mainObj.toJSONString());
						
						file.flush();
						file.close();
						
						
						
						
						//??? писать данные в формате {"key1": "value1", "key2": "value2"} (то есть когда есть два значения, скажем номер линии и её название) лучше, да и парсить его потом гораздо легче. НО если у объекта свойств больше, чем два (например номеру линии, помимо названия соответствует ещё и её цвет, то тут, безусловно, нужно писать в таком формате [{"key1": "value1"}, {"key2": "value2"}] (то есть в объекты))
						System.out.println("Done!");
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					
					break;
				case "open":
					
					try {
						MetroMap readMap = new MetroMap();
						
						JSONParser parser = new JSONParser();
						
						JSONObject mainObject = (JSONObject) parser.parse(new FileReader("data/MMetro.json"));
						
						JSONObject lines = (JSONObject) mainObject.get("lines");
						
						lines.keySet().forEach((key)->{
							readMap.addLine(key.toString(), lines.get(key).toString());
						});
						
						JSONObject stations = (JSONObject) mainObject.get("stations");
						
						stations.keySet().forEach((key)->{
							JSONArray stationsList = (JSONArray) stations.get(key);
							
							readMap.getLines().forEach((line)->{
								if(line.getNumber().equals(key.toString())) {
									stationsList.forEach((station)->{
										line.getStations().add(new Station(line.getNumber(), station.toString()));
									});
								}
							});
							
							stationsList.forEach((station)->{
								readMap.addStation(key.toString(), station.toString());
							});
						});
						
						
						//Checking
						System.out.println("\n\nSTATIONS:");
						readMap.getStations().forEach((station)->System.out.println(station.getLineNumber() + ":" + station.getName()));
						
						System.out.println("\n\nLINES:");
						readMap.getLines().forEach((line)->{
							System.out.println(line.getNumber() + ":" + line.getName());
							List<Station> mapStations = line.getStations();
							mapStations.forEach((station)->System.out.println("\t" + station.getName()));
						});
						
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					
					break;
			}
			
		}
	}
}
