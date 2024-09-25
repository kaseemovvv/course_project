package uz.itpu.courseproject.DAO.parameter;

import uz.itpu.courseproject.model.Kitchen;

public record PriceKitchenParameter(double price) implements Parameter<Kitchen> {
    public PriceKitchenParameter {

    }

    @Override
    public boolean test(Kitchen appliance) {
        return price == (appliance.getPrice());
    }
}
