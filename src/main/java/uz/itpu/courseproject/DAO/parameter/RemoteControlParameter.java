package uz.itpu.courseproject.DAO.parameter;

import uz.itpu.courseproject.model.ClimateControl;

public record RemoteControlParameter(boolean hasRemoteControl) implements Parameter<ClimateControl> {
    public RemoteControlParameter {

    }

    @Override
    public boolean test(ClimateControl appliance) {
        return hasRemoteControl == (appliance.isHasRemoteControl());
    }
}
