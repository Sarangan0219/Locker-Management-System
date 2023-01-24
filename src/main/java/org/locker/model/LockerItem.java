package org.locker.model;

public abstract  class LockerItem {

    private Size size;

    public Size getSize() {
        return size;
    }

    public LockerItem(Size size) {
        this.size = size;
    }
}
