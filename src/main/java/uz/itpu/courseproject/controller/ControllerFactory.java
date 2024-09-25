package uz.itpu.courseproject.controller;

import uz.itpu.courseproject.DAO.criteria.SearchCriteria;
import uz.itpu.courseproject.model.Household;
public abstract class ControllerFactory<A extends Household> {
    protected SearchCriteria<A> criteria;

    public ControllerFactory(SearchCriteria<A> criteria) {
        this.criteria = criteria;
    }

    abstract void find();

    abstract void findAll();


    public abstract void start();
}
