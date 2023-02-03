package org.locker.dto;

import org.locker.model.LockerItem;
import org.locker.model.Size;

import java.util.Date;

public class SlotDTO {
    private final int slotId;
    private boolean isAvailable;
    private LockerItem lockerItem;
    private Date allocatedTime;

    public int getSlotId() {
        return slotId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public LockerItem getLockerItem() {
        return lockerItem;
    }

    public Date getAllocatedTime() {
        return allocatedTime;
    }

    public SlotDTO(int slotId, boolean isAvailable, LockerItem lockerItem, Date allocatedTime) {
        this.slotId = slotId;
        this.isAvailable = isAvailable;
        this.lockerItem = lockerItem;
        this.allocatedTime = allocatedTime;
    }
}
