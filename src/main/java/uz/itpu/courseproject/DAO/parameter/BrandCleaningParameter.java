package uz.itpu.courseproject.DAO.parameter;


import uz.itpu.courseproject.model.Cleaning;

import java.security.InvalidParameterException;

public record BrandCleaningParameter(String brand) implements Parameter<Cleaning> {
    public  BrandCleaningParameter{
        if (brand == null || brand.isBlank()) {
            throw new InvalidParameterException("brand can't be empty");
        }
    }

    @Override
    public boolean test(Cleaning appliance) {
        return brand.equals(appliance.getBrand());
    }
}
