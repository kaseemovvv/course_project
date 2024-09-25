package uz.itpu.courseproject.utils;

import uz.itpu.courseproject.DAO.parameter.Parameter;
import uz.itpu.courseproject.model.Household;


public interface ParameterType<A extends Household> {
    Parameter<A> brandParameter();

    Parameter<A> colorParameter();

    Parameter<A> modelParameter();

    Parameter<A> priceParameter();

}
