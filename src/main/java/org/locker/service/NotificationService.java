package org.locker.service;

import org.locker.model.LockerUser;
import org.locker.model.Slot;

public class NotificationService {

    public void notifyUser(final LockerUser user, final String otp, final int slotId) {
        // Use third party api to send actual notification like sms, email etc.
        System.out.println("Sending notification of otp: " + otp + " to: " + user + " for slot: " + slotId);
    }
}
