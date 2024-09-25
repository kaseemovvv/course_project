package uz.itpu.courseproject.DAO.parser;

import uz.itpu.courseproject.model.Household;

import java.util.List;

public interface CsvLineParser<A extends Household> {
    List<A> getData(String path);
}
