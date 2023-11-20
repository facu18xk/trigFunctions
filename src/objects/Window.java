package objects;

import utils.Picture;
import uwcse.graphics.GWindow;

/**
 * The Window class represents a graphical window with functionality to display
 * and animate the maximization of an image.
 * 
 * @author Facundo Garay
 * @version 1.0
 */
public class Window {

  /**
   * Constructs a Window object with the specified width, height, graphics window,
   * and image filename.
   *
   * @param width  The width of the window.
   * @param height The height of the window.
   * @param window The graphics window to display the image.
   * @param img    The filename of the image to be displayed.
   */
  public Window(int width, int height, GWindow window, String img) {
    this.window = window;
    this.img = img;
    this.width = width;
    this.height = height;
  }

  /**
   * Displays the image in full screen within the graphics window.
   */
  private void fullScreen() {
    app = new Picture(img, width, height, window);
    app.add(0, 0);
  }

  /**
   * Animates the maximization of the image within the graphics window.
   */
  private void maximizeAnimation() {
    app = new Picture(img, width, height, window);
    ;
    int appWidth, appHeight;
    int appPosX, appPosY;
    for (double i = 0.7; i <= ONE; i += INCREMENT_FACTOR) {
      appWidth = (int) (width * i);
      appHeight = (int) (height * i);
      appPosX = width / TWO - appWidth / TWO;
      appPosY = height / TWO - appHeight / TWO;
      app = new Picture(img, appWidth, appHeight, window);
      app.add(appPosX, appPosY);
    }
  }

  /**
   * Maximizes the image within the graphics window.
   */
  public void maximize() {
    maximizeAnimation();
    fullScreen();
  }

  Picture app;
  final int ONE = 1;
  final int TWO = 2;
  final double INCREMENT_FACTOR = .020;
  private int height;
  private int width;
  private GWindow window;
  private String img;
}
