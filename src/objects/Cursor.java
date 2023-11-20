package objects;

/**
 * The Cursor class represents a graphical cursor with a base and a triangular top.
 * It provides methods to set the properties of the cursor, such as width and position,
 * render it in a graphics window, move it, and animate its movement.
 * 
 * The cursor is composed of a base and a triangular top, both drawn with pixel lines, rectangles, and triangles.
 * The cursor can be moved and animated for a smooth transition.
 * 
 * @author [Your Name]
 * @version 1.0
 */
import java.awt.Color;

import utils.PixelLine;
import uwcse.graphics.GWindow;
import uwcse.graphics.Rectangle;
import uwcse.graphics.Triangle;

public class Cursor {
  /**
   * Constructs a new cursor with the specified width and position.
   *
   * @param width the width of the cursor
   * @param posX  the x-coordinate of the cursor's position
   * @param posY  the y-coordinate of the cursor's position
   */
  public Cursor(int width, int posX, int posY) {
    this.width = width;
    this.posX = posX;
    this.posY = posY;
  }

  /**
   * Increments the index for the pixel lines array.
   *
   * @return the incremented index
   */
  private int indexAcum() {
    indexLine++;
    return indexLine;
  }

  /**
   * Draws the base of the cursor with pixel lines and rectangles.
   *
   * @param baseHeigth the height of the base
   * @param baseWidth  the width of the base
   * @param blockSide  the side length of a block
   */
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

  /**
   * Draws the top of the cursor with pixel lines and triangles.
   *
   * @param blockSide   the side length of a block
   * @param triangleTop the top length of the triangular part
   */
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

  /**
   * Sets the graphics window for rendering the cursor.
   *
   * @param window the graphics window
   */
  public void setWindow(GWindow window) {
    this.window = window;
  }

  /**
   * Adds the cursor to the specified graphics window.
   *
   * @param window the graphics window to add the cursor to
   */
  public void addTo(GWindow window) {
    final int EIGHTEEN = 18;
    final int TWELVE = 12;
    setWindow(window);
    cursorTop(width / EIGHTEEN, width / TEN);
    cursorBase(width / EIGHTEEN, width / TWELVE, width / EIGHTEEN);
  };

  /**
   * Moves the cursor by the specified delta values.
   *
   * @param deltaX the change in the x-coordinate
   * @param deltaY the change in the y-coordinate
   */
  public void moveBy(int deltaX, int deltaY) {
    final int FIVE = 5;
    final int THIRTY = 30;
    for (int i = 0; i < pixelLines.length; i++)
      pixelLines[i].moveBy(deltaX, deltaY);
    for (int i = 0; i < triangles.length; i++)
      triangles[i].moveTo(deltaX + FIVE, deltaY + FIVE);
    rec.moveTo(deltaX + THIRTY, deltaY + THIRTY);
  }

  /**
   * Animates the movement of the cursor with a specified number of key frames.
   *
   * @param keyFrames the number of key frames for the animation
   * @param deltaX    the change in the x-coordinate for each frame
   * @param deltaY    the change in the y-coordinate for each frame
   */

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
