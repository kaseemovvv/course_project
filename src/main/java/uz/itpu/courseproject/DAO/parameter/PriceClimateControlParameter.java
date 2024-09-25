package uz.itpu.courseproject.DAO.parameter;

import uz.itpu.courseproject.model.ClimateControl;

public record PriceClimateControlParameter(double price) implements Parameter<ClimateControl> {
    public PriceClimateControlParameter {

    }

    @Override
    public boolean test(ClimateControl appliance) {
        return price == (appliance.getPrice());
    }
}
