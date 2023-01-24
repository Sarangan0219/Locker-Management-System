package org.locker.strategy;

import org.locker.model.Slot;

import java.util.List;

public interface SlotAssignment {
    Slot pickSlot(List<Slot> slots);
}
