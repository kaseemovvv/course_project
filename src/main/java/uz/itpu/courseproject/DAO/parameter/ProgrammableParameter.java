package uz.itpu.courseproject.DAO.parameter;

import uz.itpu.courseproject.model.Kitchen;

public record ProgrammableParameter(boolean isProgrammable) implements Parameter<Kitchen> {
    public  ProgrammableParameter{

    }

    @Override
    public boolean test(Kitchen appliance) {
        return isProgrammable == (appliance.isProgrammable());
    }
}
