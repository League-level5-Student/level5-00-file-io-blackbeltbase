package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	public void run() {
		System.out.println("h");
		String userMessage = JOptionPane.showInputDialog("Enter in your message");
		String userKey = JOptionPane.showInputDialog("Enter a number that will be used to encrypt your message.");
		String newMessage = "";
		String alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
		String[] encryptGraph = alphabet.split(" ");
		for(int i = 0; i<userMessage.length();i++) {
			String letter = ""+userMessage.charAt(i);
			for(int j = 0; j<encryptGraph.length;i++) {
			if(letter.equals(encryptGraph[i])) {
				if(i>=23) {
					int thatNumber = i+Integer.parseInt(userKey);
					thatNumber = thatNumber-26;
					newMessage+=encryptGraph[thatNumber];
				}else {
				newMessage += encryptGraph[i+Integer.parseInt(userKey)];
				}
				break;
			}
			}
		}
		JOptionPane.showMessageDialog(null, "Your message is: "+newMessage);
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/encrypted.txt");
		
			
			fw.write(userKey+newMessage);
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
