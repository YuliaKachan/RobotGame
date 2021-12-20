package game.robot;

import java.util.Random;

public class DamageKey {

    String alphabet = "QWEASDZXC";

   public char getRandomKey() {
        int randIdx = new Random().nextInt(alphabet.length());
        char randChar = alphabet.charAt(randIdx);
        alphabet = alphabet.replace(String.valueOf(randChar), "");
        return randChar;
    }
}
