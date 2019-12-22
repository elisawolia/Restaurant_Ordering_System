package model;

import java.time.LocalDate;
import java.util.*;

public class Order {
	private Database	DB = new Database();
	private int idOrder;
	private List<FoodItem> items;
	private double orderPrice;
	private LocalDate date;
	private String staff;

	public Order() {
		this.idOrder = DB.getOrdId();
		items = new LinkedList<FoodItem>();
		this.orderPrice = 0;
		this.date = LocalDate.now();
	}

	public Order(int id, LocalDate date, String staff) {
		this.idOrder = id;
		this.date = date;
		this.staff = staff;
	}

	public void addItem(FoodItem item) {
		items.add(item);
		this.orderPrice += item.getPrice();
	}

	public String getStaff() {
		return staff;
	}

	public List<FoodItem> getItems() {
		return Collections.unmodifiableList(items);
	}

	public int getIdOrder() {
		return idOrder;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public LocalDate getDate() {
		return date;
	}

	public void removeItem(int index) {
		items.remove(index);
	}
}
