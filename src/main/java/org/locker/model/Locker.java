package org.locker.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Locker {
    private final int lockerId;
    private final Size lockerSize;

    public int getLockerId() {
        return lockerId;
    }

    public Size getLockerSize() {
        return lockerSize;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    private final List<Slot> slots;

    public Locker(int lockerId, Size lockerSize, List<Slot> slots) {
        this.lockerId = lockerId;
        this.lockerSize = lockerSize;
        this.slots = slots;
    }

    public List<Slot> getAvailableSlots() {
        return this.slots.stream().filter(Slot::isAvailable).collect(Collectors.toList());
    }

    public Slot getSlot(int slotId) {
        return this.slots.stream().filter((slot) -> slot.getSlotId() == slotId).findFirst().orElse(null);
    }
}
