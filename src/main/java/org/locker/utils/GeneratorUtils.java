package org.locker.utils;

import java.util.Random;

public class GeneratorUtils {
    public static int randomGenerator(int n) {
        return new Random().nextInt(n);
    }
}
