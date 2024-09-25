package uz.itpu.courseproject.model;

import java.util.Objects;

public class Cleaning extends Household {
    private boolean isCordless;

    public Cleaning(String brand, String color, double price, String model, boolean isCordless) {
        super(brand, color, price, model);
        this.isCordless = isCordless;
    }


    public boolean isCordless() {
        return isCordless;
    }

    public void setCordless(boolean cordless) {
        isCordless = cordless;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cleaning cleaning)) return false;
        if (!super.equals(o)) return false;
        return isCordless == cleaning.isCordless;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isCordless);
    }

    @Override
    public String toString() {
        return "Cleaning{" +
                super.toString()+
                ", isCordless=" + isCordless +
                '}';
    }
}

