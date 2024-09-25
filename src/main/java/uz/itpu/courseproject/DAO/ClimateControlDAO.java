package uz.itpu.courseproject.DAO;

import uz.itpu.courseproject.DAO.parser.ClimateControlParser;
import uz.itpu.courseproject.model.ClimateControl;

public class ClimateControlDAO extends AbstractDAO<ClimateControl> {
    public ClimateControlDAO() {
        super("src/main/resources/climate_control.csv", new ClimateControlParser());
    }
}
