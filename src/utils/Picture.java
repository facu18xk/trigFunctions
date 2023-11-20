package utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import uwcse.graphics.GWindow;
import uwcse.graphics.ImageShape;

/**
 * The Picture class represents an image that can be displayed in a graphics
 * window.
 * It provides methods for creating, adding, rotating, and removing the image.
 * 
 * @author Facundo Garay
 * 
 * @version 1.0
 */
public class Picture {
	/**
	 * Creates a picture object
	 * 
	 * @param fileName
	 * @param heigth
	 * @param width
	 * @param window
	 */
	public Picture(String fileName, int width, int height, GWindow window) {
		this.window = window;
		// Create a buffered image from a the file name argument, if the file is not
		// found it will print the error
		try {
			bufferedImage = ImageIO
					.read(new File("src/assets/images/" + fileName));
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

	public void rotate(int pivotX, int pivotY, int degrees) {
		image.rotateAround(pivotX, pivotY, degrees);
	}

	public void removeFromWindow() {
		image.removeFromWindow();
	}

	BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
		BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = resizedImage.createGraphics();
		graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
		graphics2D.dispose();
		return resizedImage;
	}

	private BufferedImage bufferedImage;
	private GWindow window;
	private ImageShape image;
	private Image img;
}
