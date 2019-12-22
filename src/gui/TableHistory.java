package gui;

import model.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class TableHistory extends JPanel {
	private JTable table;
	private HisTableModel hisTableModel;
	private JPopupMenu popupMenu;
	private HisTableListener hisTableListener;

	public TableHistory(){
		hisTableModel = new HisTableModel();
		table = new JTable(hisTableModel);
		popupMenu = new JPopupMenu();

		JMenuItem removeOrd = new JMenuItem("Remove order");
		popupMenu.add(removeOrd);

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

		removeOrd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();

				if (hisTableListener != null) {
					hisTableListener.rowDeleted(row);
					hisTableModel.fireTableRowsDeleted(row, row);
				}
			}
		});

		setLayout(new BorderLayout());

		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void setData(List<Order> ord){
		hisTableModel.setData(ord);
	}

	public void refresh() {
		hisTableModel.fireTableDataChanged();
	}

	public void setHisTableListener(HisTableListener hisTableListener) {
		this.hisTableListener = hisTableListener;
	}
}
