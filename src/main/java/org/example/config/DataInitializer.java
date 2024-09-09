package org.example.config;

import org.example.model.Bus;
import org.example.service.BusService;

import java.util.List;

public class DataInitializer {

    private static final BusService busService = new BusService();

    public static void initialize() {
        List<Bus> newBuses = getSampleBusData();

        busService.createBuses(newBuses);
    }

    private static List<Bus> getSampleBusData() {
        return List.of(
                new Bus.Builder("Brand 1", 2005)
                        .setDriverName("Name 1")
                        .setBusNumber("Number 1")
                        .setRouteNumber("Route 1")
                        .setMileage(110000F)
                        .build(),
                new Bus.Builder("Brand 2", 2004)
                        .setDriverName("Name 2")
                        .setBusNumber("Number 2")
                        .setRouteNumber("Route 2")
                        .setMileage(120000F)
                        .build(),
                new Bus.Builder("Brand 2", 2003)
                        .setDriverName("Name 3")
                        .setBusNumber("Number 3")
                        .setRouteNumber("Route 3")
                        .setMileage(140000F)
                        .build(),
                new Bus.Builder("Brand 3", 2002)
                        .setDriverName("Name 4")
                        .setBusNumber("Number 4")
                        .setRouteNumber("Route 3")
                        .setMileage(150000F)
                        .build(),
                new Bus.Builder("Brand 3", 2001)
                        .setDriverName("Name 5")
                        .setBusNumber("Number 5")
                        .setRouteNumber("Route 5")
                        .setMileage(160000F)
                        .build()
        );
    }

}
