package gui;

import model.Employee;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TableEmp extends JPanel {
	private JTable table;
	private EmpTableModel empTableModel;

	public TableEmp() {
		empTableModel = new EmpTableModel();
		table = new JTable(empTableModel);

		setLayout(new BorderLayout());

		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void setData(List<Employee> staff){
		empTableModel.setData(staff);
	}

	public void refresh() {
		empTableModel.fireTableDataChanged();
	}
}
