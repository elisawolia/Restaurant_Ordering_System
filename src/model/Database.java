package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Database {
	private Staff staff;
	private MenuF menu;
	private MenuF menuFull;
	private LocalDate ld;
	private HistoryOrd orders;

	private static String url = "jdbc:mysql://localhost/restaurant?serverTimezone=Europe/Moscow&useSSL=false";
	private static String user = "root";
	private static String password = "qwerty123";

	public Database(){
		staff = new Staff();
		menu = new MenuF();
	}

	public int getOrdId() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			try (Connection connection = DriverManager.getConnection(url, user, password)){
				int count = 0;
				Statement statement = connection.createStatement();
				ResultSet r = statement.executeQuery("SELECT COUNT(id_order) FROM restaurant.order");
				while (r.next())
					count = r.getInt(1) + 1;
				return count;
			}
		} catch (Exception e) {
			System.out.println("Couldn't get id order!\n");
			System.out.println(e);
		}
		return 0;
	}

	public void updateIngred(Ingredient ingredient) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			try (Connection connection = DriverManager.getConnection(url, user, password)){
				double amount = 0;
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM restaurant.ingred;");
				while (rs.next())
				{
					if (rs.getInt(1) == ingredient.getId())
						amount = rs.getDouble("left");
				}

				amount = amount + ingredient.getLeft();
				statement.executeUpdate("UPDATE `restaurant`.`ingred` SET `left`=" +
						amount + " WHERE (`id_ingred` ='"+ ingredient.getId() + "');");
			}
		} catch (Exception e) {
			System.out.println("Couldn't update ingredient!\n");
			System.out.println(e);
		}
	}

	public AllIngred getIngreds() {
		AllIngred allIngred = new AllIngred();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			try (Connection connection = DriverManager.getConnection(url, user, password)){
				int count = 0;
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM restaurant.ingred;");
				while (rs.next())
				{
					int id = rs.getInt("id_ingred");
					String ingred = rs.getString("ingred");
					double price = rs.getDouble("price_for_unit");
					double left = rs.getDouble("left");

					Ingredient ingredient = new Ingredient(id, ingred, price, left);
					allIngred.addIngred(ingredient);
				}
				return allIngred;
			}
		} catch (Exception e) {
			System.out.println("Couldn't get ingredients!\n");
			System.out.println(e);
			return null;
		}
	}

	public void newIngred(Ingredient ingredient) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			try (Connection connection = DriverManager.getConnection(url, user, password)){
				int count = 0;
				Statement statement = connection.createStatement();
				ResultSet r = statement.executeQuery("SELECT COUNT(id_ingred) FROM ingred");
				while (r.next())
					count = r.getInt(1) + 1;
				statement.executeUpdate("INSERT INTO `restaurant`.`ingred` (`id_ingred`, `ingred`, `price_for_unit`, `left`) " +
						"VALUES ('" + count + "', '"+ ingredient.getIngred() + "', '" + ingredient.getPrice() + "', '"
						+ ingredient.getLeft() + "');");
			}
		} catch (Exception e) {
			System.out.println("Couldn't add to ingredient items!\n");
			System.out.println(e);
		}
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
		menuFull = new MenuF();
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
					menuFull.addItem(item);
				}
				return menuFull;
			}
		} catch (Exception e) {
			System.out.println("Couldn't load menu!\n");
			System.out.println(e);
			return null;
		}
	}

	public HistoryOrd getOrders(int id) {
		orders = new HistoryOrd();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			try (Connection connection = DriverManager.getConnection(url, user, password)){
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("SELECT id_order, date_time, l_name\n" +
						" FROM restaurant.order inner join employee on employee.id_emp = restaurant.order.id_emp");
				while (rs.next())
				{
					int id_ord = rs.getInt("id_order");
					LocalDate date = rs.getDate("date_time").toLocalDate();
					String emp = rs.getString("l_name");


					Period period = Period.between(date, LocalDate.now());
					int diff = period.getDays();
					System.out.println(diff);
					if (id == 0)
					{
						if (diff < 1)
						{
							Order ord = new Order(id_ord, date, emp);
							orders.addOrd(ord);
						}
					} else if (id == 1)
					{
						if (diff < 2)
						{
							Order ord = new Order(id_ord, date, emp);
							orders.addOrd(ord);
						}
					} else if (id == 2)
					{
						if (diff < 7)
						{
							Order ord = new Order(id_ord, date, emp);
							orders.addOrd(ord);
						}
					} else if (id == 3)
					{
						if (diff < 30)
						{
							Order ord = new Order(id_ord, date, emp);
							orders.addOrd(ord);
						}
					} else {
						return null;
					}
				}
				return orders;
			}
		} catch (Exception e) {
			System.out.println("Couldn't add to table employee\n");
			System.out.println(e);
			return null;
		}
	}

	public void removeOrd(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			try (Connection connection = DriverManager.getConnection(url, user, password)){
				Statement statement = connection.createStatement();
				statement.executeUpdate("DELETE FROM `restaurant`.`order` WHERE (`id_order` = '"+ id +"');");
			}
		} catch (Exception e) {
			System.out.println("Couldn't remove an employee from table!\n");
			System.out.println(e);
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
