package org.example.controller;

import org.example.model.Bus;
import org.example.service.BusService;

import java.util.List;

public class BusController {

    private final BusService busService;

    public BusController() {
        this.busService = new BusService();
    }

    public List<Bus> getAll() {
        return busService.findAll();
    }

    public List<Bus> getAllByRouteNumber(String routeNumber) {
        return busService.findAllByRouteNumber(routeNumber);
    }

    public List<Bus> getAllByOperationPeriod(Integer operationPeriod) {
        return busService.findAllByOperationPeriod(operationPeriod);
    }

    public List<Bus> getAllWithMileageGreaterThan(Float specifiedDistance) {
        return busService.findAllWithMileageGreaterThan(specifiedDistance);
    }

}
