package uz.itpu.courseproject.service;

import uz.itpu.courseproject.DAO.criteria.SearchCriteria;
import uz.itpu.courseproject.model.Household;

import java.util.Collection;

public interface HouseHoldService {
    <A extends Household> Collection<A> find(SearchCriteria<A> criteria);

    <A extends Household> Collection<A> findAll(Class<A> classType);
}
