package gui;

import model.TypeCategory;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class AddItemFrame extends JFrame{
	private JLabel space;
	private JLabel titleLabel;
	private JLabel sizeLabel;
	private JLabel priceLabel;
	private JLabel descLabel;
	private JLabel typeLabel;
	private JLabel iconLabel;

	private JTextField titleField;
	private JTextField sizeField;
	private JTextField priceField;
	private JTextField descText;
	private JList typeList;
	private JButton chose;
	private JFileChooser fileChooser;

	private File file;

	private JButton cancelBtn;
	private JButton addBtn;

	private OrdListener ordListener;

	public AddItemFrame() throws ParseException {
		setLayout(new GridBagLayout());

		fileChooser = new JFileChooser();
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Icons", "png"));

		space = new JLabel("");
		titleLabel = new JLabel("Title:");
		titleField = new JTextField(15);
		sizeLabel = new JLabel("Size:");
		sizeField = new JTextField(15);
		priceLabel = new JLabel("Price:");
		priceField = new JTextField(15);
		descLabel = new JLabel("Recipe: ");
		descText = new JTextField(15);
		typeLabel = new JLabel("Type of food: ");
		typeList = new JList();
		iconLabel = new JLabel("Choose image: ");
		chose = new JButton("Choose");

		cancelBtn = new JButton("Cancel");
		addBtn = new JButton("Add");

		setButtons();

		DefaultListModel typeModel = new DefaultListModel();
		typeModel.addElement(new TypeCategory(3, "Breakfast"));
		typeModel.addElement(new TypeCategory(4, "Appetizers"));
		typeModel.addElement(new TypeCategory(1, "Salads"));
		typeModel.addElement(new TypeCategory(5, "Soups"));
		typeModel.addElement(new TypeCategory(2, "Main Course"));
		typeModel.addElement(new TypeCategory(6, "Deserts"));
		typeModel.addElement(new TypeCategory(7, "Hot Beverage"));
		typeModel.addElement(new TypeCategory(8, "Cold Beverage"));
		typeList.setModel(typeModel);

		typeList.setPreferredSize(new Dimension(110, 23));
		typeList.setBorder(BorderFactory.createEtchedBorder());
		typeList.setSelectedIndex(0);


		setMinimumSize(new Dimension(350, 500));
		setSize(350, 500);
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
		add(titleLabel, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(titleField, gc);

		gc.gridy++;
		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(sizeField, gc);

		gc.gridx = 0;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(sizeLabel, gc);

		gc.gridy++;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(priceLabel, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(priceField, gc);

		gc.gridy++;
		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(descText, gc);

		gc.gridx = 0;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(descLabel, gc);

		gc.gridy++;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(typeLabel, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(new JScrollPane(typeList), gc);

		gc.gridy++;
		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(chose, gc);

		gc.gridx = 0;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(iconLabel, gc);

		gc.gridy++;
		gc.gridx = 1;
		gc.weighty = 0.8;
		gc.anchor = GridBagConstraints.CENTER;
		add(addBtn, gc);

		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;
		add(cancelBtn, gc);

		chose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showOpenDialog(AddItemFrame.this) == JFileChooser.APPROVE_OPTION) {
					file = fileChooser.getSelectedFile();
				}
			}
		});

		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = titleField.getText();
				if (sizeField.getText().isEmpty())
					return ;
				double size =  Double.parseDouble(sizeField.getText());
				if (priceField.getText().isEmpty())
					return ;
				double price = Double.parseDouble(priceField.getText());
				String desc = descText.getText();
				TypeCategory typeCategory = (TypeCategory)typeList.getSelectedValue();
				if (file == null)
				{
					JOptionPane.showMessageDialog(AddItemFrame.this, "Please attach the icon!");
					return ;
				}
				String path = file.getAbsolutePath();

				OrdEvent ord = new OrdEvent(this, title, size, price, typeCategory.getId(), desc, path);

				if (ordListener != null) {
					ordListener.ordEventOccured(ord);
				}
			}
		});
	}

	public void setOrdListener(OrdListener ordListener) {
		this.ordListener = ordListener;
	}
}