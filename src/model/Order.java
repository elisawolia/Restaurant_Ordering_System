package model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Order {
	private static int count = 0;
	private int idOrder;
	private List<FoodItem> items;
	private double orderPrice;


	public Order() {
		this.idOrder = count;
		items = new LinkedList<FoodItem>();
		this.orderPrice = 0;

		count++;
	}

	public void addItem(FoodItem item) {
		items.add(item);
		this.orderPrice += item.getPrice();
	}

	public List<FoodItem> getItems() {
		return Collections.unmodifiableList(items);
	}

	public void removeItem(int index) {
		items.remove(index);
	}
}