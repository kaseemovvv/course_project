package uz.itpu.courseproject.DAO.parameter;

import uz.itpu.courseproject.model.Cleaning;

public record CordlessParameter(boolean isCordless) implements Parameter<Cleaning> {
    public  CordlessParameter{

    }

    @Override
    public boolean test(Cleaning appliance) {
        return isCordless==(appliance.isCordless());
    }
}
