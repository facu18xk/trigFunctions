package scenes;

import objects.TrigonometricCirunference;
import utils.Picture;
import uwcse.graphics.GWindow;
import java.awt.Color;

import objects.Angle;
import objects.Bracket;
import objects.CoordinateSystem;
import objects.Straight;

public class SecondScene {
  public SecondScene() {
  }

  private void renderHypotenuse(int centerX, int centerY, GWindow window) {
    final double FOUR = 4;
    final double ANGLE = Math.PI / FOUR;
    // PI / 4 radians it's equal to 45 degrees
    int x2 = (int) (Math.cos(ANGLE) * RADIUS + centerX);
    int y2 = (int) (centerY - (Math.sin(ANGLE) * RADIUS));
    Straight hypotenuse = new Straight(centerX, centerY, x2, y2, Color.white, false);
    hypotenuse.render(window);
  }

  private void createPrimaryObjects(GWindow window) {
    cSystem = new CoordinateSystem(COORDINATE_SYSTEM_DIMENSIONS[X], COORDINATE_SYSTEM_DIMENSIONS[Y]);
    circumference = new TrigonometricCirunference(CIRCUNFERENCE_DIMENSIONS[X],
        CIRCUNFERENCE_DIMENSIONS[Y]);
  }

  private void createSecondaryObjects(GWindow window) {
    bracket = new Bracket(cSystem.getCenterX(), cSystem.getCenterY() + DELTA_Y, cSystem.getCenterX() + RADIUS,
        cSystem.getCenterY() + DELTA_Y, false, false, Color.white);
    angleAlpha = new Picture("alpha.png", ALPHA_SIDE, ALPHA_SIDE, window);
    angle = new Angle(ANGLE, cSystem.getCenterX(), cSystem.getCenterY(), ANGLE_SIDE, ANGLE_SIDE);
    radiusOne = new Picture("radius.png", RADIUS_IMG_DIMENSIONS[X], RADIUS_IMG_DIMENSIONS[Y], window);

  }

  public void play(GWindow window) {
    createPrimaryObjects(window);
    cSystem.render(window);
    createSecondaryObjects(window);
    bracket.addTo(window);
    radiusOne.add(cSystem.getCenterX() + 50, cSystem.getCenterY() + 30);
    try {
      Thread.sleep(1500);
    } catch (Exception e) {
    }
    radiusOne.removeFromWindow();
    bracket.removeFromWindow();
    circumference.render(window);
    renderHypotenuse(cSystem.getCenterX(), cSystem.getCenterY(), window);
    angle.render(window);
    angleAlpha.add(cSystem.getCenterX() + DELTA_X, cSystem.getCenterY() - DELTA_Y);
  }

  // width X height
  private Picture radiusOne;
  private Angle angle;
  private Picture angleAlpha;
  private Bracket bracket;
  private CoordinateSystem cSystem;
  private TrigonometricCirunference circumference;
  private final int ALPHA_SIDE = 20;
  private final int ANGLE_SIDE = 60;
  private final int ANGLE = 45;
  private final int DELTA_Y = 25;
  private final int DELTA_X = 30;
  private final int X = 0;
  private final int Y = 1;
  private final int RADIUS = 190;
  private final int RADIUS_IMG_DIMENSIONS[] = { 95, 40 };
  private final int COORDINATE_SYSTEM_DIMENSIONS[] = { 750, 452 };
  private final int CIRCUNFERENCE_DIMENSIONS[] = { RADIUS * 2, RADIUS * 2 };
}
