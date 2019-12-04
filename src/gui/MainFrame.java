package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
	private MainPanel mainPanel;
	private OrderPanel orderPanel;

	public MainFrame(){
		super("Ordering System");

		setLayout(new BorderLayout());
		mainPanel = new MainPanel();
		orderPanel = new OrderPanel();

	//	orderPanel.setVisible(false);
	//	orderPanel.setBackground(Color.green);

		getContentPane().add(mainPanel);

		setVisible(true);
		setMinimumSize(new Dimension(800, 600));
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
	}
}
