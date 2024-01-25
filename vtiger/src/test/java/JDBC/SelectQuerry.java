package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class SelectQuerry {

	public static void main(String[] args) throws SQLException {
		//My SQL instance 
		Driver dataBasedriver = new Driver();
		//JDB Register with My SQL
		DriverManager.registerDriver(dataBasedriver);
		//Connection Establish
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger2", "root", "root");
		//Querry Pass
		ResultSet result = connection.createStatement().executeQuery("select * from lead;");
		//Result
		while(result.next()) {
			
			System.out.println(result.getString(1));
		}

		connection.close();
	}

}
