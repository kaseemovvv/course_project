package uz.itpu.courseproject.DAO.parameter;

import uz.itpu.courseproject.model.ClimateControl;

import java.security.InvalidParameterException;

public record ColorClimateControlParameter(String color) implements Parameter<ClimateControl> {
    public  ColorClimateControlParameter{
        if (color == null || color.isBlank()) {
            throw new InvalidParameterException("color can't be empty");
        }
    }

    @Override
    public boolean test(ClimateControl appliance) {
        return color.equals(appliance.getColor());
    }
}