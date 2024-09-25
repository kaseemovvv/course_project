package uz.itpu.courseproject.controller;

import uz.itpu.courseproject.DAO.criteria.CleaningCriteria;
import uz.itpu.courseproject.DAO.parameter.*;
import uz.itpu.courseproject.model.Cleaning;
import uz.itpu.courseproject.service.ServiceFactory;
import uz.itpu.courseproject.utils.ParameterType;
import uz.itpu.courseproject.utils.UtilWriter;
import uz.itpu.courseproject.viewer.HouseholdView;

import java.util.ArrayList;
import java.util.Collection;



public class CleaningController extends ControllerFactory<Cleaning> implements ParameterType<Cleaning> {
    public CleaningController() {
        super(new CleaningCriteria());
    }

    public void start() {
        HouseholdView.next();
        System.out.print(" >> ");
        String search = UtilWriter.writerInt();
        if (search.equals("1")) {
             find();
        } else if (search.equals("2")) {
            findAll();
        } else {
            throw new IllegalStateException("Unexpected value: " + search);
        }

    }

    @Override
    public void find() {;
        Collection<Cleaning> cleanings = new ArrayList<>();
        boolean loop = true;
        while (loop) {
            HouseholdView.cleaningSearchMenu();
            System.out.print(" >> ");
            String input = UtilWriter.writerInt();
            switch (input) {
                case "1" -> {
                    Collection<Cleaning> byBrand = ServiceFactory.INSTANCE.getApplianceService().find(criteria.add(brandParameter()));
                    HouseholdView.printCollection(byBrand);
                }
                case "2" -> {
                    Collection<Cleaning> kitchens = ServiceFactory.INSTANCE.getApplianceService().find(criteria.add(modelParameter()));
                    HouseholdView.printCollection(kitchens);
                }
                case "3" -> {
                    Collection<Cleaning> kitchens = ServiceFactory.INSTANCE.getApplianceService().find(criteria.add(colorParameter()));
                    HouseholdView.printCollection(kitchens);
                }
                case "4" -> {
                    Collection<Cleaning> kitchens = ServiceFactory.INSTANCE.getApplianceService().find(criteria.add(priceParameter()));
                    HouseholdView.printCollection(kitchens);
                }
                case "5" -> {
                    Collection<Cleaning> cleanings1 = ServiceFactory.INSTANCE.getApplianceService().find(criteria.add(isCordlessParameter()));
                    HouseholdView.printCollection(cleanings1);
                }
                case "6" ->  {
                    start();
                }
                default -> {
                    System.out.println("wrong input");
                }
            }
        }
    }


    @Override
    public void findAll() {
        Collection<Cleaning> all = ServiceFactory.INSTANCE.getApplianceService().findAll(criteria.getApplianceType());
        HouseholdView.printCollection(all);
    }

    @Override
    public Parameter<Cleaning> brandParameter() {
        String brand = UtilWriter.writerText("  Enter Brand ");
        return new BrandCleaningParameter(brand);
    }

    @Override
    public Parameter<Cleaning> colorParameter() {
        String brand = UtilWriter.writerText("  Enter color ");
        return new ColorCleaningParameter(brand);
    }

    @Override
    public Parameter<Cleaning> modelParameter() {
        String brand = UtilWriter.writerText("  Enter model ");
        return new ModelCleaningParameter(brand);
    }

    @Override
    public Parameter<Cleaning> priceParameter() {
        double price = UtilWriter.writerDouble("  Enter Price ");
        return new PriceCleaningParameter(price);
    }

    public Parameter<Cleaning> isCordlessParameter() {
        boolean isCordless = UtilWriter.writerBoolean("  Enter Is Cord Less ");
        return new CordlessParameter(isCordless);
    }
}
