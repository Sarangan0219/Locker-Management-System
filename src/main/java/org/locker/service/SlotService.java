package org.locker.service;

import org.locker.model.LockerItem;
import org.locker.model.Slot;
import org.locker.repository.LockerRepository;
import org.locker.repository.OTPRepository;
import org.locker.strategy.OTPGenerator;
import org.locker.strategy.SlotAssignment;

import java.util.List;
import java.util.stream.Collectors;

public class SlotService {
    private LockerRepository lockerRepository;
    private OTPRepository otpRepository;
    private SlotAssignment slotAssignment;
    private OTPGenerator otpGenerator;

    public SlotService(LockerRepository lockerRepository, OTPRepository otpRepository, SlotAssignment slotAssignment, OTPGenerator otpGenerator) {
        this.lockerRepository = lockerRepository;
        this.otpRepository = otpRepository;
        this.slotAssignment = slotAssignment;
        this.otpGenerator = otpGenerator;
    }

    public List<Slot> getAvailableSlots(int lockerId) {
        return  lockerRepository.getAvailableSlots(lockerId);
    }

    public void deAllocateSlot(int lockId, int slotId) {
        lockerRepository.deAllocateSlot(lockId, slotId);
    }

    public Slot allocateSlot(int lockId, LockerItem lockerItem) {
        List<Slot> slots = getAvailableSlots(lockId);
        List<Slot> filteredSlots = slots.stream()
                .filter(slot -> slot.getSlotSize().canAccommodate(lockerItem.getSize()))
                .collect(Collectors.toList());

        Slot slot = slotAssignment.pickSlot(filteredSlots);

        if (slot != null) {
            return slot;
        } else {
            throw new RuntimeException("Slot not found");
        }
    }


}
