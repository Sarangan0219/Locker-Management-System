package org.locker.model;


import java.util.Date;

public class Slot {
    private final int slotId;
    private final Size slotSize;
    private boolean isAvailable;
    private LockerItem lockerItem;
    private Date allocatedTime;

    public int getSlotId() {
        return slotId;
    }

    public Size getSlotSize() {
        return slotSize;
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

    public Slot(int slotId, Size slotSize) {
        this.slotId = slotId;
        this.slotSize = slotSize;
        this.isAvailable = true;
    }

    public void allocateItem(LockerItem lockerItem) {
        if (this.isAvailable) {
            this.lockerItem = lockerItem;
            this.isAvailable = false;
            this.allocatedTime = new Date();
        } else {
            throw new IllegalStateException("This slot is already occupied");
        }
    }

    public void deAllocateItem() {
        if (this.isAvailable) {
            throw new IllegalStateException("This slot is not occupied");
        } else {
            this.lockerItem = null;
            this.isAvailable = true;
            this.allocatedTime = null;
        }
    }

}
