package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCAssignment {

	public static void main(String[] args) throws SQLException {

		ResultSet resultSet;
		Connection connection;
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/harinder", "root", "password");
		Statement statement = connection.createStatement();

		String queryForMinAndMaxSalary = "SELECT salary FROM employee WHERE salary = (SELECT MAX(salary) FROM employee ) OR salary = (SELECT MIN(salary) FROM employee)";
		resultSet = statement.executeQuery(queryForMinAndMaxSalary);
		while (resultSet.next()) {
			int minAndMaxSalary = resultSet.getInt("salary");
			System.out.println(minAndMaxSalary);
		}
			
		String queryForSecondHighestSalary = "select MAX(salary) as salary from employee where salary<(select MAX(salary) from employee)";
		resultSet = statement.executeQuery(queryForSecondHighestSalary);
		while (resultSet.next()) {
			int secondHighestSalary = resultSet.getInt("salary");
			System.out.println("Second highest salary : "+secondHighestSalary);
		}
		
	}

}
