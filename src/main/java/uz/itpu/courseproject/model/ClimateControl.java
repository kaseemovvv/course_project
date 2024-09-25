package uz.itpu.courseproject.model;

import java.util.Objects;

public class ClimateControl extends Household {
    private boolean hasRemoteControl;

    public ClimateControl(String brand, String color, double price, String model, boolean hasRemoteControl) {
        super(brand, color, price, model);
        this.hasRemoteControl = hasRemoteControl;
    }

    public boolean isHasRemoteControl() {
        return hasRemoteControl;
    }

    public void setHasRemoteControl(boolean hasRemoteControl) {
        this.hasRemoteControl = hasRemoteControl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClimateControl that)) return false;
        if (!super.equals(o)) return false;
        return hasRemoteControl == that.hasRemoteControl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hasRemoteControl);
    }

    @Override
    public String toString() {
        return "ClimateControl{" +
                super.toString()+
                "hasRemoteControl=" + hasRemoteControl +
                '}';
    }
}
