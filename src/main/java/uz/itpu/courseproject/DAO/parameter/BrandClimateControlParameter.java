package uz.itpu.courseproject.DAO.parameter;

import uz.itpu.courseproject.model.ClimateControl;

import java.security.InvalidParameterException;

public record BrandClimateControlParameter(String brand) implements Parameter<ClimateControl> {
    public  BrandClimateControlParameter{
        if (brand == null || brand.isBlank()) {
            throw new InvalidParameterException("brand can't be empty");
        }
    }

    @Override
    public boolean test(ClimateControl appliance) {
        return brand.equals(appliance.getBrand());
    }
}
