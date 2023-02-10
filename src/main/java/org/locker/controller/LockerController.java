package org.locker.controller;

import org.locker.dto.SlotDTO;
import org.locker.model.*;
import org.locker.service.LockerService;
import org.locker.service.NotificationService;
import org.locker.service.OTPService;
import org.locker.service.SlotService;

import java.util.List;
import java.util.stream.Collectors;

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

    public Locker createLocker(int lockerId, Size size, List<Slot> slots) {
        Locker locker = lockerService.createLocker(lockerId, size, slots);
        return locker;
    }

    public List<SlotDTO> getAvailableSlots(int lockerId) {
        return slotService.getAvailableSlots(lockerId);
    }

    public boolean unlockSlot(int slotId, final String otp) {
        return otpService.validateOTP(slotId, otp);
    }

    public SlotDTO allocateSlot(int lockerId, LockerItem lockerItem, LockerUser user) {
        SlotDTO slotDTO = slotService.allocateSlot(lockerId, lockerItem);
        String otp = otpService.generateOTP(slotDTO.getSlotId());
        notificationService.notifyUser(user, otp, slotDTO.getSlotId());
        return slotDTO;
    }

    public void deallocateSlot(int lockerId, int slotId) {
        slotService.deAllocateSlot(lockerId, slotId);
    }
}
