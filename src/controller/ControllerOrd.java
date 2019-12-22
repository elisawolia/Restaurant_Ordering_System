package controller;

import model.Database;
import model.HistoryOrd;
import model.Order;

import javax.xml.crypto.Data;
import java.util.List;

public class ControllerOrd {
	private Database DB = new Database();
	private HistoryOrd orders;

	public ControllerOrd(int id) {
		orders = DB.getOrders(id);
	}

	public List<Order> getOrders() {
		return orders.getOrders();
	}

	public void removeOrd(int id) {
		DB.removeOrd(id);
		orders.removeOrd(id);
	}
}
