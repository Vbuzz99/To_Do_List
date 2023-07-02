package interfacePackage;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class SecondFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondFrame frame = new SecondFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SecondFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 276);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("Access LMS :");
		lbl1.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 15));
		lbl1.setBounds(29, 59, 108, 20);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("Get Power Cut Shedule :");
		lbl2.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 15));
		lbl2.setBounds(29, 135, 192, 20);
		contentPane.add(lbl2);
		
		JButton lms = new JButton("LMS");
		lms.setBackground(new Color(255, 255, 255));
		lms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("https://sci.cmb.ac.lk/lms/login/index.php").toURI());
				}
				catch(Exception e1) {
					
				}
			}
		});
		lms.setBounds(231, 61, 89, 23);
		contentPane.add(lms);
		
		JButton ceb = new JButton("CEB");
		ceb.setBackground(new Color(255, 255, 255));
		ceb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("https://cebcare.ceb.lk/Incognito/DemandMgmtSchedule").toURI());
				}
				catch(Exception e1) {
					
				}
			}
		});
		ceb.setBounds(231, 132, 89, 23);
		contentPane.add(ceb);
		
		JButton back = new JButton("BACK");
		back.setBackground(new Color(240, 128, 128));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		back.setBounds(271, 203, 89, 23);
		contentPane.add(back);
	}
}
