package org.locker.strategy;

import org.locker.model.Slot;
import org.locker.utils.GeneratorUtils;

import java.util.List;
import java.util.Random;

public class RandomSlot implements SlotAssignment{
    @Override
    public Slot pickSlot(List<Slot> slots) {
        if (slots.isEmpty()) {
            return null;
        }
        int slotNum = GeneratorUtils.randomGenerator(slots.size());
        return slots.get(slotNum);
    }
}
