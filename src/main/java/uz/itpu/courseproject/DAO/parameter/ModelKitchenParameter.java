package uz.itpu.courseproject.DAO.parameter;

import uz.itpu.courseproject.model.Kitchen;

import java.security.InvalidParameterException;

public record ModelKitchenParameter(String model) implements Parameter<Kitchen> {
    public ModelKitchenParameter {
        if (model == null || model.isBlank()) {
            throw new InvalidParameterException("model can't be empty");
        }
    }

    @Override
    public boolean test(Kitchen appliance) {
        return model.equals(appliance.getModel());
    }
}
