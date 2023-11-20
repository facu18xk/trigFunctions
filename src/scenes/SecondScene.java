package scenes;

import java.awt.Color;

import objects.Angle;
import objects.Bracket;
import objects.CoordinateSystem;
import objects.Straight;
import objects.TrigonometricCirunference;
import utils.Picture;
import uwcse.graphics.GWindow;

/**
 * The SecondScene class represents the second scene of an application.
 * It provides methods for setting up and playing the second scene, including
 * creating and rendering objects such as a coordinate system, trigonometric
 * circumference,
 * angles, brackets, and a straight line.
 * * @author Facundo Garay
 * 
 * @version 1.0
 */
public class SecondScene {

  /**
   * Constructs a SecondScene object.
   */
  public SecondScene() {
  }

  /**
   * Renders the hypotenuse of a right-angled triangle on the specified graphics
   * window.
   *
   * @param centerX The x-coordinate of the center point.
   * @param centerY The y-coordinate of the center point.
   * @param window  The graphics window to render the hypotenuse.
   */
  private void renderHypotenuse(int centerX, int centerY, GWindow window) {
    final double FOUR = 4;
    final double ANGLE = Math.PI / FOUR;
    // PI / 4 radians it's equal to 45 degrees
    int x2 = (int) (Math.cos(ANGLE) * RADIUS + centerX);
    int y2 = (int) (centerY - (Math.sin(ANGLE) * RADIUS));
    Straight hypotenuse = new Straight(centerX, centerY, x2, y2, Color.white, false);
    hypotenuse.render(window);
  }

  /**
   * Creates primary objects such as a coordinate system and a trigonometric
   * circumference.
   *
   * @param window The graphics window to render the objects.
   */
  private void createPrimaryObjects(GWindow window) {
    cSystem = new CoordinateSystem(COORDINATE_SYSTEM_DIMENSIONS[X], COORDINATE_SYSTEM_DIMENSIONS[Y]);
    circumference = new TrigonometricCirunference(CIRCUNFERENCE_DIMENSIONS[X],
        CIRCUNFERENCE_DIMENSIONS[Y]);
  }

  /**
   * Creates secondary objects such as brackets, angles, and pictures.
   *
   * @param window The graphics window to render the objects.
   */
  private void createSecondaryObjects(GWindow window) {
    bracket = new Bracket(cSystem.getCenterX(), cSystem.getCenterY() + DELTA_Y, cSystem.getCenterX() + RADIUS,
        cSystem.getCenterY() + DELTA_Y, false, false, Color.white);
    angleAlpha = new Picture("alpha.png", ALPHA_SIDE, ALPHA_SIDE, window);
    angle = new Angle(ANGLE, cSystem.getCenterX(), cSystem.getCenterY(), ANGLE_SIDE, ANGLE_SIDE);
    radiusOne = new Picture("radius.png", RADIUS_IMG_DIMENSIONS[X], RADIUS_IMG_DIMENSIONS[Y], window);

  }

  /**
   * Plays the second scene, rendering primary and secondary objects on the
   * specified graphics window.
   *
   * @param window The graphics window to display the scene.
   */
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
