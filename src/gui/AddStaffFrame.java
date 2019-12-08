package gui;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class AddStaffFrame extends JFrame {
	private JLabel space;
	private JLabel fNameLabel;
	private JLabel lNameLabel;
	private JLabel birthLabel;
	private JLabel loginLabel;
	private JLabel passLabel;
	private JTextField fnameField;
	private JTextField lnameField;
	private JFormattedTextField birthField;
	private JTextField loginField;
	private JPasswordField passField;
	private JButton cancelBtn;
	private JButton addBtn;

	private EmpListener empListener;

	public AddStaffFrame() throws ParseException {
		setLayout(new GridBagLayout());

		space = new JLabel("");
		fNameLabel = new JLabel("First name:");
		fnameField = new JTextField(15);
		lNameLabel = new JLabel("Last name:");
		lnameField = new JTextField(15);
		birthLabel = new JLabel("Birth date:");
		birthField = new JFormattedTextField(new MaskFormatter("####-##-##"));
		loginLabel = new JLabel("Login:");
		loginField = new JTextField(15);
		passLabel = new JLabel("Password:");
		passField = new JPasswordField(15);

		cancelBtn = new JButton("Cancel");
		addBtn = new JButton("Add");

		////////// ADD BUTTON //////////

		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname = fnameField.getText();
				String lname = lnameField.getText();
				String birth = birthField.getText();
				String login = loginField.getText();
				String password = toString().valueOf(passField.getPassword());

				EmpEvent emp = new EmpEvent(this, fname, lname, birth, login, password);

				if (empListener != null) {
					empListener.empEventOccured(emp);
				}
			}
		});

		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EmpEvent emp = new EmpEvent(this);

				if (empListener != null) {
					empListener.empEventOccured(emp);
				}
			}
		});

		setButtons();

		setMinimumSize(new Dimension(400, 400));
		setSize(400, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	private void setButtons() {
		GridBagConstraints gc = new GridBagConstraints();

		gc.weighty = 0.3;
		gc.weightx = 1;
		gc.gridx = 0;
		gc.gridy = 0;

		add(space, gc);

		gc.gridy++;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(fNameLabel, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(fnameField, gc);

		gc.gridy++;
		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(lnameField, gc);

		gc.gridx = 0;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(lNameLabel, gc);

		gc.gridy++;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(birthLabel, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		birthField.setColumns(10);
		add(birthField, gc);

		gc.gridy++;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(loginField, gc);

		gc.gridx = 0;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(loginLabel, gc);

		gc.gridy++;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(passLabel, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(passField, gc);

		gc.gridy++;
		gc.weighty = 0.8;
		gc.anchor = GridBagConstraints.CENTER;
		add(addBtn, gc);

		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;
		add(cancelBtn, gc);
	}

	public void setEmpListener(EmpListener listener) {
		this.empListener = listener;
	}
}
