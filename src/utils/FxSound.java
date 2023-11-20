package utils;

import uwcse.io.AudioPlayer;
import uwcse.io.Sound;

public class FxSound {
  private FxSound() {

  }

  public static void play() {
    AudioPlayer player = new AudioPlayer();
    player.play(music);
  }

  private static String soundsPath = "src/assets/sounds/";
  private static Sound music = new Sound(soundsPath + "music.wav");
}
