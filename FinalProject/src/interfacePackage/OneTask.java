package interfacePackage;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class OneTask extends JPanel {
	private JTextField taskname;
	JButton done;
	JLabel index;
	JButton remove;
	JPanel tasks;
	

	
	public OneTask() {
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		tasks = new JPanel();
		tasks.setBackground(new Color(240, 230, 140));
		tasks.setPreferredSize(new Dimension(400, 40));
		add(tasks);
		tasks.setLayout(new GridLayout(1, 4, 5, 0));
		
		index = new JLabel("");
		index.setSize(new Dimension(5, 40));
		index.setBackground(new Color(255, 0, 0));
		index.setPreferredSize(new Dimension(5, 40));
		tasks.add(index);
		
		taskname = new JTextField();
		taskname.setFont(new Font("Liberation Sans Narrow", Font.ITALIC, 13));
		taskname.setText("Enter Task");
		taskname.setBackground(new Color(240, 230, 140));
		taskname.setPreferredSize(new Dimension(15, 40));
		taskname.setBorder(BorderFactory.createEmptyBorder());
		tasks.add(taskname);
		taskname.setColumns(10);
		
		done = new JButton("DONE");
		done.setPreferredSize(new Dimension(10, 40));
		tasks.add(done);
		
		remove = new JButton("REMOVE");
		remove.setPreferredSize(new Dimension(10, 40));
		tasks.add(remove);
		

	}
	
	public void writeindex(int n) {
		this.index.setText(String.valueOf(n));
		this.revalidate();
		
	}
	
	public JButton getdone() {
		return this.done;
		
	}
	
	public JButton getremove() {
		return this.remove;
		
	}
	
	public void donestatus() {
		this.taskname.setBackground(Color.green);
		this.tasks.setBackground(Color.green);
		this.index.setBackground(Color.green);
		this.done.setBackground(Color.green);
		this.remove.setBackground(Color.green);
		this.setBackground(Color.green);
		revalidate();
	}
	
	
}
