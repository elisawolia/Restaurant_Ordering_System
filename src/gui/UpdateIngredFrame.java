package gui;

import controller.ControllerIngred;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateIngredFrame extends JFrame {
	private JLabel ingredLabel;
	private JComboBox	ingerList;
	private JLabel amountLabel;
	private JTextField	amountField;
	private JButton	okBtn;
	private JButton cancelBtn;

	private IngredListener ingredListener;

	public UpdateIngredFrame() {
		ingredLabel = new JLabel("Ingredient: ");
		amountLabel = new JLabel("Add amount: ");
		amountField = new JTextField(8);
		okBtn = new JButton("Update");
		cancelBtn = new JButton("Cancel");

		setMinimumSize(new Dimension(300, 200));
		setSize(300, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public void setContr(ControllerIngred controller) {
		String[] s = controller.getNames();
		ingerList = new JComboBox(s);

		ingerList.setSelectedIndex(0);

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.weighty = 0.8;
		gc.weightx = 1;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(15, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(ingredLabel, gc);

		gc.gridx++;
		gc.insets = new Insets(15, 5, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(ingerList, gc);

		gc.gridy++;
		gc.insets = new Insets(0, 5, 0, 0);
		add(amountField, gc);

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(amountLabel, gc);

		gc.gridy++;
		gc.weighty = 1;
		gc.insets = new Insets(0, 0, 0, 10);
		add(cancelBtn, gc);

		gc.gridx++;
		gc.insets = new Insets(0, 20, 0, 00);
		gc.anchor = GridBagConstraints.LINE_START;
		add(okBtn, gc);

		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = ingerList.getSelectedIndex() + 1;
				if (amountField.getText().isEmpty())
					return ;
				double amount =  Double.parseDouble(amountField.getText());

				IngredEvent ingredEvent = new IngredEvent(this, id, amount);
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
