package test;

import uwcse.graphics.GWindow;
import scenes.FirstScene;
import scenes.FourthScene;
import scenes.SecondScene;
import scenes.ThirdScene;
import utils.FxSound;

public class trigonometricFunctions {
  public static void main(String args[]) {
    int width = 1200;
    int heigth = 800;
    GWindow window = new GWindow("Fuciones Trigonometricas", width, heigth);
    FirstScene sceneOne = new FirstScene(width, heigth);
    SecondScene sceneTwo = new SecondScene();
    ThirdScene sceneThree = new ThirdScene(heigth, width);
    FourthScene sceneFour = new FourthScene(width, heigth);
    FxSound.play();
    sceneOne.play(window);
    sceneTwo.play(window);
    sceneThree.play(window);
    sceneFour.play(window);
  }
}
