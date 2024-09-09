package org.example.service;

import org.example.model.Bus;
import org.example.repository.BusRepository;

import java.util.List;

public class BusService {

    private final BusRepository busRepository;

    public BusService() {
        busRepository = BusRepository.getInstance();
    }

    public void createBuses(List<Bus> newBuses) {
        busRepository.createBuses(newBuses);
    }

    public List<Bus> findAll() {
        return busRepository.findAll();
    }

    public List<Bus> findAllByRouteNumber(String routeNumber) {
        return busRepository.findAllByRouteNumber(routeNumber);
    }

    public List<Bus> findAllByOperationPeriod(Integer operationPeriod) {
        return busRepository.findAllByOperationPeriod(operationPeriod);
    }

    public List<Bus> findAllWithMileageGreaterThan(Float specifiedDistance) {
        return busRepository.findAllWithMileageGreaterThan(specifiedDistance);
    }

}
