package lab01;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;

public class Form {
	private JFrame 	  	frame;
	private JTextField 	titleField;
	private JTextField 	authorsField;
	private JTextField 	dateField;
	private JTextArea		sourceArea;
	private JLabel			lblText;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Form window = new Form();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	public Form() {
		initialize();
	}
	
	private void initialize() {
		// initialize frame
		frame = new JFrame();
		frame.setBounds(100, 100, 730, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// initialize the text label and set bounds
		lblText = new JLabel();
		lblText.setBounds(360, 30, 320, 240);
		frame.getContentPane().add(lblText);
		
		// title field
		titleField = new JTextField();
		titleField.setBounds(120, 28, 120, 20);
		frame.getContentPane().add(titleField);
		titleField.setColumns(10);
		JLabel lblTitle = new JLabel("Наслов");
		lblTitle.setBounds(50, 31, 66, 14);
		frame.getContentPane().add(lblTitle);
		
		// authors field
		authorsField = new JTextField();
		authorsField.setBounds(120, 58, 120, 20);
		frame.getContentPane().add(authorsField);
		authorsField.setColumns(10);
		JLabel lblAuthors = new JLabel("Автори");
		lblAuthors.setBounds(50, 61, 66, 14);
		frame.getContentPane().add(lblAuthors);
		
		// date field
		dateField = new JTextField();
		dateField.setBounds(120, 88, 120, 20);
		frame.getContentPane().add(dateField);
		dateField.setColumns(10);
		JLabel lblDate = new JLabel("Датум");
		lblDate.setBounds(50, 91, 66, 14);
		frame.getContentPane().add(lblDate);
		
		// source area
		sourceArea = new JTextArea();
		sourceArea.setBounds(120, 120, 200, 40);
		frame.getContentPane().add(sourceArea);
		JLabel lblSource = new JLabel("Извор");
		lblSource.setBounds(50, 125, 66, 14);
		frame.getContentPane().add(lblSource);
		
		// authors radio buttons
		JLabel lblAuthorRadio = new JLabel("Автор");
		lblAuthorRadio.setBounds(50, 190, 66, 14);
		frame.getContentPane().add(lblAuthorRadio);
		JLabel lblShow = new JLabel("Прикажи");
		lblShow.setBounds(150, 190, 66, 14);
		frame.getContentPane().add(lblShow);
		JRadioButton rdShow = new JRadioButton("");
		rdShow.setBounds(120, 190, 46, 14);
		frame.getContentPane().add(rdShow);
		JLabel lblHide = new JLabel("Сокриј");
		lblHide.setBounds(260, 190, 66, 14);
		frame.getContentPane().add(lblHide);
		JRadioButton rdHide = new JRadioButton("");
		rdHide.setBounds(230, 190, 46, 14);
		frame.getContentPane().add(rdHide);
		rdShow.addActionListener(e -> rdHide.setSelected(false));
		rdHide.addActionListener(e -> rdShow.setSelected(false));
		
		// elements
		JLabel lblElements = new JLabel("Елементи");
		lblElements.setBounds(50, 250, 66, 14);
		frame.getContentPane().add(lblElements);
    JList<String> list = new JList<>();
    list.setBounds(110, 250, 130, 60);
    frame.getContentPane().add(list);
    DefaultListModel<String> listModel = new DefaultListModel<>();
    list.setModel(listModel);
		
		// add element
		JTextField addField = new JTextField();
		addField.setBounds(320, 250, 90, 20);
		frame.getContentPane().add(addField);
		JLabel lblAdd = new JLabel("Додади");
		lblAdd.setBounds(250, 253, 66, 14);
		frame.getContentPane().add(lblAdd);
		JButton btnAdd = new JButton("Додади");
		btnAdd.setBackground(Color.BLUE);
		btnAdd.setForeground(Color.MAGENTA);
		btnAdd.setBounds(410, 250, 90, 23);
		btnAdd.addActionListener(e -> {
		  listModel.addElement(addField.getText());
			addField.setText(null);
		});
		frame.getContentPane().add(btnAdd);
		
		// update text
		JButton btnUpdate = new JButton("Прикажи");
		btnUpdate.setBackground(Color.BLUE);
		btnUpdate.setForeground(Color.MAGENTA);
		btnUpdate.setBounds(50, 400, 90, 23);
		frame.getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(e -> {
			if (titleField.getText().isEmpty() || 
					authorsField.getText().isEmpty() || 
					dateField.getText().isEmpty() || 
					sourceArea.getText().isEmpty() ||
					(!rdHide.isSelected() && !rdShow.isSelected())) {
				JOptionPane.showMessageDialog(null, "Недостасуваат податоци!");
				return;
			}
			// add title
			String text = "<html><h1>" + titleField.getText() + "</h1>";
			// add elements from JComboBox
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < listModel.getSize(); i++) {
				builder.append(listModel.getElementAt(i));
			}
			text += builder.toString();
			// show authors if button is selected
			if(rdShow.isSelected()) {
				text += "<br><strong>Authors: " + authorsField.getText() + "</strong>";
			}
			// add date and close html
			text += "<p>Published: " + dateField.getText() + "</p></html>";
			
			// set the contents to 'text'
			lblText.setText(text);
		});
			
		// delete SVE
		JButton btnDelete = new JButton("Бриши");
		btnDelete.setBounds(300, 400, 90, 23);
		btnDelete.addActionListener(e -> {
			titleField.setText(null);
			authorsField.setText(null);
			dateField.setText(null);
			sourceArea.setText(null);
			lblText.setText(null);
			rdHide.setSelected(false);
			rdShow.setSelected(false);
			listModel.removeAllElements();
		});
		frame.getContentPane().add(btnDelete);
		
	}

}
