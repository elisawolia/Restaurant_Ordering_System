package gui;

import model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class TableEmp extends JPanel {
	private JTable table;
	private EmpTableModel empTableModel;
	private JPopupMenu popupMenu;
	private EmpTableListener empTableListener;

	public TableEmp() {
		empTableModel = new EmpTableModel();
		table = new JTable(empTableModel);
		popupMenu = new JPopupMenu();

		JMenuItem removeEmp = new JMenuItem("Remove person");
		popupMenu.add(removeEmp);

		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());

				table.getSelectionModel().setSelectionInterval(row, row);

				if (e.getButton() == MouseEvent.BUTTON3) {
					popupMenu.show(table, e.getX(), e.getY());
				}
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
		});

		removeEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();

				if (empTableListener != null) {
					empTableListener.rowDeleted(row);
					empTableModel.fireTableRowsDeleted(row, row);
				}
			}
		});

		setLayout(new BorderLayout());

		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void setData(List<Employee> staff){
		empTableModel.setData(staff);
	}

	public void refresh() {
		empTableModel.fireTableDataChanged();
	}

	public void setEmpTableListener(EmpTableListener empTableListener) {
		this.empTableListener = empTableListener;
	}
}
