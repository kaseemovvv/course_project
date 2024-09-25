package uz.itpu.courseproject.DAO.parameter;

import uz.itpu.courseproject.model.Kitchen;

import java.security.InvalidParameterException;

public record ColorKitchenParameter(String color) implements Parameter<Kitchen> {
    public ColorKitchenParameter {
        if (color == null || color.isBlank()) {
            throw new InvalidParameterException("color can't be empty");
        }
    }

    @Override
    public boolean test(Kitchen appliance) {
        return color.equals(appliance.getColor());
    }
}
