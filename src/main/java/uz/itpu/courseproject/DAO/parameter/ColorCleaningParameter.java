package uz.itpu.courseproject.DAO.parameter;

import uz.itpu.courseproject.model.Cleaning;

import java.security.InvalidParameterException;

public record ColorCleaningParameter(String color) implements Parameter<Cleaning> {
    public  ColorCleaningParameter{
        if (color == null || color.isBlank()) {
            throw new InvalidParameterException("color can't be empty");
        }
    }

    @Override
    public boolean test(Cleaning appliance) {
        return color.equals(appliance.getColor());
    }
}
