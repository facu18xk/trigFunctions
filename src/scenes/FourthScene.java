package scenes;

import utils.Picture;
import uwcse.graphics.GWindow;

public class FourthScene {
  public FourthScene(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public void play(GWindow window) {
    final int widthTitle = 500;
    final int heightTitle = 200;
    final int widthQr = 300;
    final int heightQr = 300;
    final int TWO = 2;
    final int FIVE = 5;
    Picture background = new Picture("appFullScreen.png", width, height, window);
    Picture title = new Picture("final.png", widthTitle, heightTitle, window);
    Picture qr = new Picture("qr.png", widthQr, heightQr, window);
    background.add(0, 0);
    int qrX = width / TWO - (widthQr / TWO);
    int qrY = height / TWO - (widthQr / TWO) + (heightTitle / TWO);
    qr.add(qrX, qrY);
    title.add(width / TWO - (widthTitle / TWO), height / FIVE);

  }

  private int width;
  private int height;
}
