package uz.itpu.courseproject.DAO.parameter;

import uz.itpu.courseproject.model.Cleaning;

public record PriceCleaningParameter(double price) implements Parameter<Cleaning> {
    public PriceCleaningParameter {

    }

    @Override
    public boolean test(Cleaning appliance) {
        return price == (appliance.getPrice());
    }
}
