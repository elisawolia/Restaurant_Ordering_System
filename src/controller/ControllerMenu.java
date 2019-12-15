package controller;

import gui.EmpEvent;
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

	public void addOrd(EmpEvent e) {
		String fName = e.getfName();
		String lName = e.getlName();
		String birth = e.getBirth();
		String login = e.getLogin();
		String password = e.getPassword();

		DB.addEmp(fName, lName, birth, login, password);
	}

	public void removeOrd(int id) {
		DB.removeEmp(id);
	}
}
