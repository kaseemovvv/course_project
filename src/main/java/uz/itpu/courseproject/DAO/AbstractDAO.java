package uz.itpu.courseproject.DAO;


import uz.itpu.courseproject.DAO.criteria.SearchCriteria;
import uz.itpu.courseproject.DAO.parser.CsvLineParser;
import uz.itpu.courseproject.model.Household;

import java.util.Collection;

public abstract class AbstractDAO<A extends Household> implements HouseholdDAO<A> {
    private final String csvPath;
    private final CsvLineParser<A> parser;

    @Override
    public Collection<A> findAll() {
        return parser.getData(csvPath);
    }

    protected AbstractDAO(String csvPath, CsvLineParser<A> parser) {
        this.csvPath = csvPath;
        this.parser = parser;
    }

    @Override
    public Collection<A> find(SearchCriteria<A> criteria) {
        return parser.getData(csvPath).stream().filter(criteria::test).toList();
    }
}

