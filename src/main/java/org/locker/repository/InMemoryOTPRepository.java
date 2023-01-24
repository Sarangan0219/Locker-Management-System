package org.locker.repository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryOTPRepository implements OTPRepository{

    private final Map<Integer, String> slotIdToOtpMap;

    public InMemoryOTPRepository() {
        this.slotIdToOtpMap = new HashMap<>();
    }

    @Override
    public void addOtp(final int slotId, final String otp) {
        slotIdToOtpMap.put(slotId, otp);
    }

    @Override
    public String getOtp(final int slotId) {
        return slotIdToOtpMap.get(slotId);
    }
}
