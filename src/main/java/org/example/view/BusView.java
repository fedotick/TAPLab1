package org.example.view;

import org.example.controller.BusController;
import org.example.model.Bus;

import java.util.List;
import java.util.Scanner;

public class BusView {
    //TODO:можно рассмотреть использование шаблона проектирования, такого как Template Method, чтобы упростить повторяющиеся структуры в работе с BusView.
    private final Scanner scanner;
    private final BusController busController ;

    public BusView() {
        scanner = new Scanner(System.in);
        busController = new BusController();
    }

    public void run() {
        while (true) {
            System.out.print("""
                    
                    --- Bus menu ---
                    1. Show all buses
                    2. Show buses by route number
                    3. Show buses with mileage greater than specified period
                    4. Show buses that have been in operation longer than the specified distance
                    0. Main menu
                    Choose action:""");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showBuses();
                case 2 -> showBusesByRouteNumber();
                case 3 -> showBusesByOperationPeriod();
                case 4 -> showBusesWithMileageGreaterThan();
                case 0 -> {
                    return;
                }
                default -> System.out.println("\nWrong choice. Try again.");
            }
        }
    }

    private static void displayBuses(List<Bus> buses) {
        if (buses.isEmpty()) {
            System.out.println("\nNo buses found.");
        } else {
            System.out.println("\nBuses: ");
            for (Bus bus : buses) {
                System.out.println(bus);
            }
        }
    }

    private void showBuses() {
        List<Bus> buses = busController.getAll();

        displayBuses(buses);
    }

    private void showBusesByRouteNumber() {
        System.out.print("\nEnter route number: ");
        String routeNumber = scanner.nextLine();

        List<Bus> buses = busController.getAllByRouteNumber(routeNumber);

        displayBuses(buses);
    }

    private void showBusesByOperationPeriod() {
        System.out.print("\nEnter operation period: ");
        Integer operationPeriod = scanner.nextInt();
        scanner.nextLine();

        List<Bus> buses = busController.getAllByOperationPeriod(operationPeriod);

        displayBuses(buses);
    }

    private void showBusesWithMileageGreaterThan() {
        System.out.print("\nEnter mileage greater than specified distance: ");
        Float specifiedDistance = scanner.nextFloat();
        scanner.nextLine();

        List<Bus> buses = busController.getAllWithMileageGreaterThan(specifiedDistance);

        displayBuses(buses);
    }

}
