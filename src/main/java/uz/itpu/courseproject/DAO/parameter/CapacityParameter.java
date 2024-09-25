package uz.itpu.courseproject.DAO.parameter;

import uz.itpu.courseproject.model.Kitchen;

import java.security.InvalidParameterException;

public record CapacityParameter(String capacity) implements Parameter<Kitchen> {
    public CapacityParameter {
        if (capacity == null || capacity.isBlank()) {
            throw new InvalidParameterException("brand can't be empty");
        }
    }

    @Override
    public boolean test(Kitchen appliance) {
        return capacity.equals(appliance.getCapacity());
    }
}