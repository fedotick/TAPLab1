package org.example.config;

import org.example.model.Bus;
import org.example.service.BusService;

import java.util.List;

public class DataInitializer {

    private final BusService busService;

    public DataInitializer() {
        busService = BusService.getInstance();

    }

    public void initialize() {
        List<Bus> newBuses = getSampleBusData();

        busService.createBuses(newBuses);
    }

    private static List<Bus> getSampleBusData() {
        return List.of(
                new Bus("Name 1", "Number 1", "Route 1", "Brand 1", 2005, 110000F),
                new Bus("Name 2", "Number 2", "Route 2", "Brand 2", 2004, 120000F),
                new Bus("Name 3", "Number 3", "Route 3", "Brand 2", 2003, 140000F),
                new Bus("Name 4", "Number 4", "Route 3", "Brand 3", 2002, 150000F),
                new Bus("Name 5", "Number 5", "Route 5", "Brand 3", 2001, 160000F)
        );
    }

}
