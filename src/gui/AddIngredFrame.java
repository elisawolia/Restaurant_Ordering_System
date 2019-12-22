package gui;

import controller.ControllerOrd;
import model.Ingredient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddIngredFrame extends JFrame {
	private JLabel	titleLabel;
	private JLabel	priceLabel;
	private JTextField	title;
	private JTextField	price;
	private JButton		cancel;
	private JButton		add;

	private IngredListener ingredListener;

	public AddIngredFrame() {
		titleLabel = new JLabel("Ingredient: ");
		title = new JTextField(10);
		priceLabel = new JLabel("Price for one unit: ");
		price = new JTextField(10);
		cancel = new JButton("Cancel");
		add = new JButton("Add");

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.weighty = 0.8;
		gc.weightx = 1;
		gc.gridy = 0;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(15, 10, 0, 0);
		add(titleLabel, gc);

		gc.gridx++;
		gc.insets = new Insets(15, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(title, gc);

		gc.gridy++;
		gc.insets = new Insets(0, 0, 0, 0);
		add(price, gc);

		gc.gridx = 0;
		gc.insets = new Insets(0, 10, 0, 0);
		gc.anchor = GridBagConstraints.LINE_END;
		add(priceLabel, gc);

		gc.weighty = 1;
		gc.gridy++;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 8);
		add(cancel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 8, 0, 0);
		add(add, gc);

		setBtn();

		setMinimumSize(new Dimension(300, 200));
		setSize(300, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	private void setBtn(){
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ingred = title.getText();
				if (title.getText().isEmpty())
					return ;
				double priceOne =  Double.parseDouble(price.getText());
				if (price.getText().isEmpty())
					return ;
				IngredEvent ingredEvent = new IngredEvent(this, ingred, priceOne, 0.0);

				if (ingredListener != null) {
					ingredListener.ingredEventOccured(ingredEvent);
				}
				dispose();
			}
		});
	}

	public void setIngerListener(IngredListener ingredListener) {
		this.ingredListener = ingredListener;
	}
}
