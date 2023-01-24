package org.example.model;

import org.junit.Assert;
import org.junit.Test;
import org.locker.model.AmazonPackage;
import org.locker.model.Locker;
import org.locker.model.Size;
import org.locker.model.Slot;

import java.util.Arrays;
import java.util.List;

public class LockerTest {

    @Test
    public void getAvailableSlotsTest() {
        Slot slot = new Slot(1, new Size(3.0, 3.0, 3.0));
        Slot slot2 = new Slot(2, new Size(4.0, 4.0, 4.0));
        Slot slot3 = new Slot(3, new Size(4.0, 4.0, 4.0));
        List<Slot> slotList = Arrays.asList(slot, slot2, slot3);


        Locker locker = new Locker(1, new Size(50.0, 50.0, 50.0), slotList);
        slot.allocateItem(new AmazonPackage(new Size(1.0, 1.0, 1.0)));
        Assert.assertFalse(locker.getAvailableSlots().contains(slot));
    }
}
