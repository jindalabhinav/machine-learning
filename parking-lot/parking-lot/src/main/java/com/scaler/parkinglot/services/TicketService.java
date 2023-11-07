package com.scaler.parkinglot.services;

import com.scaler.parkinglot.dtos.CreateTicketRequest;
import com.scaler.parkinglot.exceptions.SlotLotAvailableException;
import com.scaler.parkinglot.models.ParkingSpot;
import com.scaler.parkinglot.models.SpotStatus;
import com.scaler.parkinglot.models.Ticket;
import com.scaler.parkinglot.models.Vehicle;
import com.scaler.parkinglot.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class TicketService {
    private TicketRepository ticketRepository;
    private ParkingSpotService parkingSpotService;
    private VehicleService vehicleService;

    public Ticket createTicket(CreateTicketRequest createTicketRequest) {
        // Check if the spot is available
        // Allocate a spot
        // If null, throw an exception
        ParkingSpot parkingSpot = parkingSpotService.allocateSpot(createTicketRequest.getParkingLotId(), createTicketRequest.getVehicleType());
        if (parkingSpot == null)
            throw new SlotLotAvailableException(createTicketRequest.getVehicleType());

        // Update the spot -> FILLED
        parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);

        // Save it in the database
        ParkingSpot updatedSpot = parkingSpotService.update(parkingSpot);

        // Fetch or create
        // If vehicle number and type present, use that
        // Else create a new one
        Vehicle vehicle = vehicleService.findOrCreate(createTicketRequest.getVehicleNumber(), createTicketRequest.getVehicleType());

        // Create a ticket and save it
        Ticket ticket = Ticket.builder()
                .entryTime(LocalDateTime.now())
                .parkingSpot(updatedSpot)
                .vehicle(vehicle)
                .entryGateId(createTicketRequest.getEntryGateId())
                .build();
        return ticketRepository.save(ticket);
    }
}
