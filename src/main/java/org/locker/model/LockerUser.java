package org.locker.model;

public abstract class LockerUser {

    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public LockerUser(Contact contact) {
        this.contact = contact;
    }
}
