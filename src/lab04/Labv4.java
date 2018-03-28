package lab04;





import javax.swing.JFrame;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.AbstractListModel;
import javax.swing.*;

import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JList;

public class Labv4 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private ArrayList<String> pole;
	private DefaultListModel m;
	private String tekst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Labv4 window = new Labv4();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Labv4() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 730, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		tekst= new String();
		textField = new JTextField();
		textField.setBounds(128, 28, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Наслов");
		lblName.setBounds(65, 31, 46, 14);
		frame.getContentPane().add(lblName);
		JLabel prikaz = new JLabel();
		prikaz.setHorizontalAlignment(SwingConstants.CENTER);
		prikaz.setVerticalAlignment(SwingConstants.TOP);
		prikaz.setBounds(400,0,292,440);
		
		JLabel lblPhone = new JLabel("Автори");
		lblPhone.setBounds(65, 68, 46, 14);
		frame.getContentPane().add(lblPhone);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 65, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Датум");
		lblEmailId.setBounds(65, 115, 46, 14);
		frame.getContentPane().add(lblEmailId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(128, 112, 247, 17);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAddress = new JLabel("Извор");
		lblAddress.setBounds(65, 162, 46, 14);
		frame.getContentPane().add(lblAddress);
				
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(126, 157, 212, 40);
		frame.getContentPane().add(textArea_1);
		
		
		
		JButton btnClear = new JButton("Бриши");
		
		btnClear.setBounds(180, 387, 89, 23);
		frame.getContentPane().add(btnClear);
		
		JLabel lblSex = new JLabel("Автор");
		lblSex.setBounds(65, 228, 46, 14);
		frame.getContentPane().add(lblSex);
		
		JLabel lblMale = new JLabel("Прикажи");
		lblMale.setBounds(106, 228, 46, 14);
		frame.getContentPane().add(lblMale);
		
		JLabel lblFemale = new JLabel("сокриј");
		lblFemale.setBounds(292, 228, 46, 14);
		frame.getContentPane().add(lblFemale);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(337, 224, 109, 23);
		frame.getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(162, 224, 109, 23);
		frame.getContentPane().add(radioButton_1);
		ButtonGroup grupa = new ButtonGroup();
		grupa.add(radioButton_1);
		grupa.add(radioButton);
		radioButton_1.setSelected(true);
		JLabel lblOccupation = new JLabel("Елементи");
		lblOccupation.setBounds(65, 288, 67, 14);
		frame.getContentPane().add(lblOccupation);
class click_jlist extends MouseAdapter{
	
	private void handle(MouseEvent e) throws EmptyListException {
		JList cb = null;
		try {
			cb=(JList) e.getSource();
		} catch (Exception err) {
			System.err.println(err);
		}

		if(e.getClickCount() == 1) {
			if(cb.getModel().getSize() < 1) {
				throw new EmptyListException();
			} else {
				prikaz.setText(cb.getSelectedValue().toString());
			}
		}
		else if(e.getClickCount()==2) {
			if(cb.getModel().getSize() < 1) {
				throw new EmptyListException();
			} else {
				m.remove(cb.getSelectedIndex());
				cb.setBounds(cb.getX(), cb.getY(), cb.getWidth(), cb.getHeight()-20);
				prikaz.setText("");
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			handle(e);
		} catch (EmptyListException err) {
			System.err.println(err);
			JOptionPane.showMessageDialog(null, err);
		}
	}
};
		m = new DefaultListModel();
		frame.getContentPane().add(prikaz);
		JList comboBox = new JList(m);
		
		comboBox.setBounds(180, 285, 91, 20);
		frame.getContentPane().add(comboBox);
		comboBox.addMouseListener(new click_jlist());
		
		JLabel lblprofesija = new JLabel("Додади елемент");
		lblprofesija.setBounds(10, 323, 46, 14);
		frame.getContentPane().add(lblprofesija);
		JTextField	textProfesija = new JTextField();
		textProfesija.setBounds(65, 321, 86, 20);
		frame.getContentPane().add(textProfesija);
		textProfesija.setColumns(10);
		frame.getContentPane().add(textProfesija);
		/* Kopce za promena */
		JButton btnPromena = new JButton("Додади");
		
		btnPromena.setBackground(Color.BLUE);
		btnPromena.setForeground(Color.MAGENTA);
		btnPromena.setBounds(65, 352, 89, 23);
		frame.getContentPane().add(btnPromena);
		
		btnPromena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String s=new String(textProfesija.getText());
			if(m.contains(s)) {
				textProfesija.setText("");
				JOptionPane.showMessageDialog(null, "Веќе постои записот!");
				
			}
			else if(s.isEmpty()==false){
				//pole.add(s);
				m.addElement(s);
				comboBox.setBounds(comboBox.getX(), comboBox.getY(), comboBox.getWidth(), comboBox.getHeight()+20); 
				
				textProfesija.setText("");
				
			}
			}
		});
		
		
		JButton btnSubmit = new JButton("Прикажи");
		
		btnSubmit.setBackground(Color.BLUE);
		btnSubmit.setForeground(Color.MAGENTA);
		btnSubmit.setBounds(65, 387, 89, 23);
		frame.getContentPane().add(btnSubmit);
		

		class Exceptor {
			public void prikazi() throws Exception {
				if (textField.getText().isEmpty() ||  
							textField_2.getText().isEmpty()) {
					throw new EmptyException();
				} else if (radioButton_1.isSelected() && textField_1.getText().isEmpty()) {
					throw new NoAuthorException();
				}
			}
		}

		btnSubmit.addActionListener(e -> {
			try {
				Exceptor ex = new Exceptor();
				ex.prikazi();
				tekst="";
				tekst=tekst.concat("<html>");
				tekst=tekst.concat("<h1>"+ textField.getText()+"</h1>");
				if(radioButton_1.isSelected()) tekst=tekst.concat("<i><b>"+textField_1.getText()+"</b></i>");
				tekst=tekst.concat("<small><i>"+textField_2.getText()+"</i></small>");
				for(int i=0;i<m.getSize();i++) {
					tekst=tekst.concat("<br>" + m.getElementAt(i));
				}
				tekst=tekst.concat("<br>");
				tekst=tekst.concat("<small>"+textArea_1.getText()+"</small></html>");
				prikaz.setText(tekst);
			} catch (Exception err) {
				System.err.println(err);
				JOptionPane.showMessageDialog(null, err);
			}
		});
	
		
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(null);
				textField_2.setText(null);
				textField.setText(null);
				textArea_1.setText(null);
				radioButton.setSelected(false);
				radioButton_1.setSelected(false);
				comboBox.setSelectedIndex(0);
				
				
			}
		});
		
	}
}

