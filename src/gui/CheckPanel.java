package gui;

import controller.Controller;
import controller.ControllerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckPanel extends JPanel {
	private TablePanel checkTable;
	private JTextArea checkPane;
	private JPanel	checkPanel;

	private ControllerMenu controllerOne;

	private JButton cancelBtn;
	private JButton okButton;

	private MainFrame mainFrame;
	CheckPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;

		checkTable = new TablePanel();
		checkPane = new JTextArea();
		checkPanel = new JPanel();

		controllerOne = new ControllerMenu();

		checkTable.setData(controllerOne.getItems());

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

	//	checkTable.setBackground(Color.magenta);
	//	checkPane.setBackground(Color.GRAY);
	//	checkPanel.setBackground(Color.GREEN);

		checkTable.setPreferredSize(new Dimension(300, 300));

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

		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainFrame();
				mainFrame.dispose();
			}
		});

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainFrame();
				mainFrame.dispose();
			}
		});

		checkPanel.add(cancelBtn);
		checkPanel.add(okButton);
	}
}
