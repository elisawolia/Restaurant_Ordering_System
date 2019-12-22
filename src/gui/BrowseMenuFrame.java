package gui;

import controller.ControllerIngred;
import controller.ControllerMenu;
import controller.ControllerOrd;
import model.FoodItem;
import model.MenuF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrowseMenuFrame extends JFrame {
	private JPanel menuPanel;
	private JPanel btnPabel;

	private JButton	okBtn;
	private	JButton	newIngred;
	private JButton	addIngred;

	private ControllerMenu controller;
	private ControllerIngred controllerIngred;
	private MenuF	menu;
	private JPanel	[]panel;

	private JLabel	title;
	private JLabel	rec;
	private JButton showIngred;
	private JButton	addIngredItem;
	private JButton	edit;
	private	JButton	remove;

	public BrowseMenuFrame(){
		setLayout(new BorderLayout());

		menuPanel = new JPanel(false);
		btnPabel = new JPanel();

		btnPabel.setPreferredSize(new Dimension(700, 70));

		setPanel();
		setButtons();

		add(new JScrollPane(menuPanel), BorderLayout.CENTER);
		add(btnPabel, BorderLayout.PAGE_END);

		setMinimumSize(new Dimension(700, 650));
		setSize(700, 650);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	void setButtons() {
		okBtn = new JButton("        Ok        ");
		newIngred = new JButton("New Ingredient");
		addIngred = new JButton("Add Ingredient");

		controllerIngred = new ControllerIngred();

		addIngred.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				UpdateIngredFrame updateIngredFrame = new UpdateIngredFrame();
				updateIngredFrame.setContr(controllerIngred);
				updateIngredFrame.setIngerListener(new IngredListener() {
					public void ingredEventOccured(IngredEvent e) {
						if (e.getLeft() != 0) {
							controllerIngred.updateIngred(e);
						}
					}
				});
			}
		});

		newIngred.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddIngredFrame ingredFrame = new AddIngredFrame();
				ingredFrame.setIngerListener(new IngredListener() {
					public void ingredEventOccured(IngredEvent e) {
						if (e.getIngred() != null)
							controllerIngred.addIngred(e);
					}
				});
			}
		});

		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnPabel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.weighty = 1;
		gc.weightx = 1;
		gc.gridx = 0;
		gc.gridy = 0;

		gc.insets = new Insets(0, 90, 0, 0);
		btnPabel.add(newIngred, gc);

		gc.gridx++;
		gc.insets = new Insets(0, 0, 0, 0);
		btnPabel.add(addIngred, gc);

		gc.gridx++;
		gc.insets = new Insets(0, 00, 0, 90);
		btnPabel.add(okBtn, gc);
	}

	void setPanel() {
		controller = new ControllerMenu();
		controller.getAllItems();

		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.PAGE_AXIS));

		menu = new MenuF();
		menu.setMenu(controller.getMenu());
		panel = new JPanel[menu.Msize()];

		for(int index = 0; index < menu.Msize(); index++){

			panel[index] = new JPanel();

			setP(panel[index], menu.getItem(index));

			menuPanel.add(panel[index]);
		}
	}

	private void setP(JPanel panel, FoodItem item) {
		panel.setPreferredSize(new Dimension(650, 200));
		panel.setBorder(BorderFactory.createLineBorder(Color.black));

		title = new JLabel("<html><span style='font-size:13px'><Strong>"+item.getItemName()+"</span></html>");
		rec = new JLabel(item.getDesc());
		JPanel panelBtn = new JPanel();

		panel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.weighty = 1;
		gc.weightx = 1;
		gc.gridy = 0;
		gc.gridx = 0;
		panel.add(title, gc);

		gc.gridy++;
		panel.add(rec, gc);

		gc.gridy++;
		setBtnP(panelBtn, item);
		panel.add(panelBtn, gc);
	}

	private void setBtnP(JPanel panel, FoodItem item) {
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		showIngred = new JButton("Show Ingredients");
		addIngredItem = new JButton("Add Ingredients");
		edit = new JButton("Edit");
		remove = new JButton("Remove");

		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridx = 0;
		gc.gridy = 0;
		panel.add(showIngred, gc);
		gc.gridx++;
		panel.add(addIngredItem, gc);
		gc.gridx++;
		panel.add(edit, gc);
		gc.gridx++;
		panel.add(remove, gc);
	}
}
