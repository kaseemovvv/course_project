package uz.itpu.courseproject.DAO.parameter;

import uz.itpu.courseproject.model.Household;

public interface Parameter<A extends Household> {
    boolean test(A appliance);
}