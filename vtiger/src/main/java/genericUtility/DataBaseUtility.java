package genericUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseUtility {
	
	public String fetchDataFromDataBase(Connection connection, String querry) throws SQLException {
		
		ResultSet result = connection.createStatement().executeQuery(querry);
		while(result.next()) {
			return result.getString(1);
		}
		return "";
		
	}
	
	public void insertDataToDataBase(Connection connection, String querry) throws SQLException {
		
		int result = connection.createStatement().executeUpdate(querry);
		 if(result == 1) {
			 System.out.println("The Data base has been updated");
		 }
		 
		 else
			 System.out.println("The Data base has not been updated");
		 
	}

}
