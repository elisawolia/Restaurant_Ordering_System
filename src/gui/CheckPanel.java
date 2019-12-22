package gui;

import controller.Controller;
import controller.ControllerMenu;
import model.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class CheckPanel extends JPanel {
	private TablePanel checkTable;
	private JPanel checkPane;
	private JPanel	checkPanel;

	private JButton cancelBtn;
	private JButton okButton;

	private JLabel 	id_order;
	private JLabel	price;
	private JLabel	emp;
	private JLabel	date;
	private Order	ord;

	CheckPanel() {

		checkTable = new TablePanel();
		checkPane = new JPanel();
		checkPanel = new JPanel();

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		checkTable.setPreferredSize(new Dimension(300, 350));

		setButtons();

		add(checkPanel, BoxLayout.X_AXIS);
		add(checkPane, BoxLayout.X_AXIS);
		add(checkTable, BoxLayout.X_AXIS);
	}

	public void setButtons() {
		cancelBtn = new JButton("CANCEL");
		okButton = new JButton("OK");

		checkPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		cancelBtn.setPreferredSize(new Dimension(100, 40));
		okButton.setPreferredSize(new Dimension(100, 40));

		checkPanel.add(cancelBtn);
		checkPanel.add(okButton);
	}

	public void setTable(ControllerMenu controller) {
		checkTable.setData(controller.getItems());
	}

	public void freshTable() {
		checkTable.refresh();
	}

	public void freshPane() {
		checkPane.revalidate();
		checkPane.repaint();
	}

	public void setCheckBtn(MainFrame mainFrame, ControllerMenu controller) {

		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainFrame();
				mainFrame.dispose();
			}
		});

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addOrderToQueue();
				new MainFrame();
				mainFrame.dispose();
			}
		});
	}

	public void setPane(ControllerMenu controller) {
		checkPane.removeAll();
		checkPane.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		ord = controller.getOrd();

		id_order = new JLabel("  ID: " + ord.getIdOrder());
		price = new JLabel("<html><span style='font-size:11px'>" + "Total: " + round(ord.getOrderPrice(), 2) + " $" + "</span></html>");
		emp = new JLabel("  Employee: ");
		date = new JLabel("  Date: " + DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ord.getDate()));

		gc.weighty = 0.1;
		gc.weightx = 1;

		gc.gridy = 0;
		gc.gridx = 0;

		gc.anchor = GridBagConstraints.NORTHWEST;
		checkPane.add(id_order, gc);

		gc.gridy = 1;
		checkPane.add(emp, gc);

		gc.gridy = 2;
		checkPane.add(date, gc);

		gc.gridy = 3;
		gc.weighty = 2;
		checkPane.add(new JLabel(""), gc);

		gc.weighty = 0.1;
		gc.gridy = 0;
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.NORTHEAST;
		checkPane.add(price, gc);
	}

	public static double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}
