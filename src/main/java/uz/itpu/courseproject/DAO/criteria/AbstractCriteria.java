package uz.itpu.courseproject.DAO.criteria;

import uz.itpu.courseproject.DAO.parameter.Parameter;
import uz.itpu.courseproject.model.Household;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCriteria<A extends Household>
        implements SearchCriteria<A> {

    protected final Map<Class<?>, Parameter<A>> parameters = new HashMap<>();

    @Override
    public <F extends Parameter<A>> SearchCriteria<A> add(F parameter) {
        parameters.put(parameter.getClass(), parameter);
        return this;
    }


    @Override
    public boolean test(A appliance) {
        return parameters.values().stream().allMatch(i -> i.test(appliance));
    }
}
