package org.example.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Bus implements Cloneable, Comparable<Bus>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    //TODO:Можно рассмотреть возможность вынесения строковых литералов, используемых в логике программы, в final static переменные для облегчения изменения и локализации.
    private static final String TO_STRING_DRIVER_NAME = "driverName=";
    private static final String TO_STRING_BUS_NUMBER = "busNumber=";
    private static final String TO_STRING_ROUTE_NUMBER = "routeNumber=";
    private static final String TO_STRING_BRAND = "brand=";
    private static final String TO_STRING_YEAR_OF_START_OF_OPERATION = "yearOfStartOfOperation=";
    private static final String TO_STRING_MILEAGE = "mileage=";
    private static final String TO_STRING_SUFFIX = "}";

    //TODO:Возможно, следует рассмотреть использование неизменяемых объектов (final) для полей класса, которые не должны изменяться после инициализации.
    private String driverName;
    private String busNumber;
    private String routeNumber;
    private final String brand;
    private final Integer yearOfStartOfOperation;
    private Float mileage;

    //TODO:В конструкторе класса Bus передаётся множество параметров. Возможно, стоит рассмотреть паттерн проектирования "Builder" для создания объектов Bus и улучшения читаемости кода.
    private Bus(Builder builder) {
        this.driverName = builder.driverName;
        this.busNumber = builder.busNumber;
        this.routeNumber = builder.routeNumber;
        this.brand = builder.brand;
        this.yearOfStartOfOperation = builder.yearOfStartOfOperation;
        this.mileage = builder.mileage;
    }

    public static class Builder {
        private String driverName;
        private String busNumber;
        private String routeNumber;
        private final String brand;
        private final Integer yearOfStartOfOperation;
        private Float mileage;

        public Builder(String brand, Integer yearOfStartOfOperation) {
            this.brand = brand;
            this.yearOfStartOfOperation = yearOfStartOfOperation;
        }

        public Builder setDriverName(String driverName) {
            this.driverName = driverName;
            return this;
        }

        public Builder setBusNumber(String busNumber) {
            this.busNumber = busNumber;
            return this;
        }

        public Builder setRouteNumber(String routeNumber) {
            this.routeNumber = routeNumber;
            return this;
        }

        public Builder setMileage(Float mileage) {
            this.mileage = mileage;
            return this;
        }

        public Bus build() {
            return new Bus(this);
        }
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getYearOfStartOfOperation() {
        return yearOfStartOfOperation;
    }

    public Float getMileage() {
        return mileage;
    }

    public void setMileage(Float mileage) {
        this.mileage = mileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return Objects.equals(driverName, bus.driverName) && Objects.equals(busNumber, bus.busNumber) && Objects.equals(routeNumber, bus.routeNumber) && Objects.equals(brand, bus.brand) && Objects.equals(yearOfStartOfOperation, bus.yearOfStartOfOperation) && Objects.equals(mileage, bus.mileage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverName, busNumber, routeNumber, brand, yearOfStartOfOperation, mileage);
    }

    @Override
    public Bus clone() {
        try {
            return (Bus) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Bus{" +
                TO_STRING_DRIVER_NAME + '\'' + driverName + '\'' +
                ", " + TO_STRING_BUS_NUMBER + '\'' + busNumber + '\'' +
                ", " + TO_STRING_ROUTE_NUMBER + '\'' + routeNumber + '\'' +
                ", " + TO_STRING_BRAND + '\'' + brand + '\'' +
                ", " + TO_STRING_YEAR_OF_START_OF_OPERATION + yearOfStartOfOperation +
                ", " + TO_STRING_MILEAGE + mileage +
                TO_STRING_SUFFIX;
    }

    @Override
    public int compareTo(Bus other) {
        return Integer.compare(this.yearOfStartOfOperation, other.yearOfStartOfOperation);
    }

}
