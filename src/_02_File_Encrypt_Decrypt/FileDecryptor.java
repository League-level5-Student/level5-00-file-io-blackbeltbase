package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */

	
		public void run() {
			System.out.println("h");
			String alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
			String[] decryptGraph = alphabet.split(" ");
			String decrypted = "";
			
		try {
			FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/encrypted.txt");
			
			int c = fr.read();
			String key = ""+(char)c;
			int k = Integer.parseInt(key);
			c = fr.read();
			while(c != -1){
				int index = 0;
				String newLetter = "";
				for(int i = 0; i<decryptGraph.length;i++) {
					String letter = ""+(char)c;
					if(letter.equals(decryptGraph[i])) {
						index = i;
						break;
					}
				}
				if(index <= 3) {
					int newIndex = index-k;
					newLetter += decryptGraph[decryptGraph.length-1+newIndex];
				}
				else {
					newLetter += decryptGraph[index-k];
				}
				
				decrypted+=newLetter;
				c = fr.read();
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Decrypted Message: "+decrypted);
	}
}
