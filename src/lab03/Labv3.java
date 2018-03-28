package lab03;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.Color;


public class Labv3 {

	private JFrame frmGreedingsCard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Labv3 window = new Labv3();
					window.frmGreedingsCard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Labv3() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGreedingsCard = new JFrame();
		frmGreedingsCard.setTitle("Greedings card");
		frmGreedingsCard.setBounds(100, 100, 559, 317);
		frmGreedingsCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGreedingsCard.getContentPane().setLayout(null);

		JLabel lblLabela1 = new JLabel("Labela 1");
		lblLabela1.setFont(new Font("MS Gothic", Font.BOLD, 22));
		lblLabela1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabela1.setBounds(10, 22, 543, 27);
		frmGreedingsCard.getContentPane().add(lblLabela1);

		JLabel lblLabela2 = new JLabel("Labela 2");
		lblLabela2.setFont(new Font("Gabriola", Font.PLAIN, 17));
		lblLabela2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLabela2.setBounds(141, 90, 124, 113);
		frmGreedingsCard.getContentPane().add(lblLabela2);

		JLabel lblLabela3 = new JLabel("Labela 3");
		lblLabela3.setHorizontalAlignment(SwingConstants.LEFT);
		lblLabela3.setFont(new Font("Gabriola", Font.PLAIN, 17));
		lblLabela3.setBounds(275, 90, 124, 113);
		frmGreedingsCard.getContentPane().add(lblLabela3);

		JLabel lblLabela4 = new JLabel("Labela 4");
		lblLabela4.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabela4.setFont(new Font("MS Gothic", Font.BOLD, 19));
		lblLabela4.setBounds(0, 226, 543, 27);
		frmGreedingsCard.getContentPane().add(lblLabela4);

		JLabel lblLabela5 = new JLabel("Labela 5");
		lblLabela5.setFont(new Font("Arial", Font.ITALIC, 12));
		lblLabela5.setBounds(10, 265, 79, 14);
		frmGreedingsCard.getContentPane().add(lblLabela5);


		lblLabela1.addMouseListener(new ClickLabel(lblLabela1));
		lblLabela2.addMouseListener(new ClickLabel(lblLabela2));
		lblLabela3.addMouseListener(new ClickLabel(lblLabela3));
		lblLabela4.addMouseListener(new ClickLabel(lblLabela4));
		lblLabela5.addMouseListener(new ClickLabel(lblLabela5));



		
		class DragNDrop extends MouseMotionAdapter {
			@Override 
			public void mouseDragged(MouseEvent e) {
				JLabel srcLabel = (JLabel) e.getSource();
				srcLabel.setLocation(e.getX(), e.getY());
			}
			@Override
			public void mouseMoved(MouseEvent e) {
			}
		}

		lblLabela1.addMouseMotionListener(new DragNDrop());
		lblLabela2.addMouseMotionListener(new DragNDrop());
		lblLabela3.addMouseMotionListener(new DragNDrop());
		lblLabela4.addMouseMotionListener(new DragNDrop());
		lblLabela5.addMouseMotionListener(new DragNDrop());

	}
}
