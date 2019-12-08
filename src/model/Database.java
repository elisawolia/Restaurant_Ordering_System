package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
	private Staff staff;

	private static String url = "jdbc:mysql://localhost/restaurant?serverTimezone=Europe/Moscow&useSSL=false";
	private static String user = "root";
	private static String password = "qwerty123";

	public Database(){
	}

	public static void addEmp(String fname, String lname, String birth, String login, String emp_password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			try (Connection connection = DriverManager.getConnection(url, user, password)){
				int count = 0;
				Statement statement = connection.createStatement();
				ResultSet r = statement.executeQuery("SELECT COUNT(id_emp) FROM employee");
				while (r.next())
					count = r.getInt(1);
				int res = statement.executeUpdate("INSERT employee (id_emp, f_name, l_name, birth, login, emp_password) " +
						"VALUES (" + count + ",'"+ fname + "', '" + lname + "' , '" + birth + "','" +
						login + "','" + emp_password + "' );");
				System.out.println("Added to the table!");
			}
		} catch (Exception e) {
			System.out.println("Couldn't add to table employee\n");
			System.out.println(e);
		}
	}
}
