package uz.itpu.courseproject.model;

import java.util.Objects;

public abstract class Household {
    private String brand;
    private String color;
    private double price;
    private String model;

    public Household(String brand, String color, double price, String model) {
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.model = model;
    }

    public Household() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Household household)) return false;
        return Double.compare(price, household.price) == 0 && Objects.equals(brand, household.brand) && Objects.equals(color, household.color) && Objects.equals(model, household.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color, price, model);
    }

    @Override
    public String toString() {
        return "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", model='" + model + '\'' + ", ";
    }
}
