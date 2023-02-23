package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

public class JDBCDemo {

	public static void main(String[] args) throws SQLException {
		// connection is an interface which has its own methods to create connection or
		// close connection, etc.
		ResultSet resultSet;
		Connection connection;
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/harinder", "root", "password");
		System.out.println("Connection established");

		// execute query
		
		Statement statement = connection.createStatement();

		String queryForMaleEmployees = "select * from employee where sex='M' ";
		resultSet = statement.executeQuery(queryForMaleEmployees);
		System.out.println(resultSet);

		while (resultSet.next()) {
			String employeeFirstName = resultSet.getString("first_name");
			System.out.println(employeeFirstName);
			
		}

		// for 1 record
//		Employee employee = new Employee();
//		while (resultSet.next()) {
//			employee.setFirst_name(resultSet.getString("first_name"));
//		}
//		System.out.println(employee.getFirst_name());

		// for multiple records
		/*
		 * ArrayList<Employee> employeeList = new ArrayList<Employee>(); while
		 * (resultSet.next()) { Employee employee = new Employee();
		 * employee.setFirst_name(resultSet.getString("first_name"));
		 * employeeList.add(employee); }
		 * System.out.println(employeeList.get(2).getFirst_name());
		 */
		connection.close();

	}

}
