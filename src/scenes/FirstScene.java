package scenes;

import uwcse.graphics.GWindow;
import utils.Picture;
import objects.Cursor;
import objects.Window;

public class FirstScene {
  public FirstScene(int width, int heigth) {
    this.heigth = heigth;
    this.width = width;
  }

  private void nextSceneBackground(GWindow window) {
    final int DELAY = 700;// in ms
    try {
      Thread.sleep(DELAY);
      Picture background = new Picture("appFullScreen.png", width, heigth, window);
      background.add(0, 0);
    } catch (Exception e) {
    }
  }

  public void play(GWindow window) {
    Picture background = new Picture("background1.png", width, heigth, window);
    background.add(0, 0);
    Picture app = new Picture("funciones.png", APP_DIMENSIONS[0], APP_DIMENSIONS[1], window);
    app.add(APP_DIMENSIONS[2], APP_DIMENSIONS[3]);
    Window appWindow = new Window(width, heigth, window, "funcionesFull.png");
    Cursor cursor = new Cursor(CURSOR_DIMENSIONS[0], CURSOR_DIMENSIONS[1], CURSOR_DIMENSIONS[2]);
    cursor.addTo(window);
    cursor.animate(KEY_FRAMES, X_INCREMENT, Y_INCREMENT);
    appWindow.maximize();
    nextSceneBackground(window);
  }

  // Factors finded with the pythagorean theorem the 13 is the increment in the
  // x axis and 3 in the y axis
  final int X_INCREMENT = 13;
  final int Y_INCREMENT = 3;
  final int KEY_FRAMES = 55;
  // width, heigth, posX, posY
  final int APP_DIMENSIONS[] = { 442, 476, 330, 183 };
  // cursor dimensions
  // width, x, y
  final int CURSOR_DIMENSIONS[] = { 50, 30, 30 };
  private int heigth;
  private int width;
}
