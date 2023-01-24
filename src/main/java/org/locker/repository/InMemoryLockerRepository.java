package org.locker.repository;

import org.locker.model.Locker;
import org.locker.model.Size;
import org.locker.model.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryLockerRepository implements LockerRepository{

    private final List<Locker> lockers;

    public InMemoryLockerRepository() {
        this.lockers = new ArrayList<>();
    }

    @Override
    public Locker createLocker(int id, Size size, List<Slot> slots) {
        if (getLocker(id) != null) {
            throw new IllegalStateException("Locker with Id is already there");
        }
        final Locker locker = new Locker(id, size, slots);
        lockers.add(locker);
        return locker;
    }

    @Override
    public List<Slot> getAvailableSlots(int id) {
        Locker locker = getLocker(id);
        if (locker == null) {
            throw new IllegalStateException("This locker isn not found");
        }
        return locker.getAvailableSlots();
    }

    @Override
    public Locker getLocker(int lockerId) {
        return lockers.stream().filter((locker) -> locker.getLockerId() == lockerId).findFirst().orElse(null);
    }

    public Locker getSlot(int slotId) {
        return lockers.stream().filter((locker) -> locker.getLockerId() == slotId).findFirst().orElse(null);
    }

    public void deAllocateSlot(int lockerId, int slotId) {
        Locker locker = getLocker(lockerId);
        Slot slot = locker.getSlot(slotId);
        slot.deAllocateItem();
    }


}
