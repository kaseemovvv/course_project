package uz.itpu.courseproject.DAO;


import uz.itpu.courseproject.DAO.criteria.SearchCriteria;
import uz.itpu.courseproject.model.Household;

import java.util.Collection;

public interface HouseholdDAO<A extends Household> {
    Collection<A> find(SearchCriteria<A> criteria);

    Collection<A> findAll();
}

