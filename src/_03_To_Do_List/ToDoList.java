package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	ArrayList<String> tasks = new ArrayList<String>();
	JFrame frame  = new JFrame();
	JPanel panel = new JPanel();
	JButton addTask = new JButton();
	JButton viewTask = new JButton();
	JButton removeTask = new JButton();
	JButton saveList = new JButton();
	JButton loadList = new JButton();
	public static void main(String[] args) {
		ToDoList r = new ToDoList();
		r.run();
	}
	void run() {
		loadFirst();
		addTask.addActionListener(this);
		viewTask.addActionListener(this);
		removeTask.addActionListener(this);
		saveList.addActionListener(this);
		loadList.addActionListener(this);
		addTask.setText("Add Task");
		viewTask.setText("View Tasks");
		removeTask.setText("Remove Task");
		saveList.setText("Save");
		loadList.setText("Load");
		panel.add(addTask);
		panel.add(viewTask);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	public void loadFirst() {
		String savedTask = "";
		try {
			FileReader fr = new FileReader("src/_03_To_Do_List/tasks");
			int c = fr.read();
			while(c != -1){
				savedTask+=(char)c;
				c = fr.read();
			}
			fr.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, savedTask);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton)e.getSource();
		if(button==addTask) {
			String task = JOptionPane.showInputDialog("Input a task");
			tasks.add(task);
			JOptionPane.showMessageDialog(null, "Task added");
		}
		else if(button == removeTask) {
			String savedTasks = "";
			try {
				FileReader fr = new FileReader("src/_03_To_Do_List/tasks");
				int c =0;
				while(c != -1){
					savedTasks+=(char)c;
					c = fr.read();
				}
				fr.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			String task = JOptionPane.showInputDialog("Select a task to be removed. Current saved tasks: "+savedTasks);
			for(int i = 0;i<tasks.size();i++) {
				if(task.equals(tasks.get(i))) {
					tasks.remove(i);
					break;
				}
			}
			JOptionPane.showMessageDialog(null, "Task removed");
			
		}else if(button == viewTask) {
			String task = "";
			for(int i = 0; i<tasks.size();i++) {
				int tasknumber =i+1; 
				task += tasknumber+"."+tasks.get(i)+"\n";
			}
			JOptionPane.showMessageDialog(null, "All tasks: \n"+task);
		}else if(button == saveList) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/tasks");
				for(int i = 0; i<tasks.size();i++) {
					fw.write("\n "+tasks.get(i));
				}
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/lastSaved");
				for(int i = 0; i<tasks.size();i++) {
					fw.write("\n "+tasks.get(i));
				}
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if(button == loadList) {
			String listLocation = JOptionPane.showInputDialog("Enter the source folder location of the file");
			String savedTasks = "";
			try {
				FileReader fr = new FileReader("src/_03_To_Do_List/tasks");
				int c = fr.read();
				while(c != -1){
					savedTasks+=(char)c;
					c = fr.read();
				}
				fr.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}
}
