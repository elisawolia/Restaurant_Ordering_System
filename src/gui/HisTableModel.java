package gui;

import model.Employee;
import model.Order;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class HisTableModel extends AbstractTableModel {
	private List<Order> ord;
	private String[] colNames = {"Id", "Date", "Employee"};

	public void setData(List <Order> ord) {
		this.ord = ord;
	}

	public String getColumnName(int column) {
		return colNames[column];
	}

	@Override
	public int getRowCount() {
		return ord.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Order o = ord.get(rowIndex);

		switch(columnIndex) {
			case 0:
				return o.getIdOrder();
			case 1:
				return o.getDate();
			case 2:
				return o.getStaff();
		}
		return null;
	}
}
