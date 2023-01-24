package org.example.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.locker.model.AmazonPackage;
import org.locker.model.LockerItem;
import org.locker.model.Size;
import org.locker.model.Slot;

public class SlotTest {

    Slot slot;
    Size slotSize;
    AmazonPackage amazonPackage;
    Size packageSize;
    @Before
    public void init() {
        slotSize = new Size(2.1,2.1,2.1);
        slot = new Slot(1, slotSize);
        packageSize = new Size(2.0,2.0,2.0);
        amazonPackage = new AmazonPackage(packageSize);
    }

    @Test
    public void allocateItemTest() {
        slot.allocateItem(amazonPackage);
        Assert.assertEquals(amazonPackage, slot.getLockerItem());
        Assert.assertFalse(slot.isAvailable());
    }

    @Test()
    public void deAllocateItemTest() {
        slot.allocateItem(amazonPackage);
        slot.deAllocateItem();
        Assert.assertNull(slot.getLockerItem());
        Assert.assertTrue(slot.isAvailable());
    }

}
