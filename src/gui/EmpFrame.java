package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class EmpFrame extends JFrame {
	private TableEmp tableEmp;
	private JButton okBtn;

	private Controller controller;

	public EmpFrame() {
		tableEmp = new TableEmp();
		okBtn = new JButton("OK");
		controller = new Controller();

		tableEmp.setBackground(Color.magenta);

		tableEmp.setData(controller.getStaff());

		setLayout(new BorderLayout());

		add(tableEmp, BorderLayout.CENTER);
		add(okBtn, BorderLayout.PAGE_END);

		setMinimumSize(new Dimension(500, 400));
		setSize(500, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
