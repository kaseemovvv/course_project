package uz.itpu.courseproject.model;

import java.util.Objects;

public class Kitchen extends Household{
    private String capacity;
    private boolean isProgrammable;

    public Kitchen(String brand, String color, double price, String model, String capacity,boolean isProgrammable) {
        super(brand, color, price, model);
        this.capacity = capacity;
        this.isProgrammable = isProgrammable;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public boolean isProgrammable() {
        return isProgrammable;
    }

    public void setProgrammable(boolean programmable) {
        isProgrammable = programmable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kitchen kitchen)) return false;
        if (!super.equals(o)) return false;
        return capacity == kitchen.capacity && isProgrammable == kitchen.isProgrammable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity, isProgrammable);
    }

    @Override
    public String toString() {
        return "Kitchen{" +
                super.toString()+
                "capacity=" + capacity +
                ", isProgrammable=" + isProgrammable +
                '}';
    }
}
