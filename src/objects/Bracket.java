package objects;

import java.awt.Color;

import uwcse.graphics.GWindow;
import uwcse.graphics.Line;

public class Bracket {
  public Bracket(int x1, int y1, int x2, int y2, boolean vertical, boolean right, java.awt.Color color) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.vertical = vertical;
    this.color = color;
    this.right = right;
  }

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

  private void addLines(GWindow window) {
    for (int i = 0; i < lines.length; i++) {
      lines[i].addTo(window);
    }
  }

  public void removeFromWindow() {
    for (int i = 0; i < lines.length; i++) {
      lines[i].removeFromWindow();
    }
  }

  public void addTo(GWindow window) {
    createLines();
    addLines(window);
  }

  private boolean right;
  private boolean vertical;
  private Line[] lines = new Line[3];
  private int x1;
  private int y1;
  private int x2;
  private int y2;
  private java.awt.Color color;
}
