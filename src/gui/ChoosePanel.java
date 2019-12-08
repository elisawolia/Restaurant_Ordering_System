package gui;

import javax.swing.*;
import javax.swing.plaf.TabbedPaneUI;
import java.awt.*;

public class ChoosePanel extends JPanel {
	private JTabbedPane menuTab;
	private JComponent hDrinksTab;
	private JComponent cDrinksTab;
	private JComponent saladsTab;
	private JComponent mainTab;

	private JLabel hDrinksLabel;
	private JLabel cDrinksLabel;
	private JLabel saladsLabel;
	private JLabel mainLabel;

	public ChoosePanel() {
		super(new GridLayout(1, 1));

		menuTab = new JTabbedPane();

		saladsTab = makeTextPanel("Salads");
		menuTab.addTab("", saladsTab);

		saladsLabel = new JLabel("<html><span style='font-size:12px'>"+"Salads"+"</span></html>");
		menuTab.setTabComponentAt(0,saladsLabel);

		mainTab = makeTextPanel("Main");
		menuTab.addTab("", mainTab);

		mainLabel = new JLabel("<html><span style='font-size:12px'>"+"Main"+"</span></html>");
		menuTab.setTabComponentAt(1,mainLabel);

		hDrinksTab = makeTextPanel("Hot Drinks");
		menuTab.addTab("Hot Drinks", hDrinksTab);

		hDrinksLabel = new JLabel("<html><span style='font-size:12px'>"+"Hot Drinks"+"</span></html>");
		menuTab.setTabComponentAt(2,hDrinksLabel);

		cDrinksTab = makeTextPanel("Cold Drinks");
		menuTab.addTab("Cold Drinks", cDrinksTab);

		cDrinksLabel = new JLabel("<html><span style=\"font-size:12px\">"+"Cold Drinks"+"</span></html>");
		menuTab.setTabComponentAt(3,cDrinksLabel);

		add(menuTab);
		menuTab.setTabPlacement(SwingConstants.LEFT);
		menuTab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}
	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}
}
