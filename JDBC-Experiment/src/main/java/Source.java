import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Source {
	public static void main(String [] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/skillbox";
			String login = "root";
			String password = "224486_Nikolas";
			Connection connection = DriverManager.getConnection(url, login, password);
			
			Statement statement = connection.createStatement();
			
//			ResultSet result = statement.executeQuery("select course_name, price, subscription_date from PurchaseList group by course_name, price, subscription_date order by course_name, subscription_date;");
//			ResultSet result = statement.executeQuery("select course_name, price, subscription_date from PurchaseList order by course_name, subscription_date;");
			ResultSet result = statement.executeQuery("select course_name, (truncate( (( count(subscription_date) / ( max(month(subscription_date)) - min(month(subscription_date)) + 1 ) )), 2)) as average_month_ccount  from PurchaseList group by course_name");
			//select course_name, subscription_date from PurchaseList order by course_name, subscription_date;
			while(result.next()) {
				System.out.println(String.format("%-50s", result.getString(1)) + result.getString(2));
//				System.out.println(result.getString(1) + "\t" + result.getString(2));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
