package scenes;

import utils.Picture;
import uwcse.graphics.GWindow;

/**
 * The FourthScene class represents the fourth scene of an application.
 * It provides a method for playing the scene, which involves displaying
 * background images,
 * a title image, and a QR code image within a graphics window.
 * 
 * @author Facundo Garay
 * 
 * @version 1.0
 */
public class FourthScene {
  /**
   * Constructs a FourthScene object with the specified width and height.
   *
   * @param width  The width of the scene.
   * @param height The height of the scene.
   */
  public FourthScene(int width, int height) {
    this.width = width;
    this.height = height;
  }

  /**
   * Plays the fourth scene, setting up background images, a title image, and a QR
   * code image
   * within a graphics window.
   *
   * @param window The graphics window to display the scene.
   */
  public void play(GWindow window) {
    final int widthTitle = 500;
    final int heightTitle = 200;
    final int widthQr = 300;
    final int heightQr = 300;
    final int TWO = 2;
    final int FIVE = 5;
    Picture background = new Picture("appFullScreen.png", width, height, window);
    Picture title = new Picture("final.png", widthTitle, heightTitle, window);
    Picture qr = new Picture("qr.png", widthQr, heightQr, window);
    background.add(0, 0);
    int qrX = width / TWO - (widthQr / TWO);
    int qrY = height / TWO - (widthQr / TWO) + (heightTitle / TWO);
    qr.add(qrX, qrY);
    title.add(width / TWO - (widthTitle / TWO), height / FIVE);

  }

  private int width;
  private int height;
}
