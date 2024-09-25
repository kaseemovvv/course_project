package uz.itpu.courseproject.service;

import uz.itpu.courseproject.DAO.DaoFactory;
import uz.itpu.courseproject.DAO.criteria.SearchCriteria;
import uz.itpu.courseproject.model.Household;

import java.util.Collection;
import java.util.Objects;

public enum ServiceFactory {
    INSTANCE;

    public HouseHoldService getApplianceService() {
        return new HouseHoldService() {
            @Override
            public <A extends Household> Collection<A> find(SearchCriteria<A> criteria) {
                return Objects.requireNonNull(DaoFactory.INSTANCE.getApplianceDAO(criteria.getApplianceType()))
                        .find(criteria);
            }

            @Override
            public <A extends Household> Collection<A> findAll(Class<A> classType) {
                return Objects.requireNonNull(DaoFactory.INSTANCE.getApplianceDAO(classType))
                        .findAll();
            }
        };
    }

}
