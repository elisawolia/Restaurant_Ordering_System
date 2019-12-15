package gui;

import model.Employee;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EmpTableModel extends AbstractTableModel {
	private List<Employee> staff;
	private String[] colNames = {"Id", "First name", "Last name", "Birth", "Login"};


	public EmpTableModel() {
	}

	public void setData(List <Employee> staff) {
		this.staff = staff;
	}

	public String getColumnName(int column) {
		return colNames[column];
	}

	public int getRowCount() {
		return staff.size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Employee emp = staff.get(rowIndex);

		switch(columnIndex) {
			case 0:
				return emp.getId();
			case 1:
				return emp.getfName();
			case 2:
				return emp.getlName();
			case 3:
				return emp.getBirth();
			case 4:
				return emp.getLogin();
		}
		return null;
	}
}
