package org.locker.repository;

public interface OTPRepository {

    void addOtp(int slotId, String otp);

    String getOtp(int slotId);
}
