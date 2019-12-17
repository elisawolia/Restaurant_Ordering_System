package controller;

import gui.OrdEvent;
import model.*;
import model.MenuF;

import java.util.List;

public class ControllerMenu {
	private Database DB = new Database();
	private Order ord = new Order();
	private MenuF menu;

	public ControllerMenu() {
		menu = new MenuF();
	}

	public ControllerMenu(int id) {
		menu = new MenuF();
		menu = DB.getItems(id);
	}

	public List<FoodItem> getItems() {
		return ord.getItems();
	}

	public List<FoodItem> getMenu() {
		return menu.getMenu();
	}

	public void addOrd(OrdEvent e) {
		String title = e.getItemName();
		int id = e.getId();
		double price = e.getPrice();
		double size = e.getSize();

		FoodItem item = new FoodItem(id, title, size, price);
		ord.addItem(item);
	}

	public void addItem(OrdEvent e) {
		String itemName = e.getItemName();
		Double size = e.getSize();
		Double price = e.getPrice();
		int typeCat = e.getTypeCat();
		String desc = e.getDesc();
		String path = e.getIcon();

		FoodItem item = new FoodItem(itemName, size, price, typeCat, desc, path);
		DB.addItem(item);
	}

	 public void addOrderToQueue() {
		if (ord != null)
			DB.addOrder(ord);
	 }

	public void removeOrd(int id) {
		DB.removeEmp(id);
	}
}
