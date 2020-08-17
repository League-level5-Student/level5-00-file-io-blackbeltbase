package _01_File_Recorder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
public static void main(String[] args) {
	String userText = JOptionPane.showInputDialog("Enter in text.");

	try {
		FileWriter fw = new FileWriter("src/_01_File_Recorder/userText.txt");
		
		
		fw.write("\n"+userText);
			
		fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
