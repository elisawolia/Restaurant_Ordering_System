package gui;

import controller.ControllerOrd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoryFrame extends JFrame {
	private JLabel		label;
	private JComboBox	periodList;
	private JLabel		space;
	private JLabel		space2;
	private JButton		cnlBtn;
	private JButton		showBtn;
	private ControllerOrd controllerOrd;

	public HistoryFrame(){
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.weightx = 1;
		gc.weighty = 1;

		String s[] = {"Today", "Yesterday", "This week", "This month"};

		label = new JLabel("<html><span style='font-size:13px'>" + "Show orders for: " + "</span></html>");
		space = new JLabel("");
		periodList = new JComboBox(s);
		space2 = new JLabel("");
		cnlBtn = new JButton("Cancel");
		showBtn = new JButton("Show");

		gc.gridx = 0;
		gc.gridy = 0;

		add(space2, gc);

		gc.gridx = 1;

		add(label, gc);
		gc.gridx = 2;
		add(space, gc);

		gc.weighty = 0.05;
		gc.gridy++;
		gc.gridx = 1;
		add(periodList, gc);

		gc.weighty = 1;
		gc.gridy++;
		gc.anchor = GridBagConstraints.LINE_START;
		add(cnlBtn, gc);
		gc.anchor = GridBagConstraints.LINE_END;
		add(showBtn, gc);

		cnlBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		showBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerOrd = new ControllerOrd(periodList.getSelectedIndex());
				HistoryPeriodFrame historyFrame = new HistoryPeriodFrame(controllerOrd);
				historyFrame.setHisListener(controllerOrd);
				dispose();
			}
		});

		setMinimumSize(new Dimension(350, 200));
		setSize(350, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
