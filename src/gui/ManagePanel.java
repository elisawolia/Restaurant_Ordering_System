package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class ManagePanel extends JFrame {
	private JPanel staffPanel;
	private JPanel menuPanel;

	private JButton addStaff;
	private JButton lookStuff;

	private JButton addItem;
	private JButton lookItem;

	private MainFrame mainFrame;
	private Controller controller;

	public ManagePanel(MainFrame mainFrame){
		this.mainFrame = mainFrame;

		staffPanel = new JPanel();
		menuPanel = new JPanel();

		controller = new Controller();

		setLayout(new BorderLayout());

		Border staffOuterBorder = BorderFactory.createTitledBorder("STUFF");
		Border staffInnerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 5);
		staffPanel.setBorder(BorderFactory.createCompoundBorder(staffInnerBorder,staffOuterBorder));

		Border menuOuterBorder = BorderFactory.createTitledBorder("MENU");
		Border menuInnerBorder = BorderFactory.createEmptyBorder(10, 5, 10, 10);
		menuPanel.setBorder(BorderFactory.createCompoundBorder(menuInnerBorder,menuOuterBorder));


		staffPanel.setBackground(Color.GREEN);
		menuPanel.setBackground(Color.magenta);

		staffPanel.setPreferredSize(new Dimension(300, 150));
		menuPanel.setPreferredSize(new Dimension(300, 150));

		setStuffButtons();
		setMenuButtons();

		add(staffPanel, BorderLayout.LINE_START);
		add(menuPanel, BorderLayout.LINE_END);

		setMinimumSize(new Dimension(600, 250));
		setSize(600, 250);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	private void setStuffButtons(){
		addStaff = new JButton("Add Employee");
		lookStuff = new JButton("Browse Stuff");

		staffPanel.setLayout(new GridLayout(1,2));

		addStaff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					AddStaffFrame addStaffFrame = new AddStaffFrame();
					addStaffFrame.setEmpListener(new EmpListener() {
						public void empEventOccured(EmpEvent e) {
							if (e.getfName() != null)
								controller.addEmp(e);
							addStaffFrame.dispose();
						}
					});
				} catch (ParseException ex) {
					ex.printStackTrace();
				}
			}
		});

		lookStuff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EmpFrame empFrame = new EmpFrame();
				empFrame.setOk(empFrame);
			}
		});

		staffPanel.add(addStaff);
		staffPanel.add(lookStuff);
	}


	private void setMenuButtons(){
		addItem = new JButton("Add Item");
		lookItem = new JButton("Browse Menu");

		menuPanel.setLayout(new GridLayout(1,2));

		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddItemFrame addItemFrame = new AddItemFrame();
				} catch (ParseException ex) {
					ex.printStackTrace();
				}
			}
		});

		menuPanel.add(addItem);
		menuPanel.add(lookItem);
	}

}
