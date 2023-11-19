package objects;

import uwcse.graphics.GWindow;
import uwcse.graphics.Line;
import java.awt.Color;

public class Straight extends Line {
  public Straight(int x1, int y1, int x2, int y2, Color color, boolean negativeSlope) {
    super(x1, y1, x2, y2, color);
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;
    this.negativeSlope = negativeSlope;
  }

  private double calculateHypotenuse(int adjacent, int opposite) {
    return Math.sqrt((Math.pow(adjacent, SQUARE) + Math.pow(opposite, SQUARE)));
  }

  private double calculateAngle(int adjacent, int opposite) {
    double tangent = opposite / adjacent;
    return Math.atan(tangent);
  }

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