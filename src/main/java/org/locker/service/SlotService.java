package org.locker.service;

import org.locker.dto.SlotDTO;
import org.locker.dto.SlotDTOMapper;
import org.locker.model.LockerItem;
import org.locker.model.Slot;
import org.locker.repository.LockerRepository;
import org.locker.repository.OTPRepository;
import org.locker.strategy.OTPGenerator;
import org.locker.strategy.SlotAssignment;

import java.util.List;
import java.util.stream.Collectors;

public class SlotService {

    public SlotService(LockerRepository lockerRepository, OTPRepository otpRepository, SlotAssignment slotAssignment,
                       OTPGenerator otpGenerator, SlotDTOMapper slotDTOMapper) {
        this.lockerRepository = lockerRepository;
        this.otpRepository = otpRepository;
        this.slotAssignment = slotAssignment;
        this.otpGenerator = otpGenerator;
        this.slotDTOMapper = slotDTOMapper;
    }

    private LockerRepository lockerRepository;
    private OTPRepository otpRepository;
    private SlotAssignment slotAssignment;
    private OTPGenerator otpGenerator;
    private SlotDTOMapper slotDTOMapper;

    public List<SlotDTO> getAvailableSlots(int lockerId) {
        List<Slot> availableSlots = lockerRepository.getAvailableSlots(lockerId);
        return availableSlots.stream().map(slotDTOMapper).collect(Collectors.toList());
    }

    public void deAllocateSlot(int lockId, int slotId) {
        lockerRepository.deAllocateSlot(lockId, slotId);
    }

    public SlotDTO allocateSlot(int lockerId, LockerItem lockerItem) {
        List<Slot> availableSlots = lockerRepository.getAvailableSlots(lockerId);
        List<Slot> filteredSlots = availableSlots.stream()
                .filter(slot -> slot.getSlotSize().canAccommodate(lockerItem.getSize()))
                .collect(Collectors.toList());

        Slot slot = slotAssignment.pickSlot(filteredSlots);

        if (slot != null) {
            lockerRepository.allocateSlot(lockerId, slot, lockerItem);
            return slotDTOMapper.apply(slot);
        } else {
            throw new RuntimeException("Slot not found");
        }
    }


}
