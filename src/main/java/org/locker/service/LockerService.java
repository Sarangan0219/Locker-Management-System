package org.locker.service;

import org.locker.model.Locker;
import org.locker.model.Size;
import org.locker.model.Slot;
import org.locker.repository.LockerRepository;

import java.util.List;

public class LockerService {

    // Dependency Injection
    private LockerRepository lockerRepository;


    public LockerService(LockerRepository lockerRepository) {
        this.lockerRepository = lockerRepository;
    }

    public Locker createLocker(int lockerId, Size size, List<Slot> slots) {
        return lockerRepository.createLocker(lockerId, size, slots);
    }

}
