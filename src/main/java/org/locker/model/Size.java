package org.locker.model;

public class Size {
    private final double length;
    private final double width;
    private final double height;

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Size(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public boolean canAccommodate(Size sizeToAccommodate) {
        return this.width > sizeToAccommodate.width && this.width > sizeToAccommodate.width &&
                this.height > sizeToAccommodate.height;
    }
}
