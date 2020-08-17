package _02_File_Encrypt_Decrypt;

public class Runner {
public static void main(String[] args) {
	FileEncryptor e = new FileEncryptor();
	e.run();
	FileDecryptor d = new FileDecryptor();
	d.run();
}
}
