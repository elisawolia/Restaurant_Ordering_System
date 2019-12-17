package gui;

import controller.ControllerMenu;

import javax.swing.*;
import java.awt.*;

public class OrderPanel extends JPanel {
	private CheckPanel checkPanel;
	private ChoosePanel choosePanel;

	public MainFrame mainFrame;

	private ControllerMenu controllerOne;

	public OrderPanel(MainFrame mainFrame) {
		checkPanel = new CheckPanel();
		choosePanel = new ChoosePanel();

		this.mainFrame = mainFrame;

		controllerOne = new ControllerMenu();

		checkPanel.setTable(controllerOne);

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		checkPanel.setPreferredSize(new Dimension(200, getHeight()));
		choosePanel.setPreferredSize(new Dimension(600, getHeight()));

		checkPanel.setCheckBtn(mainFrame, controllerOne);

		add(choosePanel, BoxLayout.X_AXIS);
		add(checkPanel, BoxLayout.X_AXIS);
	}

	public void setChoosePanel() {
		choosePanel.setOrdListener(new OrdListener() {
			@Override
			public void ordEventOccured(OrdEvent e) {
				if (e.getItemName() != null)
				{
					controllerOne.addOrd(e);
					checkPanel.freshTable();
				}
			}
		});
	}
}
