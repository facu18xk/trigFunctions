package objects;

import utils.Picture;
import uwcse.graphics.GWindow;
import uwcse.graphics.Rectangle;
import uwcse.graphics.Triangle;

import java.awt.Color;

public class TrigonometricFunctions {
  public TrigonometricFunctions(int x, int y, GWindow window) {
    this.window = window;
    this.x = x;
    this.y = y;
  }

  private int[] renderHypotenuse(int radius) {
    int[] coordinates = new int[4];
    // PI / 4 radians it's equal to 45 degrees
    coordinates[0] = (int) (Math.cos(ANGLE) * radius + x);
    coordinates[1] = (int) (y - (Math.sin(ANGLE) * radius));
    coordinates[2] = (int) (Math.cos(ANGLE) * radius * TWO + x);
    coordinates[3] = y;
    hypotenuse = new Straight(coordinates[0], coordinates[1], coordinates[2], coordinates[3], Color.white,
        true);
    hypotenuse.render(window);
    return coordinates;

  }

  public void cos(double angle, int radius, int width, int height, int deltaX, int deltaY) {
    int cosValue = (int) (Math.cos(angle) * radius);
    cos = new Rectangle(x, y, cosValue, RECTANGLE_SIDE, PINK, true);
    bracketCos = new Bracket(x, y + BRACKET_MARGIN, x + cosValue, y + BRACKET_MARGIN, false, false, CYAN);
    cosImg = new Picture("cos.png", width, height, window);
    cosImg.add(x + deltaX, y + deltaY);
    bracketCos.addTo(window);
    cos.addTo(window);
  }

  public void removeCos() {
    cos.removeFromWindow();
    bracketCos.removeFromWindow();
    cosImg.removeFromWindow();
  }

  public void sin(double angle, int radius, int width, int height, int deltaX, int deltaY) {
    int sinValue = (int) (Math.sin(angle) * radius);
    int posX = (int) (Math.cos(angle) * radius) + x;
    sin = new Rectangle(posX, y - sinValue, RECTANGLE_SIDE, sinValue, CYAN, true);
    bracketSin = new Bracket(posX + BRACKET_MARGIN, y, posX + BRACKET_MARGIN, y - sinValue, true, false, PINK);
    sinImg = new Picture("sen.png", width, height, window);
    sinImg.add(posX + deltaX, y + deltaY);
    bracketSin.addTo(window);
    sin.addTo(window);
  }

  public void removeSin() {
    sin.removeFromWindow();
    bracketSin.removeFromWindow();
    sinImg.removeFromWindow();
  }

  public void tangent(int radius, int width, int height, int deltaX, int deltaY) {
    coordinates = renderHypotenuse(radius);
    try {
      Thread.sleep(DELAY);
    } catch (Exception e) {
    }
    triangle = new Triangle(x, y, coordinates[0], coordinates[1], coordinates[2], coordinates[3], Color.white,
        true);
    triangle.addTo(window);
    tanImg = new Picture("tan.png", width, height, window);
    tanImg.add(x + deltaX, y + deltaY);

  }

  public void removeTan() {
    tanImg.removeFromWindow();
    triangle.removeFromWindow();
  }

  public void sec(int radius, int width, int height, int deltaX, int deltaY) {
    int x2 = (int) (Math.cos(ANGLE) * radius * TWO) + x;
    secImg = new Picture("sec.png", width, height, window);
    bracketSec = new Bracket(x, y + BRACKET_MARGIN, x2, y + BRACKET_MARGIN, false, false, CYAN);
    bracketSec.addTo(window);
    secImg.add(deltaX + x, deltaY + y);
  }

  public void removeSec() {
    secImg.removeFromWindow();
    bracketSec.removeFromWindow();
    secImg.removeFromWindow();
    ;
  }

  public void cosec(int radius, int width, int heigth, int deltaX, int deltaY) {
    int x2 = x;
    int y2 = (int) (y - Math.cos(ANGLE) * radius * TWO);
    int x3 = coordinates[0];
    int y3 = coordinates[1];
    Picture cosecImg = new Picture("cosec.png", width, heigth, window);
    triangle = new Triangle(x, y, x2, y2, x3, y3, Color.white, true);
    bracketCosec = new Bracket(x - BRACKET_MARGIN, y, x2 - BRACKET_MARGIN, y2, true, true, CYAN);
    bracketCosec.addTo(window);
    cosecImg.add(deltaX + x, deltaY + y);
    triangle.addTo(window);
  }

  public void cotan(int width, int height, int deltaX, int deltaY) {
    Picture cotanImg = new Picture("cotan.png", width, height, window);
    cotanImg.add(deltaX + x, deltaY + y);
  }

  private int coordinates[];
  private final double ANGLE = Math.PI / 4;
  private Straight hypotenuse;
  private Triangle triangle;
  private Rectangle cos;
  private Rectangle sin;
  private Bracket bracketCos;
  private Bracket bracketSin;
  private Bracket bracketCosec;
  private Bracket bracketSec;
  private Picture cosImg;
  private Picture sinImg;
  private Picture tanImg;
  private Picture secImg;
  private final int DELAY = 1000;
  private final int TWO = 2;
  private int BRACKET_MARGIN = 30;
  private final Color CYAN = new Color(4, 101, 138);
  private final Color PINK = new Color(127, 16, 154);
  private final int RECTANGLE_SIDE = 8;
  private GWindow window;
  private int x;
  private int y;

}
