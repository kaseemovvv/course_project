package uz.itpu.courseproject.DAO.parameter;

import uz.itpu.courseproject.model.Cleaning;

import java.security.InvalidParameterException;

public record ModelCleaningParameter(String model) implements Parameter<Cleaning> {
    public ModelCleaningParameter {
        if (model == null || model.isBlank()) {
            throw new InvalidParameterException("model can't be empty");
        }
    }

    @Override
    public boolean test(Cleaning appliance) {
        return model.equals(appliance.getModel());
    }
}

