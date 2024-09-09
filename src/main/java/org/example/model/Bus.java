package org.example.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Bus implements Cloneable, Comparable<Bus>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    //TODO:Можно рассмотреть возможность вынесения строковых литералов, используемых в логике программы, в final static переменные для облегчения изменения и локализации.
    //TODO:Возможно, следует рассмотреть использование неизменяемых объектов (final) для полей класса, которые не должны изменяться после инициализации.
    private String name;
    private String busNumber;
    private String routeNumber;
    private String brand;
    private Integer yearOfStartOfOperation;
    private Float mileage;

    //TODO:В конструкторе класса Bus передаётся множество параметров. Возможно, стоит рассмотреть паттерн проектирования "Builder" для создания объектов Bus и улучшения читаемости кода.
    public Bus(String name, String busNumber, String routeNumber, String brand, int yearOfStartOfOperation, float mileage) {
        this.name = name;
        this.busNumber = busNumber;
        this.routeNumber = routeNumber;
        this.brand = brand;
        this.yearOfStartOfOperation = yearOfStartOfOperation;
        this.mileage = mileage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYearOfStartOfOperation() {
        return yearOfStartOfOperation;
    }

    public void setYearOfStartOfOperation(Integer yearOfStartOfOperation) {
        this.yearOfStartOfOperation = yearOfStartOfOperation;
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
        return Objects.equals(name, bus.name) && Objects.equals(busNumber, bus.busNumber) && Objects.equals(routeNumber, bus.routeNumber) && Objects.equals(brand, bus.brand) && Objects.equals(yearOfStartOfOperation, bus.yearOfStartOfOperation) && Objects.equals(mileage, bus.mileage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, busNumber, routeNumber, brand, yearOfStartOfOperation, mileage);
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
                "name='" + name + '\'' +
                ", busNumber='" + busNumber + '\'' +
                ", routeNumber='" + routeNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", yearOfStartOfOperation=" + yearOfStartOfOperation +
                ", mileage=" + mileage +
                '}';
    }

    @Override
    public int compareTo(Bus other) {
        return Integer.compare(this.yearOfStartOfOperation, other.yearOfStartOfOperation);
    }

}
