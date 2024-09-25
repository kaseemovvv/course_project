package uz.itpu.courseproject.DAO.parameter;


import uz.itpu.courseproject.model.Kitchen;

import java.security.InvalidParameterException;

public record BrandKitchenParameter(String brand) implements Parameter<Kitchen> {
    public BrandKitchenParameter {
        if (brand == null || brand.isBlank()) {
            throw new InvalidParameterException("brand can't be empty");
        }
    }

    @Override
    public boolean test(Kitchen appliance) {
        return brand.equals(appliance.getBrand());
    }
}
