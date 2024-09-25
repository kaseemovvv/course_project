package uz.itpu.courseproject.DAO;

import uz.itpu.courseproject.DAO.parser.CleaningParser;
import uz.itpu.courseproject.model.Cleaning;

public class CleaningDAO extends AbstractDAO<Cleaning> {
    public CleaningDAO() {
        super("src/main/resources/cleaning.csv", new CleaningParser());
    }
}

