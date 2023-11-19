package utils;

import uwcse.graphics.GWindow;
import uwcse.graphics.Rectangle;

public class PixelLine {
  public PixelLine(int x, int y, int lineLength, int blockWidth, int blockHeigth, boolean descendent,
      java.awt.Color color, boolean fill) {
    this.x = x;
    this.y = y;
    this.lineLength = lineLength;
    this.blockHeigth = blockHeigth;
    this.blockWidth = blockWidth;
    this.descendent = descendent;
    this.color = color;
    this.fill = fill;
  }

  private void setWin(GWindow win) {
    this.win = win;
  }

  // Return an array of the coordinates in wich the block going to be painted
  private int[] pixelArtPositioning(boolean ascendent, int blockWidth, int blockHeigth) {
    int[] delta = { 0, 0 };
    final int X = 0;
    final int Y = 1;
    if (ascendent) {
      delta[X] += blockWidth;
      delta[Y] += blockHeigth;
    } else {
      delta[X] -= blockWidth;
      delta[Y] += blockHeigth;
    }
    return delta;
  }

  // Add all the rectangles in to the windows
  private void renderLine() {
    for (int i = 0; i < blocks.length; i++) {
      blocks[i].addTo(win);
    }
  }

  // Create a line in pixel art style the line have a 45 degree inclination, the
  // slope can be positive or negative
  private void linePixelArt(int posX, int posY) {
    int blockPosX = posX;
    int blockPosY = posY;
    // Is the change in position of the next block
    int delta[];
    for (int i = 0; i < lineLength; i++) {
      if (i != 0) {
        delta = pixelArtPositioning(descendent, blockWidth, blockHeigth);
        blockPosX += delta[0];
        blockPosY += delta[1];
      }
      blocks[i] = new Rectangle(blockPosX, blockPosY, blockWidth, blockHeigth, color, fill);
    }
    renderLine();
  }

  public void addTo(GWindow window) {
    blocks = new Rectangle[lineLength];
    setWin(window);
    linePixelArt(x, y);
  }

  private void hideRectangles() {
    // Remove the current rectangles
    for (int i = 0; i < blocks.length; i++) {
      blocks[i].removeFromWindow();
    }

  }

  public void moveBy(int pivotX, int pivotY) {
    hideRectangles();
    // Create the new rectangles with a offset in y and x
    int dx = x + pivotX;
    int dy = y + pivotY;
    linePixelArt(dx, dy);
  }

  private GWindow win;
  private int x;
  private int y;
  private int lineLength;
  private int blockWidth;
  private int blockHeigth;
  private boolean descendent;
  private java.awt.Color color;
  private boolean fill;
  private Rectangle[] blocks;
}
