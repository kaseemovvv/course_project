package uz.itpu.courseproject.DAO.criteria;

import uz.itpu.courseproject.model.Cleaning;

public class CleaningCriteria extends AbstractCriteria<Cleaning> {
    @Override// ctrl+i
    public Class<Cleaning> getApplianceType() {
        return Cleaning.class;
    }
}
