package pl.memexurer.coval.helper;

import java.util.Random;
import java.util.regex.Pattern;
import org.apache.commons.lang.Validate;

public class RandomHelper {
  private static final Random rand = new Random();;


  public static int getRandInt(final int min, final int max) throws IllegalArgumentException {
    Validate.isTrue(max > min, "Max can't be smaller than min!");
    return rand.nextInt(max - min + 1) + min;
  }

  public static Double getRandDouble(final double min, final double max) throws IllegalArgumentException {
    Validate.isTrue(max > min, "Max can't be smaller than min!");
    return rand.nextDouble() * (max - min) + min;
  }

  public static Float getRandFloat(final float min, final float max) throws IllegalArgumentException {
    Validate.isTrue(max > min, "Max can't be smaller than min!");
    return rand.nextFloat() * (max - min) + min;
  }

  public static boolean getChance(final double chance) {
    return chance >= 100.0 || chance >= getRandDouble(0.0, 100.0);
  }

  public static double round(final double value, final int decimals) {
    final double p = Math.pow(10.0, decimals);
    return Math.round(value * p) / p;
  }

  public static boolean isInteger(final String string) {
    return Pattern.matches("-?[0-9]+", string.subSequence(0, string.length()));
  }
}
