package org.locker.service;

import org.locker.model.Slot;
import org.locker.repository.OTPRepository;
import org.locker.strategy.OTPGenerator;

public class OTPService {

    private OTPGenerator otpGenerator;
    private OTPRepository otpRepository;

    public OTPService(OTPGenerator otpGenerator, OTPRepository otpRepository) {
        this.otpGenerator = otpGenerator;
        this.otpRepository = otpRepository;
    }

    public String generateOTP(int slotId) {
        String otp = otpGenerator.generateOtp();
        otpRepository.addOtp(slotId, otp);
        return otp;
    }

    public boolean validateOTP(int slotId, String otp) {
        if (otpRepository.getOtp(slotId).equals(otp)) {
            return true;
        }
        return false;
    }
}
