package org.example.view;

import org.example.config.DataInitializer;

import java.util.Scanner;

public class MainView {

    private static final BusView busView = new BusView();

    public static void run() { //TODO: метод run() обрабатывает как основной интерфейс, так и инициализацию данных. Лучше было бы разделить этот функционал: инициализация данных должна быть вынесена в отдельный класс или метод.
        new DataInitializer().initialize();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("""
                    
                    --- Main menu ---
                    1. Bus controller
                    0. Exit
                    Choose action:""");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> busView.run();
                case 0 -> {
                    System.out.println("\nEnd of the program.");
                    return;
                }
                default -> System.out.println("\nWrong choice. Try again.");
            }
        }
    }

}
