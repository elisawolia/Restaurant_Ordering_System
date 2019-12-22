package gui;

import controller.Controller;
import controller.ControllerOrd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoryPeriodFrame extends JFrame {
	private TableHistory tableHistory;
	private JButton		okBtn;

	public HistoryPeriodFrame(ControllerOrd controllerOrd) {
		tableHistory = new TableHistory();
		okBtn = new JButton("OK");

		tableHistory.setData(controllerOrd.getOrders());

		setLayout(new BorderLayout());

		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		add(tableHistory, BorderLayout.CENTER);
		add(okBtn, BorderLayout.PAGE_END);

		setMinimumSize(new Dimension(500, 400));
		setSize(500, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	void setHisListener(ControllerOrd controllerOrd) {
		tableHistory.setHisTableListener(new HisTableListener() {
			@Override
			public void rowDeleted(int row) {
				controllerOrd.removeOrd(row);
			}
		});
	}
}
