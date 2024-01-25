package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class NonSelectQuerry {

	public static void main(String[] args) throws SQLException {
		//My SQL instance 
		Driver dataBasedriver = new Driver();
		//JDB Register with My SQL
		DriverManager.registerDriver(dataBasedriver);
		//Connection Establish
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger2", "root", "root");
		//Querry Pass
		 int result = connection.createStatement().executeUpdate("insert into lead values(5, 'Hanuman', 'Kishkinda');");
		 
		 if(result == 1) {
			 System.out.println("The Data base has been updated");
		 }
		 
		 else
			 System.out.println("The Data base has not been updated");
		 
		 connection.close();

	}

}
