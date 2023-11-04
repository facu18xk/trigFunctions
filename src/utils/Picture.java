package utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import uwcse.graphics.GWindow;
import uwcse.graphics.ImageShape;

public class Picture {
	/**
	 * Creates a picture object
	 * 
	 * @param fileName
	 * @param heigth
	 * @param width
	 * @param window
	 */
	public Picture(String fileName, int width, int height, int posX, int posY, GWindow window) {
		this.window = window;
		// Create a buffered image from a the file name argument, if the file is not
		// found it will print the error
		try {
			bufferedImage = ImageIO
					.read(new File("src" + File.separator + "assets" + File.separator + "images" + File.separator + fileName));
		} catch (IOException error) {
			System.out.println(error);
		}
		// Scale the image to the required resolution
		img = bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}

	/**
	 * A method that add the image to the window
	 * 
	 * @param posX
	 * @param posY
	 */
	public void add(int posX, int posY) {
		image = new ImageShape(img, posX, posY);
		image.addTo(window);
	}

	private BufferedImage bufferedImage;
	private GWindow window;
	private ImageShape image;
	private Image img;

}
