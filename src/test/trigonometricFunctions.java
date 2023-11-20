package test;

import scenes.FirstScene;
import scenes.FourthScene;
import scenes.SecondScene;
import scenes.ThirdScene;
import utils.FxSound;
import uwcse.graphics.GWindow;

/**
 * The trigonometricFunctions class serves as the entry point for the
 * application.
 * It initializes a graphics window and orchestrates the display of multiple
 * scenes
 * representing different aspects of trigonometric functions.
 * 
 * @author Facundo Garay
 * 
 * @version 1.0
 */
public class trigonometricFunctions {
  public static void main(String args[]) {
    int width = 1200;
    int heigth = 800;
    GWindow window = new GWindow("Fuciones Trigonometricas", width, heigth);
    // Create instances of scene classes
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
