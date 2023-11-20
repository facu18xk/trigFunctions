package objects;

import java.awt.Color;

/**
 * The Straight class represents a straight line with optional animation effects.
 * It extends the Line class and provides additional methods for calculating hypotenuse and angle,
 * as well as animating the line's appearance.
 * 
 * The animation simulates the drawing of the line by gradually revealing it in the specified graphics window.
 * 
 * @author Facundo Garay
 * @version 1.0
 */
import uwcse.graphics.GWindow;
import uwcse.graphics.Line;

public class Straight extends Line {
  /**
   * Constructs a new straight line with the specified endpoints, color, and slope
   * direction.
   *
   * @param x1            the x-coordinate of the starting point of the line
   * @param y1            the y-coordinate of the starting point of the line
   * @param x2            the x-coordinate of the ending point of the line
   * @param y2            the y-coordinate of the ending point of the line
   * @param color         the color of the line
   * @param negativeSlope {@code true} if the line has a negative slope,
   *                      {@code false} otherwise
   */
  public Straight(int x1, int y1, int x2, int y2, Color color, boolean negativeSlope) {
    super(x1, y1, x2, y2, color);
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;
    this.negativeSlope = negativeSlope;
  }

  /**
   * Calculates the hypotenuse of a right triangle given the lengths of its
   * adjacent and opposite sides.
   *
   * @param adjacent the length of the adjacent side
   * @param opposite the length of the opposite side
   * @return the length of the hypotenuse
   */
  private double calculateHypotenuse(int adjacent, int opposite) {
    return Math.sqrt((Math.pow(adjacent, SQUARE) + Math.pow(opposite, SQUARE)));
  }

  /**
   * Calculates the angle of a right triangle given the lengths of its adjacent
   * and opposite sides.
   *
   * @param adjacent the length of the adjacent side
   * @param opposite the length of the opposite side
   * @return the angle in radians
   */
  private double calculateAngle(int adjacent, int opposite) {
    double tangent = opposite / adjacent;
    return Math.atan(tangent);
  }

  /**
   * Animates the appearance of the line by gradually revealing it in the
   * specified graphics window.
   *
   * @param window the graphics window in which to render the line
   */
  private void animation(GWindow window) {
    final int ONE = 1;
    final int DELAY = 25;
    int opposite = y2 - y1;
    if (!negativeSlope) {
      opposite = y1 - y2;
    }
    int adjacent = x2 - x1;
    double hypotenuse = calculateHypotenuse(adjacent, opposite);
    double angle = calculateAngle(adjacent, opposite);
    double incrementFactor = 0.010;
    int posX, posY;
    for (double i = 0; i <= ONE; i += incrementFactor) {
      posX = (int) (i * hypotenuse * Math.cos(angle)) + x1;
      if (!negativeSlope) {
        posY = (int) (y1 - i * hypotenuse * Math.sin(angle));
      } else {
        posY = (int) (y1 + i * hypotenuse * Math.sin(angle));
      }
      line = new Straight(x1, y1, posX, posY, color, negativeSlope);
      line.addTo(window);
      try {
        Thread.sleep(DELAY);
      } catch (Exception e) {
      }
    }
  }

  /**
   * Renders the line with animation in the specified graphics window.
   *
   * @param window the graphics window in which to render the line
   */
  public void render(GWindow window) {
    animation(window);
  };

  final int SQUARE = 2;
  private boolean negativeSlope;
  private Straight line;
  private int x1;
  private int x2;
  private int y1;
  private int y2;
}