package objects;

import uwcse.graphics.GWindow;
import uwcse.graphics.Rectangle;
import java.awt.Color;

public class WindowComponent {
  /**
   * 
   * @param width
   * @param height
   * @param window
   */
  public WindowComponent(int width, int height, GWindow window) {
    this.window = window;
    this.width = width;
    this.height = height;
  }

  public void createTitleBar() {

  }

  public void add(int posX, int posY) {
    final int HEADER_HEIGTH = 30;
    final int BUTTON_SIDE = 16;
    final int BUTTON_MARGIN = 10;
    final int HEADER_BUTTONS_POS_X = posX + width - 100;
    final int HEADER_BUTTONS_POS_Y = posY;
    Rectangle rectangleWindow = new Rectangle(posX, posY, width, height, Color.BLACK, false);
    Rectangle rectangleHeader = new Rectangle(posX, posY, width, HEADER_HEIGTH, Color.black, false);
    Rectangle minimizeButton = new Rectangle(HEADER_BUTTONS_POS_X, HEADER_BUTTONS_POS_Y, BUTTON_SIDE, BUTTON_SIDE, null,
        false);
    Rectangle maximizeButton = new Rectangle(HEADER_BUTTONS_POS_X + BUTTON_MARGIN, HEADER_BUTTONS_POS_Y, BUTTON_SIDE,
        BUTTON_SIDE, Color.black, false);
    Rectangle closeWindow = new Rectangle(HEADER_BUTTONS_POS_X + BUTTON_MARGIN   +, posY, HEADER_BUTTONS_POS_Y, 
        EADER_HEIGTH, null,
        false);
    rectangleWindow.addTo(window);
    rectangleHeader.addTo(window);
  }

  /**
   * Get the heigth of the window
   * 
   * @return
   */
  public int getHeight() {
    return height;
  }

  /**
   * Get the width of the window
   * 
   * @return
   */
  public int getWidth() {
    return width;
  }

  private int width;
  private int height;
  private GWindow window;
}
