package objects;

/**
 * The Braket class represents a bracket visualized as lines in a graphics window.
 * It provides methods to set the properties of the bracket and manipulate its appearance.
 *
 * @author Facundo Garay
 * @version 1.0
 */
import uwcse.graphics.GWindow;
import uwcse.graphics.Line;

public class Bracket {
  /**
   * Constructs a new bracket with the specified coordinates, orientation, and
   * color.
   *
   * @param x1       the x-coordinate of the first endpoint of the bracket
   * @param y1       the y-coordinate of the first endpoint of the bracket
   * @param x2       the x-coordinate of the second endpoint of the bracket
   * @param y2       the y-coordinate of the second endpoint of the bracket
   * @param vertical {@code true} if the bracket is vertical, {@code false} if
   *                 horizontal
   * @param right    {@code true} if the bracket is oriented to the right,
   *                 {@code false} if left
   * @param color    the color of the bracket
   */
  public Bracket(int x1, int y1, int x2, int y2, boolean vertical, boolean right, java.awt.Color color) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.vertical = vertical;
    this.color = color;
    this.right = right;
  }

  /**
   * Creates the lines that form the bracket based on its properties.
   */
  private void createLines() {
    final int BRACKET_HEIGTH = 20;
    lines[0] = new Line(x1, y1, x2, y2, color);
    if (vertical) {
      int posX2 = x2 - BRACKET_HEIGTH;
      int posX1 = x1 - BRACKET_HEIGTH;
      if (right) {
        posX1 = x1 + BRACKET_HEIGTH;
        posX2 = x2 + BRACKET_HEIGTH;
      }
      lines[1] = new Line(x1, y1, posX1, y1, color);
      lines[2] = new Line(x2, y2, posX2, y2, color);

    } else {
      lines[1] = new Line(x1, y1, x1, y1 - BRACKET_HEIGTH, color);
      lines[2] = new Line(x2, y2, x2, y2 - BRACKET_HEIGTH, color);
    }
  }

  /**
   * Adds the lines of the bracket to the specified graphics window.
   *
   * @param window the graphics window to which the bracket lines will be added
   */
  private void addLines(GWindow window) {
    for (int i = 0; i < lines.length; i++) {
      lines[i].addTo(window);
    }
  }

  /**
   * Removes the bracket lines from the graphics window.
   */
  public void removeFromWindow() {
    for (int i = 0; i < lines.length; i++) {
      lines[i].removeFromWindow();
    }
  }

  /**
   * Adds the bracket to the specified graphics window.
   *
   * @param window the graphics window to which the bracket will be added
   */
  public void addTo(GWindow window) {
    createLines();
    addLines(window);
  }
  // Private members

  private boolean right;
  private boolean vertical;
  private Line[] lines = new Line[3];
  private int x1;
  private int y1;
  private int x2;
  private int y2;
  private java.awt.Color color;
}
