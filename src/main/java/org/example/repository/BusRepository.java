package org.example.repository;

import org.example.model.Bus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BusRepository {

    private static BusRepository instance;

    private final List<Bus> buses;

    private BusRepository() {
        buses = new ArrayList<>();
    }

    public static BusRepository getInstance() {
        if (instance == null) {
            instance = new BusRepository();
        }
        return instance;
    }

    public void createBuses(List<Bus> newBuses) {
        buses.addAll(newBuses);
    }

    public List<Bus> findAll() {
        return buses;
    }

    public List<Bus> findAllByRouteNumber(String routeNumber) {
        return buses.stream()
                .filter(bus -> bus.getRouteNumber().equals(routeNumber))
                .toList();
    }

    public List<Bus> findAllByOperationPeriod(Integer operationPeriod) {
        int currentYear = LocalDate.now().getYear();

        return buses.stream()
                .filter(bus -> operationPeriod < currentYear - bus.getYearOfStartOfOperation())
                .toList();
    }

    public List<Bus> findAllWithMileageGreaterThan(Float specifiedDistance) {
        return buses.stream()
                .filter(bus -> specifiedDistance < bus.getMileage())
                .toList();
    }

}
