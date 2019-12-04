package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
	private JPanel mainImage;
	private JPanel panelButtons;

	private JButton orderButton;
	private JButton historyButton;
	private JButton manageButton;

	public MainPanel(){
		mainImage = new JPanel();
		panelButtons = new JPanel();

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		mainImage.setBackground(Color.ORANGE);
		panelButtons.setBackground(Color.CYAN);

		panelButtons.setPreferredSize(new Dimension(getWidth(), -70));

		add(panelButtons, BoxLayout.X_AXIS);
		add(mainImage, BoxLayout.X_AXIS);

		setButtons();
	}

	public void setButtons() {
		orderButton = new JButton();
		historyButton = new JButton();
		manageButton = new JButton();

		panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 50));

		orderButton.setIcon(new ImageIcon("/Users/elizavetavolianica/IdeaProjects/RestaurantOrderingSystem/src/source/icons/order.png"));
		historyButton.setIcon(new ImageIcon("/Users/elizavetavolianica/IdeaProjects/RestaurantOrderingSystem/src/source/icons/history.png"));
		manageButton.setIcon(new ImageIcon("/Users/elizavetavolianica/IdeaProjects/RestaurantOrderingSystem/src/source/icons/manage.png"));

		manageButton.setPreferredSize(new Dimension(150, 150));
		orderButton.setPreferredSize(new Dimension(150, 150));
		historyButton.setPreferredSize(new Dimension(150, 150));
		

		panelButtons.add(orderButton);
		panelButtons.add(historyButton);
		panelButtons.add(manageButton);

		validate();
	}

}
