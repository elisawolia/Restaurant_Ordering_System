package gui;

import model.FoodItem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TablePanel extends JPanel {
	private JTable table;
	private OrderTableModel orderTableModel;

	public TablePanel(){
		orderTableModel = new OrderTableModel();
		table = new JTable(orderTableModel);

		setLayout(new BorderLayout());

		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void setData(List <FoodItem> items){
		orderTableModel.setData(items);
	}

	public void refresh() {
		orderTableModel.fireTableDataChanged();
	}
}
