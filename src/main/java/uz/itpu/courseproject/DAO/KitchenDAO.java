package uz.itpu.courseproject.DAO;

import uz.itpu.courseproject.DAO.parser.KitchenParser;
import uz.itpu.courseproject.model.Kitchen;

public class KitchenDAO extends AbstractDAO<Kitchen> {
    public KitchenDAO() {
        super("src/main/resources/kitchen.csv", new KitchenParser());
    }


}