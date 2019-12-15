package controller;

import gui.EmpEvent;
import model.*;

import java.util.List;

public class Controller {
	private Database DB = new Database();

	private Staff staff;

	public Controller() {
		staff = DB.getStaff();
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

		DB.addEmp(fName, lName, birth, login, password);
	}

	public void removeEmp(int id) {
		DB.removeEmp(id);
		staff.removeEmp(id);
	}
}
