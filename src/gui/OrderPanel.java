package gui;

import javax.swing.*;
import java.awt.*;

public class OrderPanel extends JPanel {
	private CheckPanel checkPanel;
	private ChoosePanel choosePanel;

	public MainFrame mainFrame;

	public OrderPanel(MainFrame mainFrame) {
		checkPanel = new CheckPanel(mainFrame);
		choosePanel = new ChoosePanel();

		this.mainFrame = mainFrame;

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		checkPanel.setPreferredSize(new Dimension(200, getHeight()));
		choosePanel.setPreferredSize(new Dimension(600, getHeight()));

		checkPanel.setBackground(Color.white);
		choosePanel.setBackground(Color.white);

		add(choosePanel, BoxLayout.X_AXIS);
		add(checkPanel, BoxLayout.X_AXIS);
	}
}
