package utils;

import uwcse.io.AudioPlayer;
import uwcse.io.Sound;

/**
 * The FxSound class provides a simple interface for playing sound effects.
 * It uses the AudioPlayer class from the uwcse.io package to play a specific
 * sound.
 * 
 * @author Facundo Garay
 * 
 * @version 1.0
 */
public class FxSound {
  // Private constructor to prevent instantiation
  private FxSound() {

  }

  /**
   * Plays the predefined sound effect.
   */
  public static void play() {
    AudioPlayer player = new AudioPlayer();
    player.play(music);
  }

  private static String soundsPath = "src/assets/sounds/";
  private static Sound music = new Sound(soundsPath + "music.wav");
}
