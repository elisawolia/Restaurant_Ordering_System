package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.UIManager.*;

public class MainFrame extends JFrame {
	protected MainPanel mainPanel;
	protected OrderPanel orderPanel;

	public MainFrame(){
		super("Ordering System");
		setLookAndFeel();

		setLayout(new BorderLayout());
		mainPanel = new MainPanel(this);
		orderPanel = new OrderPanel(this);

		orderPanel.setVisible(false);

		getContentPane().add(mainPanel);

		setMinimumSize(new Dimension(800, 600));
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	private void setLookAndFeel() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					UIManager.getLookAndFeelDefaults().put("TabbedPane:TabbedPaneTab.contentMargins", new Insets(15, 25, 15, 25));
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
