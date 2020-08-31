package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class DirectoryIterator {
	public static void main(String[] args) {
		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		ArrayList <String> javaFiles = new ArrayList <String>();
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File directory = jfc.getSelectedFile();
			File[] files = directory.listFiles();
			if(files != null) {
				for(File f : files) {
					
					  System.out.println(f.getAbsolutePath());
					  if(f.isDirectory()) {
						 directoryRecursion(f.getName(), javaFiles);
					  }
					  else {
					if(f.getName().endsWith(".java")) {
					javaFiles.add(f.getAbsolutePath());
					}
					  }
				}
			}
		}
		
		for(int i = 0;i<javaFiles.size();i++) {
			try {
				FileWriter fw = new FileWriter(javaFiles.get(i),true);
				
				
				fw.write("\n"+"//Copyright © 2019 Dean Le");
					
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * (e.g //Copyright Â© 2019 FirstName LastName)
		 */
	}
	public static void directoryRecursion (String directoryName, ArrayList<String> javaFiles) {
		System.out.println("recursed");
		JFileChooser jfc = new JFileChooser();
		File directory = jfc.getSelectedFile();
		File[] files = directory.listFiles();
		for(File f : files) {
			
			  System.out.println(f.getAbsolutePath());
			  if(f.isDirectory()) {
				  directoryRecursion(f.getName(), javaFiles);
			  }
			  else {
			if(f.getName().endsWith(".java")) {
				System.out.println("java file added in method");
			javaFiles.add(f.getAbsolutePath());
			}
			  }
		}
	}
	
}
