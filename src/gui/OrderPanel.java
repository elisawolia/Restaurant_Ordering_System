package gui;

import javax.swing.*;
import java.awt.*;

public class OrderPanel extends JPanel {
	private JPanel checkPanel;
	private JPanel choosePanel;

	public OrderPanel() {
		checkPanel = new JPanel();
		choosePanel = new JPanel();
		JLabel test = new JLabel("TEST");

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		checkPanel.setBackground(Color.magenta);
		choosePanel.setBackground(Color.green);

		add(test, BoxLayout.X_AXIS);
		add(checkPanel, BoxLayout.X_AXIS);
		add(choosePanel, BoxLayout.X_AXIS);
		
	}
}
