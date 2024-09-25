package uz.itpu.courseproject.DAO.criteria;

import uz.itpu.courseproject.model.ClimateControl;

public class ClimateControlCriteria extends AbstractCriteria<ClimateControl> {
    @Override// ctrl+i
    public Class<ClimateControl> getApplianceType() {
        return ClimateControl.class;
    }
}
