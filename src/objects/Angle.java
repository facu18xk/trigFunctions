package objects;

import java.awt.Color;

import uwcse.graphics.Arc;
import uwcse.graphics.GWindow;

public class Angle {
  public Angle(int degree, int x, int y, int width, int height) {
    this.degree = degree;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

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

  private int width;
  private int height;
  private Arc angle;
  private int x;
  private int y;
  private int degree;
}
