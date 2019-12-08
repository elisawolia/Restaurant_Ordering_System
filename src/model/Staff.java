package model;

import java.util.LinkedList;
import java.util.List;

public class Staff {
	private List<Employee> staff;

	public Staff() {
		staff = new LinkedList<Employee>();
	}

	public void addEmp(Employee employee) {
		staff.add(employee);
	}

	public void removeEmp(int id) {
		staff.remove(id);
	}

	public List<Employee> getStaff() {
		return staff;
	}

	public Employee getEmp(int id) {
		return staff.get(id);
	}
}
