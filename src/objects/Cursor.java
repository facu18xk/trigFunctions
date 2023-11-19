package objects;

import java.awt.Color;
import utils.PixelLine;
import uwcse.graphics.GWindow;
import uwcse.graphics.Rectangle;
import uwcse.graphics.Triangle;

public class Cursor {
  public Cursor(int width, int posX, int posY) {
    this.width = width;
    this.posX = posX;
    this.posY = posY;
  }

  private int indexAcum() {
    indexLine++;
    return indexLine;
  }

  private void cursorBase(int baseHeigth, int baseWidth, int blockSide) {
    final int BASE_BLOCKS = 3;
    final int TWO = 2;
    // The core of the base
    pixelLines[indexAcum()] = new PixelLine(posX, posY, BASE_BLOCKS, baseWidth, baseWidth, true, Color.white, true);
    rec = new Rectangle(posX + baseWidth * TWO, posY + baseWidth * THREE, baseWidth * TWO, baseWidth, Color.black,
        true);
    rec.addTo(window);
    // Sides of the base
    pixelLines[indexAcum()] = new PixelLine(posX - baseWidth, posY, BASE_BLOCKS, baseWidth, baseWidth, true,
        Color.black, true);
    pixelLines[indexAcum()] = new PixelLine(posX + baseWidth, posY, BASE_BLOCKS, baseWidth, baseWidth, true,
        Color.black, true);
    // Top of the base
    pixelLines[indexAcum()] = new PixelLine(posX + blockSide * THREE, posY - blockSide * FOUR, TEN, blockSide,
        blockSide, false,
        Color.black, true);
    for (int i = 0; i < pixelLines.length; i++) {
      pixelLines[i].addTo(window);
    }
  }

  private void cursorTop(int blockSide, int triangleTop) {
    final int BORDER = width / 20;
    final int SEVEN = 7;
    final int SIX = 6;

    // Sides of the top
    triangles[0] = new Triangle(posX - blockSide * SEVEN, posY + blockSide * SEVEN,
        posX + blockSide * FOUR,
        posY - blockSide * FOUR, triangleTop - BORDER, triangleTop - BORDER, Color.black, true);
    // Triangle part of cursor
    triangles[1] = new Triangle(posX - blockSide * SIX, posY + blockSide * SIX, posX + blockSide * THREE,
        posY - blockSide * THREE, triangleTop, triangleTop,
        Color.white,
        true);
    for (int i = 0; i < triangles.length; i++) {
      triangles[i].addTo(window);
    }
  }

  public void setWindow(GWindow window) {
    this.window = window;
  }

  public void addTo(GWindow window) {
    final int EIGHTEEN = 18;
    final int TWELVE = 12;
    setWindow(window);
    cursorTop(width / EIGHTEEN, width / TEN);
    cursorBase(width / EIGHTEEN, width / TWELVE, width / EIGHTEEN);
  };

  public void moveBy(int deltaX, int deltaY) {
    final int FIVE = 5;
    final int THIRTY = 30;
    for (int i = 0; i < pixelLines.length; i++)
      pixelLines[i].moveBy(deltaX, deltaY);
    for (int i = 0; i < triangles.length; i++)
      triangles[i].moveTo(deltaX + FIVE, deltaY + FIVE);
    rec.moveTo(deltaX + THIRTY, deltaY + THIRTY);
  }

  public void animate(int keyFrames, int deltaX, int deltaY) {
    for (int i = 0; i <= keyFrames; i++) {
      moveBy(i * deltaX, i * deltaY);
      try {
        Thread.sleep(DELAY);
      } catch (Exception e) {
      }
    }
  }

  final int TEN = 10;
  final int FOUR = 4;
  final int THREE = 3;
  final int DELAY = 15;
  // Cursor's width
  private Rectangle rec;
  private int posX;
  private int posY;
  private Triangle[] triangles = new Triangle[2];
  private PixelLine[] pixelLines = new PixelLine[4];
  // To when incremented for the first time it's equal to 0
  private int indexLine = -1;
  private int width;
  private GWindow window;
}
