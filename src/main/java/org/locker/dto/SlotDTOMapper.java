package org.locker.dto;

import org.locker.model.Slot;

import java.util.function.Function;

public class SlotDTOMapper  implements Function <Slot, SlotDTO> {
    @Override
    public SlotDTO apply(Slot slot) {
        return new SlotDTO(slot.getSlotId(), slot.isAvailable(), slot.getLockerItem(), slot.getAllocatedTime());
    }
}
