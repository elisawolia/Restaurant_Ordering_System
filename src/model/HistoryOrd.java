package model;

import java.util.LinkedList;
import java.util.List;

public class HistoryOrd {
	private List<Order> orders;

	public HistoryOrd() {
		orders = new LinkedList<Order>();
	}

	public void addOrd(Order order) {
		orders.add(order);
	}

	public void removeOrd(int id) {
		orders.remove(id);
	}

	public List<Order> getOrders() {
		return orders;
	}

	public Order getOrd(int id) {
		return orders.get(id);
	}
}
