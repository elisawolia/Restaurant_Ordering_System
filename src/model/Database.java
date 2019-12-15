package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
	private Staff staff;
	private MenuF menu;

	private static String url = "jdbc:mysql://localhost/restaurant?serverTimezone=Europe/Moscow&useSSL=false";
	private static String user = "root";
	private static String password = "qwerty123";

	public Database(){
		staff = new Staff();
		menu = new MenuF();
	}

	public MenuF getItems(int type) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			try (Connection connection = DriverManager.getConnection(url, user, password)){
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM restaurant.items WHERE id_type = " +
						type + ";");
				while (rs.next())
				{
					int id = rs.getInt("id_item");
					String title = rs.getString("title");
					double size = rs.getDouble("size");
					double price = rs.getDouble("price");
					String icon = rs.getString("icon");
					String desc = rs.getString("recipe");

					FoodItem item = new FoodItem(id, title, size, price, icon, desc);
					menu.addItem(item);
				}
				System.out.println("Added to the table!");
				return menu;
			}
		} catch (Exception e) {
			System.out.println("Couldn't load menu!\n");
			System.out.println(e);
			return null;
		}
	}

	public Staff getStaff() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			try (Connection connection = DriverManager.getConnection(url, user, password)){
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM restaurant.employee;");
				while (rs.next())
				{
					int id = rs.getInt("id_emp");
					String fname = rs.getString("f_name");
					String lname = rs.getString("l_name");
					String birth = rs.getString("birth");
					String log = rs.getString("login");

					Employee emp = new Employee(id, fname, lname, birth, log, "");
					staff.addEmp(emp);
				}
				System.out.println("Added to the table!");
				return staff;
			}
		} catch (Exception e) {
			System.out.println("Couldn't add to table employee\n");
			System.out.println(e);
			return null;
		}
	}

	public void addEmp(String fname, String lname, String birth, String login, String emp_password) {
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

	public void removeEmp(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			try (Connection connection = DriverManager.getConnection(url, user, password)){
				Statement statement = connection.createStatement();
				statement.executeUpdate("DELETE FROM `restaurant`.`employee` WHERE (`id_emp` = '"+ id +"');");
				System.out.println("Removed from table!\n");
			}
		} catch (Exception e) {
			System.out.println("Couldn't remove an employee from table!\n");
			System.out.println(e);
		}
	}
}
