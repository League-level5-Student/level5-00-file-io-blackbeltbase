package _05_Serialization;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/*
 * Complete this class so that it can be serialized.
 */

public class SaveData implements Serializable{
	public final String name;
	public final int age;
	public SaveData(String name, int age) {
		this.name = name;
		this.age = age;
		FileOutputStream();
	}
public void FileOutputStream() {
		try {
			byte[] bytes = name.getBytes("ois");
			byte[] ages = name.getBytes("ois");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public byte[] ObjectOutputStream(byte[] bytes,byte[] ages) {
		return bytes;
	}
	 
}
