package gui;

import model.FoodItem;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class OrderTableModel extends AbstractTableModel {
	private List<FoodItem> items;
	private String[] colNames = {"Item", "Size", "Price"};

	public OrderTableModel() {
	}

	public void setData(List<FoodItem> items) {
		this.items = items;
	}

	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}

	@Override
	public int getRowCount() {
		return items.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		FoodItem item = items.get(rowIndex);

		switch(columnIndex) {
			case 0:
				return item.getItemName();
			case 1:
				return item.getSize();
			case 2:
				return item.getPrice();
		}
		return null;
	}
}
