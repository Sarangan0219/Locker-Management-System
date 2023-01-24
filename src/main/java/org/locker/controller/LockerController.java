package org.locker.controller;

import org.locker.model.LockerItem;
import org.locker.model.LockerUser;
import org.locker.model.Size;
import org.locker.model.Slot;
import org.locker.service.LockerService;
import org.locker.service.NotificationService;
import org.locker.service.OTPService;
import org.locker.service.SlotService;

import java.util.List;

public class LockerController {

    private LockerService lockerService;
    private OTPService otpService;
    private SlotService slotService;
    private NotificationService notificationService;

    public LockerController(LockerService lockerService, OTPService otpService, SlotService slotService, NotificationService notificationService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
        this.slotService = slotService;
        this.notificationService = notificationService;
    }

    public void createLocker(int lockerId, Size size, List<Slot> slots) {
        lockerService.createLocker(lockerId, size, slots);
    }

    public List<Slot> getAvailableSlots(int lockerId) {
        return slotService.getAvailableSlots(lockerId);
    }

    public boolean unlockSlot(int slotId, final String otp) {
        return otpService.validateOTP(slotId, otp);
    }

    public Slot allocateSlot(int lockerId, LockerItem lockerItem, LockerUser user) {
        Slot slot = slotService.allocateSlot(lockerId, lockerItem);
        String otp = otpService.generateOTP(slot.getSlotId());
        notificationService.notifyUser(user, otp, slot);
        return slot;
    }

    public void deallocateSlot(int lockerId, int slotId) {
        slotService.deAllocateSlot(lockerId, slotId);
    }
}
