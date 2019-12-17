package gui;

import controller.ControllerMenu;
import model.FoodItem;
import model.MenuF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoosePanel extends JPanel {
	private JTabbedPane menuTab;
	private JComponent hDrinksTab;
	private JComponent cDrinksTab;
	private JComponent saladsTab;
	private JComponent mainTab;
	private JComponent breakfastTab;
	private JComponent appetTab;
	private JComponent soupTab;
	private JComponent desertTab;

	private JLabel desertLabel;
	private JLabel soupLabel;
	private JLabel appetLabel;
	private JLabel breakfastLabel;
	private JLabel hDrinksLabel;
	private JLabel cDrinksLabel;
	private JLabel saladsLabel;
	private JLabel mainLabel;

	private MenuF menu;
	private ControllerMenu controller;
	private JPanel[] menuPanel;

	private JLabel title;
	private JLabel price;
	private JLabel size;
	private JLabel desc;
	private JButton addBth;
	private ImageIcon iconIm;
	private JLabel icon;

	private OrdListener ordListener;

	public ChoosePanel() {

		GridLayout gl = new GridLayout(1,1);

		this.setLayout(gl);

		menuTab = new JTabbedPane();

		breakfastTab = makeTextPanel("Breakfast");
		menuTab.addTab("", new JScrollPane(breakfastTab));
		breakfastLabel = new JLabel("<html><span style='font-size:12px'>"+"Breakfast"+"</span></html>");
		menuTab.setTabComponentAt(0,breakfastLabel);

		appetTab = makeTextPanel("Appetizers");
		menuTab.addTab("", new JScrollPane(appetTab));
		appetLabel = new JLabel("<html><span style='font-size:12px'>"+"Appetizers"+"</span></html>");
		menuTab.setTabComponentAt(1,appetLabel);

		saladsTab = makeTextPanel("Salads");
		menuTab.addTab("", new JScrollPane(saladsTab));
		saladsLabel = new JLabel("<html><span style='font-size:12px'>"+"Salads"+"</span></html>");
		menuTab.setTabComponentAt(2,saladsLabel);

		soupTab = makeTextPanel("Soups");
		menuTab.addTab("", new JScrollPane(soupTab));
		soupLabel = new JLabel("<html><span style='font-size:12px'>"+"Soups"+"</span></html>");
		menuTab.setTabComponentAt(3,soupLabel);

		mainTab = makeTextPanel("Main Course");
		menuTab.addTab("", new JScrollPane(mainTab));
		mainLabel = new JLabel("<html><span style='font-size:12px'>"+"Main Course"+"</span></html>");
		menuTab.setTabComponentAt(4,mainLabel);

		desertTab = makeTextPanel("Deserts");
		menuTab.addTab("", new JScrollPane(desertTab));
		desertLabel = new JLabel("<html><span style='font-size:12px'>"+"Deserts"+"</span></html>");
		menuTab.setTabComponentAt(5,desertLabel);

		hDrinksTab = makeTextPanel("Hot Beverage");
		menuTab.addTab("Hot Drinks", new JScrollPane(hDrinksTab));
		hDrinksLabel = new JLabel("<html><span style='font-size:12px'>"+"Hot Beverage"+"</span></html>");
		menuTab.setTabComponentAt(6,hDrinksLabel);

		cDrinksTab = makeTextPanel("Cold Beverage");
		menuTab.addTab("Cold Drinks", new JScrollPane(cDrinksTab));
		cDrinksLabel = new JLabel("<html><span style='font-size:12px'>"+"Cold Beverage"+"</span></html>");
		menuTab.setTabComponentAt(7,cDrinksLabel);

		add(menuTab);
		menuTab.setTabPlacement(SwingConstants.LEFT);
		menuTab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}
	private JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);

		switch (text) {
			case "Breakfast":
				setPanels(panel, 3);
				return panel;
			case "Appetizers":
				setPanels(panel, 4);
				return panel;
			case "Salads":
				setPanels(panel, 1);
				return panel;
			case "Soups":
				setPanels(panel, 5);
				return panel;
			case "Main Course":
				setPanels(panel, 2);
				return panel;
			case "Deserts":
				setPanels(panel, 6);
				return panel;
			case "Hot Beverage":
				setPanels(panel, 7);
				return panel;
			case "Cold Beverage":
				setPanels(panel, 8);
				return panel;
		}
		return panel;
	}

	private void setPanels(JPanel panel, int type) {
		controller = new ControllerMenu(type);

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		menu = new MenuF();
		menu.setMenu(controller.getMenu());
		menuPanel = new JPanel[menu.Msize()];

		for(int index = 0; index < menu.Msize(); index++){

			menuPanel[index] = new JPanel();

			setP(menuPanel[index], menu.getItem(index));

			panel.add(menuPanel[index]);
		}

	}

	private void setP(JPanel panel, FoodItem item) {
		panel.setMaximumSize(new Dimension(440, 140));
		panel.setBorder(BorderFactory.createLineBorder(Color.black));

		title = new JLabel("<html><span style='font-size:13px'><Strong>"+item.getItemName()+"</span></html>");
		price = new JLabel("<html><span style='font-size:12px'>"+String.valueOf(item.getPrice()) + " $"+"</span></html>");
		size = new JLabel("<html><span style='font-size:12px'>"+String.valueOf(item.getSize()) + " g."+"</span></html>");
		addBth = new JButton("Add");
		iconIm = new ImageIcon(item.getIcon());
		icon = new JLabel();
		icon.setIcon(iconIm);
		icon.setBorder(BorderFactory.createLineBorder(Color.black));


		panel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.weighty = 1;
		gc.weightx = 1;
		gc.gridy = 0;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridheight = 4;
		panel.add(icon, gc);

		gc.weighty = 0.7;
		gc.weighty = 0.7;
		gc.gridx = 1;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 10);
		panel.add(new JLabel("<html><span style='font-size:11px'>"+"Price: "+"</span></html>"), gc);

		gc.gridy++;
		panel.add(new JLabel("<html><span style='font-size:11px'>"+"Size: "+"</span></html>"), gc);

		gc.gridx = 2;
		gc.gridy = 0;
		gc.insets = new Insets(15, 0, 0, 10);
		gc.anchor = GridBagConstraints.LINE_START;
		panel.add(title, gc);

		gc.gridy++;
		gc.insets = new Insets(0, 0, 0, 0);
		panel.add(price, gc);

		gc.gridy++;

		panel.add(size, gc);

		gc.gridy++;
		gc.insets = new Insets(0, 0, 10, 0);
		panel.add(addBth, gc);

		addBth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String itemName = item.getItemName();
				int id = item.getId();
				double size = item.getSize();
				double price = item.getPrice();

				OrdEvent ord = new OrdEvent(this, id, itemName, size, price);

				if (ordListener != null) {
					ordListener.ordEventOccured(ord);
				}
			}
		});
	}

	public void setOrdListener(OrdListener listener) {
		this.ordListener = listener;
	}
}
