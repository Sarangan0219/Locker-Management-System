package org.locker.service;

import org.locker.model.Size;
import org.locker.model.Slot;
import org.locker.repository.LockerRepository;

import java.util.List;

public class LockerService {

    private LockerRepository lockerRepository;


    public LockerService(LockerRepository lockerRepository) {
        this.lockerRepository = lockerRepository;
    }

    public void createLocker(int lockerId, Size size, List<Slot> slots) {
        lockerRepository.createLocker(lockerId, size, slots);
    }

}
