package scenes;

import objects.TrigonometricFunctions;
import uwcse.graphics.GWindow;

public class ThirdScene {
  public ThirdScene(int height, int width) {
    centerX = width / 2;
    centerY = height / 2;
  }

  public void play(GWindow window) {
    TrigonometricFunctions trigFunctions = new TrigonometricFunctions(centerX, centerY, window);
    trigFunctions.sin(ANGLE, RADIUS, WIDTH_IMG, HEIGHT_IMG, SIN_COORDINATES[DELTA_X],
        SIN_COORDINATES[DELTA_Y]);
    try {
      Thread.sleep(DELAY);
    } catch (Exception e) {
    }
    trigFunctions.cos(ANGLE, RADIUS, WIDTH_IMG, HEIGHT_IMG, COS_COORDINATES[DELTA_X],
        COS_COORDINATES[DELTA_Y]);
    try {
      Thread.sleep(DELAY);
    } catch (Exception e) {
    }
    trigFunctions.removeCos();
    trigFunctions.removeSin();
    trigFunctions.tangent(RADIUS, WIDTH_IMG, HEIGHT_IMG, TAN_COORDINATES[DELTA_X],
        TAN_COORDINATES[DELTA_Y]);
    trigFunctions.sec(RADIUS, WIDTH_IMG, HEIGHT_IMG, SEC_COORDINATES[DELTA_X], SEC_COORDINATES[DELTA_Y]);
    try {
      Thread.sleep(DELAY);
    } catch (Exception e) {
    }
    trigFunctions.removeTan();
    trigFunctions.removeSec();
    trigFunctions.cosec(RADIUS, WIDTH_IMG, HEIGHT_IMG, COSEC_COORDINATES[DELTA_X], COSEC_COORDINATES[DELTA_Y]);
    trigFunctions.cotan(WIDTH_IMG, HEIGHT_IMG, COTAN_COORDINATES[DELTA_X], COTAN_COORDINATES[DELTA_Y]);
    try {
      Thread.sleep(DELAY);
    } catch (Exception e) {

    }
  }

  // Index
  private final int DELAY = 3000;
  private final int WIDTH_IMG = 80;
  private final int HEIGHT_IMG = 37;
  private final int DELTA_X = 0;
  private final int DELTA_Y = 1;
  private final int COSEC_COORDINATES[] = { -120, -150 };
  private final int COTAN_COORDINATES[] = { 100, -220 };
  private final int TAN_COORDINATES[] = { 230, -120 };
  private final int COS_COORDINATES[] = { 30, 50 };
  private final int SIN_COORDINATES[] = { 60, -90 };
  private final int SEC_COORDINATES[] = { 100, 40 };
  private final double ANGLE = Math.PI / 4; // 45 degrees in radians
  private final int RADIUS = 190;
  private int centerX;
  private int centerY;
}