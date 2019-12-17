package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Database {
	private Staff staff;
	private MenuF menu;
	private LocalDate ld;

	private static String url = "jdbc:mysql://localhost/restaurant?serverTimezone=Europe/Moscow&useSSL=false";
	private static String user = "root";
	private static String password = "qwerty123";

	public Database(){
		staff = new Staff();
		menu = new MenuF();
	}

	public void addItem(FoodItem item) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			try (Connection connection = DriverManager.getConnection(url, user, password)){
				int count = 0;
				Statement statement = connection.createStatement();
				ResultSet r = statement.executeQuery("SELECT COUNT(id_item) FROM items");
				while (r.next())
					count = r.getInt(1) + 1;
				statement.executeUpdate("INSERT INTO items (id_item, title, size, price, recipe, id_type, icon) " +
						" VALUES (" + count + ",'"+ item.getItemName() + "', " + item.getSize() + " , " + item.getPrice() + ",'" +
						item.getDesc() + "'," + item.getTypeCategory() + ",'" + item.getIcon() + "' );");
			}
		} catch (Exception e) {
			System.out.println("Couldn't add to table items!\n");
			System.out.println(e);
		}
	}

	public void addOrder(Order ord) {
		List<FoodItem> items = ord.getItems();
		if (items.isEmpty())
			return ;
		try {
			ld = LocalDate.now();
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			try (Connection connection = DriverManager.getConnection(url, user, password)){
				int count = 0;
				Statement statement = connection.createStatement();
				ResultSet r = statement.executeQuery("SELECT COUNT(id_order) FROM restaurant.order");
				while (r.next())
					count = r.getInt(1) + 1;
				statement.executeUpdate("INSERT INTO restaurant.order (id_order, id_emp, date_time) " +
						"VALUES (" + count + ",'"+ 0 + "', '" + DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ld) + "' );");
				for (int i = 0; i < items.size(); i++)
				{
					statement.executeUpdate("INSERT INTO order_has_items (id_order, id_item)" +
							" VALUES ( " + count + ", "+ items.get(i).getId() + " );");
				}
			}
		} catch (Exception e) {
			System.out.println("Couldn't add to table order!\n");
			System.out.println(e);
		}
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
			}
		} catch (Exception e) {
			System.out.println("Couldn't remove an employee from table!\n");
			System.out.println(e);
		}
	}
}
