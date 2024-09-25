package uz.itpu.courseproject.DAO.criteria;

import uz.itpu.courseproject.DAO.parameter.Parameter;
import uz.itpu.courseproject.model.Household;

public interface SearchCriteria<A extends Household> {
    Class<A> getApplianceType();
    <P extends Parameter<A>> SearchCriteria<A> add(P parameter);
    boolean test(A appliance);
}
