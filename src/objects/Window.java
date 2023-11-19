package objects;

import utils.Picture;
import uwcse.graphics.GWindow;

public class Window {
  public Window(int width, int height, GWindow window, String img) {
    this.window = window;
    this.img = img;
    this.width = width;
    this.height = height;
  }

  private void fullScreen() {
    app = new Picture(img, width, height, window);
    app.add(0, 0);
  }

  private void maximizeAnimation() {
    app = new Picture(img, width, height, window);
    ;
    int appWidth, appHeight;
    int appPosX, appPosY;
    for (double i = 0.7; i <= ONE; i += INCREMENT_FACTOR) {
      appWidth = (int) (width * i);
      appHeight = (int) (height * i);
      appPosX = width / TWO - appWidth / TWO;
      appPosY = height / TWO - appHeight / TWO;
      app = new Picture(img, appWidth, appHeight, window);
      app.add(appPosX, appPosY);
    }
  }

  public void maximize() {
    maximizeAnimation();
    fullScreen();
  }

  Picture app;
  final int ONE = 1;
  final int TWO = 2;
  final double INCREMENT_FACTOR = .020;
  private int height;
  private int width;
  private GWindow window;
  private String img;
}
