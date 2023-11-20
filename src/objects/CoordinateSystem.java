package objects;

/**
 * The Coordinate System class represents a coordinate system in a graphics window.
 * It provides methods to set the properties of the coordinate system, such as center and size,
 * and render the coordinate axes in the specified graphics window.
 * 
 * The coordinate system is drawn with animated growth of lines to create a visual effect.
 * 
 * @author Facundo Garay
 * @version 1.0
 */
import java.awt.Color;

import uwcse.graphics.GWindow;
import uwcse.graphics.Line;
import uwcse.io.AudioPlayer;
import uwcse.io.Sound;

public class CoordinateSystem {
  /**
   * Constructs a new coordinate system with the specified width and height.
   *
   * @param width  the width of the coordinate system
   * @param height the height of the coordinate system
   */
  public CoordinateSystem(int width, int height) {
    this.width = width;
    this.height = height;
  }

  /**
   * Gets the x-coordinate of the center of the coordinate system.
   *
   * @return the x-coordinate of the center
   */
  public int getCenterX() {
    return centerX;
  }

  /**
   * Sets the x-coordinate of the center of the coordinate system.
   *
   * @param centerX the x-coordinate of the center
   */
  public void setCenterX(int centerX) {
    this.centerX = centerX;
  }

  /**
   * Gets the y-coordinate of the center of the coordinate system.
   *
   * @return the y-coordinate of the center
   */
  public int getCenterY() {
    return centerY;
  }

  /**
   * Sets the y-coordinate of the center of the coordinate system.
   *
   * @param centerY the y-coordinate of the center
   */
  public void setCenterY(int centerY) {
    this.centerY = centerY;
  }

  /**
   * Draws a line with animated growth in the specified graphics window.
   *
   * @param x1             the x-coordinate of the starting point of the line
   * @param y1             the y-coordinate of the starting point of the line
   * @param x2             the x-coordinate of the ending point of the line
   * @param y2             the y-coordinate of the ending point of the line
   * @param color          the color of the line
   * @param growthVertical {@code true} if the line grows vertically,
   *                       {@code false} if horizontally
   * @param window         the graphics window to draw the line
   */
  private void drawLine(int x1, int y1, int x2, int y2, java.awt.Color color, boolean growthVertical, GWindow window) {
    final double GROWTH_FACTOR = 0.25;
    Line line;
    int x2Coordinate = x1;
    int y2Coordinate = y1;
    final int DELAY = 20;
    double factor = 0;
    while (x2Coordinate <= x2 && y2Coordinate <= y2) {
      // For each iteration the line growth 0.02 pixels
      if (growthVertical) {
        y2Coordinate += (int) factor;
        x2Coordinate = x2;
      } else {
        x2Coordinate += (int) factor;
        y2Coordinate = y2;
      }
      line = new Line(x1, y1, x2Coordinate, y2Coordinate, color);
      line.addTo(window);
      try {
        Thread.sleep(DELAY);
      } catch (Exception e) {
      }
      factor += GROWTH_FACTOR;
    }

  }

  /**
   * Renders the x-axis of the coordinate system in the specified graphics window.
   *
   * @param window the graphics window in which to render the x-axis
   */
  private void renderXaxis(GWindow window) {
    final int TEN = 10;
    final int SIXTEEN = 16;
    // Substracting four because the background image is not perfectly simetric
    int lateralMargin = (window.getWindowWidth() - width) / TWO;
    verticalMargin = (window.getWindowHeight() - height) / TWO;
    setCenterY(verticalMargin + height / TWO - SIXTEEN);
    int x1 = lateralMargin - TEN;
    int y1 = getCenterY();
    // Minus 16 becuause the center of the canvas is not the center of the image and
    // is sixteen pixels away from the image center
    int x2 = window.getWindowWidth() - lateralMargin - TEN;
    int y2 = getCenterY();
    Sound sound = new Sound("src/assets/sounds/jedi.wav");
    AudioPlayer player = new AudioPlayer();
    player.play(sound);
    drawLine(x1, y1, x2, y2, CYAN, false, window);
  }

  /**
   * Renders the y-axis of the coordinate system in the specified graphics window.
   *
   * @param window the graphics window in which to render the y-axis
   */
  private void renderYaxis(GWindow window) {
    final int TWELVE = 12;
    final int FIVE = 5;
    final int DELTA_Y = 29;
    // Substracting 5 because the background image is not perfectly simetric
    int verticalMargin = (window.getWindowHeight() - height) / TWO;
    setCenterX(window.getWindowWidth() / TWO - FIVE);
    int x1 = getCenterX();
    int y1 = verticalMargin - TWELVE;
    int x2 = getCenterX();
    int y2 = window.getWindowHeight() - (verticalMargin + DELTA_Y);
    drawLine(x1, y1, x2, y2, PINK, true, window);
  }

  /**
   * Renders the coordinate system with animated growth of the axes in the
   * specified graphics window.
   *
   * @param window the graphics window in which to render the coordinate system
   */
  public void render(GWindow window) {
    renderXaxis(window);
    // new thread to create the x and y axis in paralel
    renderYaxis(window);
  }

  // Private members
  private final Color CYAN = new Color(4, 101, 138);
  private final Color PINK = new Color(127, 16, 154);
  private int centerX;
  private int centerY;
  private final int TWO = 2;
  private int verticalMargin;
  private int width;
  private int height;
}
