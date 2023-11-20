package objects;

/**
 * The Angle class represents an animated angle visualized as an arc.
 * It provides methods to set the properties of the angle and render it in a
 * specified GWindow.
 *
 * @author Facundo Garay
 * @version 1.0
 */
import java.awt.Color;

import uwcse.graphics.Arc;
import uwcse.graphics.GWindow;

public class Angle {
  /**
   * Constructs a new angle with the specified degree, position, and dimensions.
   *
   * @param degree the initial degree of the angle
   * @param x      the x-coordinate of the center of the angle
   * @param y      the y-coordinate of the center of the angle
   * @param width  the width of the bounding rectangle of the angle
   * @param height the height of the bounding rectangle of the angle
   */
  public Angle(int degree, int x, int y, int width, int height) {
    this.degree = degree;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  /**
   * Renders the animated angle in the specified {@link GWindow}.
   * The angle is drawn incrementally, creating an animation effect.
   *
   * @param window the graphics window in which to render the angle
   */
  public void render(GWindow window) {
    final int TWO = 2;
    final int ONE = 1;
    final int DELAY = 100;
    int posX = x - width / TWO;
    int posY = y - height / TWO;
    final double INCREMENT_FACTOR = 0.25;
    int degrees;
    for (double i = 0; i <= ONE; i += INCREMENT_FACTOR) {
      degrees = (int) (degree * i);
      angle = new Arc(posX, posY, width, height, 0, degrees, Color.white, false);
      angle.addTo(window);
      try {
        Thread.sleep(DELAY);
      } catch (Exception e) {
      }
    }
  }

  // Private members
  private int width;
  private int height;
  private Arc angle;
  private int x;
  private int y;
  private int degree;
}
