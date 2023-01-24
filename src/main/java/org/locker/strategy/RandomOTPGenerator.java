package org.locker.strategy;

import org.locker.utils.GeneratorUtils;

import java.util.Random;

public class RandomOTPGenerator implements  OTPGenerator{
    @Override
    public String generateOtp() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1 ; i < 7; i++) {
            stringBuilder.append(GeneratorUtils.randomGenerator(10));
        }
        return stringBuilder.toString();
    }
}
