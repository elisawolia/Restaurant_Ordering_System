package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpFrame extends JFrame {
	private TableEmp tableEmp;
	private JButton okBtn;

	private Controller controller;

	public EmpFrame() {
		tableEmp = new TableEmp();
		okBtn = new JButton("OK");
		controller = new Controller();

	//	tableEmp.setBackground(Color.magenta);

		tableEmp.setData(controller.getStaff());

		tableEmp.setEmpTableListener(new EmpTableListener() {
			public void rowDeleted(int row) {
				controller.removeEmp(row);
			}
		});

		setLayout(new BorderLayout());

		add(tableEmp, BorderLayout.CENTER);
		add(okBtn, BorderLayout.PAGE_END);

		setMinimumSize(new Dimension(500, 400));
		setSize(500, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public void setOk(JFrame frame) {
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}
}
