package _06_Pixel_Art_Save_State;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*Complete the steps in the CrazyDigitalPainting class*/

public class ColorArrayDisplayer {
	static BufferedImage image;
	public static void displayColorsAsImage(Color[][] colors) {
		JFrame window = new JFrame();
		JLabel label = new JLabel();
		 image = new BufferedImage(colors.length, colors[0].length, BufferedImage.TYPE_INT_RGB);
		for(int i = 0; i < colors.length; i++) {
			for(int j = 0; j < colors[0].length; j++) {
				image.setRGB(i, j, colors[i][j].getRGB());
			}
		}
		
		label.setIcon(new ImageIcon(image));
		window.add(label);
		window.pack();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);	
	}
	 public static void main( String[] args ){
	      imageIoWrite();
	    }
	  public static void imageIoWrite() {
	         BufferedImage bImage = null;
	         try {
	             File initialImage = new File("src/_06_Pixel_Art_Save_State/Pixel Art");
	             bImage = ImageIO.read(initialImage);
	 
	             ImageIO.write(bImage, "jpg", new File("src/_06_Pixel_Art_Save_State/Pixel Art"));
	
	 
	         } catch (IOException e) {
	               System.out.println("Exception occured :" + e.getMessage());
	         }
	         System.out.println("Images were written succesfully.");
	    }
}
