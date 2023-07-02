package interfacePackage;

import java.awt.EventQueue;




import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;

//import frames.Tasks;

//import frames.Tasks;

//import frames.Tasks;

//import frames.Tasks;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ToDo {

	private JFrame frame;
	private JPanel List;
	private JButton addTask;
	private JButton clear;
	int num;
	private JPanel secondpanel;
	private JButton click;
	
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ToDo window = new ToDo();
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
	public ToDo() {
		initialize();

	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setSize(new Dimension(420, 740));
		frame.setPreferredSize(new Dimension(400, 700));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(152, 251, 152));
		panel.setPreferredSize(new Dimension(0, 120));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("To Do List App");
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.BOLD, 15));
		lblNewLabel.setBounds(129, 11, 109, 27);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel);
		
		secondpanel = new JPanel();
		secondpanel.setBackground(new Color(222, 184, 135));
		secondpanel.setPreferredSize(new Dimension(0, 120));
		secondpanel.setBounds(0, 60,32767, 60);
		panel.add(secondpanel);
		secondpanel.setLayout(null);
		
		click = new JButton("CLICK");
		click.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecondFrame buttonPage = new SecondFrame();
				buttonPage.setVisible(true);
			}
		});
		click.setBounds(281, 18, 77, 23);
		secondpanel.add(click);
		
		JLabel lblNewLabel_1 = new JLabel("Access LMS & check Power Cut Hours :");
		lblNewLabel_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 20, 251, 17);
		secondpanel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(400, 80));
		panel_1.setBackground(new Color(127, 255, 212));
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(null);
		
		addTask = new JButton("ADD TASK");
		addTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OneTask task = new OneTask();
				
				
				List.add(task);
				indexNum();
				List.revalidate();
				
				JButton done = task.getdone();
				done.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						task.donestatus();
						List.revalidate();
						
						
						
					}
				});
				
				JButton remove = task.getremove();
				
				remove.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						
						
						List.remove(task);
						indexNum();
						List.revalidate();
						List.repaint();
						
					}
				});
			}
			}
		);
		addTask.setBounds(46, 24, 100, 32);
		panel_1.add(addTask);
		
		clear = new JButton("CLEAR");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						int response=JOptionPane.showConfirmDialog(List, "Are you sure u want to clear all tasks", "WARNING!!!", JOptionPane.YES_NO_OPTION);
						if (response== JOptionPane.YES_OPTION) {
							Component[] tasklist = List.getComponents();
							OneTask task = new OneTask();
							for(int i = 0;i<tasklist.length;i++)
							{
								if(tasklist[i] instanceof OneTask)
								{
									List.remove((OneTask)tasklist[i]);
								}
							}
							List.revalidate();
							List.repaint();
							
						}
						
						else if(response== JOptionPane.NO_OPTION) {
							
						}			
							
					}
				});
			}
		});
		clear.setBounds(225, 24, 100, 32);
		panel_1.add(clear);
		
		List = new JPanel();
		List.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(List, BorderLayout.CENTER);
		List.setLayout(new GridLayout(10, 1, 0, 5));
		
	}
		
	
	public void indexNum()
	{
		Component[] listcomp = List.getComponents();
		
		for(int i = 0;i<listcomp.length;i++)
		{
			if(listcomp[i] instanceof OneTask)
			{
				((OneTask)listcomp[i]).writeindex(i+1);
			}
		}
		
	}
}
