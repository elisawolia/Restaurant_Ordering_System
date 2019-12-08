package controller;

import gui.EmpEvent;
import model.*;

import java.util.List;

public class Controller {
	Database DB = new Database();
	Order ord = new Order();
	Staff staff = new Staff();

	public void Controller() {

	}

	public List<FoodItem> getItems() {
		return ord.getItems();
	}

	public List<Employee> getStaff() {
		return staff.getStaff();
	}

	public void addEmp(EmpEvent e) {
		String fName = e.getfName();
		String lName = e.getlName();
		String birth = e.getBirth();
		String login = e.getLogin();
		String password = e.getPassword();

		Employee emp = new Employee(fName, lName, birth, login, password);
		DB.addEmp(fName, lName, birth, login, password);
	}
}
