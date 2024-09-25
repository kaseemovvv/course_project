package uz.itpu.courseproject.DAO.parameter;

import uz.itpu.courseproject.model.ClimateControl;

import java.security.InvalidParameterException;

public record ModelClimateControlParameter(String model) implements Parameter<ClimateControl> {
    public ModelClimateControlParameter {
        if (model == null || model.isBlank()) {
            throw new InvalidParameterException("model can't be empty");
        }
    }

    @Override
    public boolean test(ClimateControl appliance) {
        return model.equals(appliance.getModel());
    }
}
