package objects;

import java.awt.Color;

import uwcse.graphics.Arc;
import uwcse.graphics.GWindow;

/**
 * The TrigonometricCirunference class represents the rendering of a
 * trigonometric
 * circumference in a graphics window. It provides methods to draw and animate
 * the circumference.
 * 
 * The circumference is drawn using arcs with a specified width and height. The
 * rendering includes
 * an animation effect, gradually revealing the circumference in the specified
 * graphics window.
 * 
 * @author Facundo Garay
 * @version 1.0
 */
public class TrigonometricCirunference {

  /**
   * Constructs a new trigonometric circumference with the specified width and
   * height.
   *
   * @param width  the width of the circumference
   * @param height the height of the circumference
   */
  public TrigonometricCirunference(int width, int height) {
    this.width = width;
    this.height = height;
  }

  /**
   * Draws and animates the trigonometric circumference in the specified graphics
   * window.
   *
   * @param window the graphics window in which to render the circumference
   */
  private void drawCircunference(GWindow window) {
    final int KEY_FRAMES = 150;
    final int TWO = 2;
    final int FIFTEEN = 15;
    final int FOUR = 4;
    final int GROTW_FACTOR = 3;
    final int DELAY = 30;
    int x = window.getWindowWidth() / TWO - width / TWO - FOUR;
    // The four is beucause the center of the window is not the center of the canvas
    // and the canvas is 4 pixels away for the window center
    int y = window.getWindowHeight() / TWO - height / TWO - FIFTEEN;
    // The window's center is 15 pixels away from the canvas center
    Arc arc;
    for (int i = 0; i < KEY_FRAMES; i += TWO) {
      arc = new Arc(x, y, width, height, 0, i * GROTW_FACTOR, Color.white, false);

      arc.addTo(window);
      try {
        Thread.sleep(DELAY);
      } catch (Exception e) {
      }
    }
  }

  /**
   * Renders the trigonometric circumference in the specified graphics window.
   *
   * @param window the graphics window in which to render the circumference
   */
  public void render(GWindow window) {
    drawCircunference(window);
  }

  // Width, height
  private int height;
  private int width;

}
