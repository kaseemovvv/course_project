package uz.itpu.courseproject.DAO.criteria;

import uz.itpu.courseproject.model.Kitchen;

public class KitchenCriteria extends AbstractCriteria<Kitchen> {
    @Override// ctrl+i
    public Class<Kitchen> getApplianceType() {
        return Kitchen.class;
    }
}
