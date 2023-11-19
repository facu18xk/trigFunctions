package objects;

import java.awt.Color;

import uwcse.graphics.GWindow;
import uwcse.graphics.Line;

public class CoordinateSystem {
  public CoordinateSystem(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public int getCenterX() {
    return centerX;
  }

  public void setCenterX(int centerX) {
    this.centerX = centerX;
  }

  public int getCenterY() {
    return centerY;
  }

  public void setCenterY(int centerY) {
    this.centerY = centerY;
  }

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

    drawLine(x1, y1, x2, y2, CYAN, false, window);
  }

  private void renderYaxis(GWindow window) {
    final int TWELVE = 12;
    final int FIVE = 5;
    // Substracting 5 because the background image is not perfectly simetric
    int verticalMargin = (window.getWindowHeight() - height) / TWO;
    setCenterX(window.getWindowWidth() / TWO - FIVE);
    int x1 = getCenterX();
    int y1 = verticalMargin - TWELVE;
    int x2 = getCenterX();
    int y2 = window.getWindowHeight() - (verticalMargin + 29);
    drawLine(x1, y1, x2, y2, PINK, true, window);
  }

  public void render(GWindow window) {
    renderXaxis(window);
    // new thread to create the x and y axis in paralel
    renderYaxis(window);
  }

  private final Color CYAN = new Color(4, 101, 138);
  private final Color PINK = new Color(127, 16, 154);
  private int centerX;
  private int centerY;
  private final int TWO = 2;
  private int verticalMargin;
  private int width;
  private int height;
}
