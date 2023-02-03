package org.locker.repository;

import org.locker.model.Locker;
import org.locker.model.LockerItem;
import org.locker.model.Size;
import org.locker.model.Slot;

import java.util.List;

public interface LockerRepository {
    Locker createLocker(int lockerId, Size size, List<Slot> slots);

    List<Slot> getAvailableSlots(int lockerId);

    Locker getLocker(int lockerId);

    Slot deAllocateSlot(int lockerId, int slotId);

    Slot allocateSlot(int lockerId, Slot slot, LockerItem lockerItem);
}
