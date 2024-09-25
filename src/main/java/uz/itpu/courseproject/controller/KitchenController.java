package uz.itpu.courseproject.controller;

import uz.itpu.courseproject.DAO.criteria.KitchenCriteria;
import uz.itpu.courseproject.DAO.parameter.*;
import uz.itpu.courseproject.model.Kitchen;
import uz.itpu.courseproject.service.ServiceFactory;
import uz.itpu.courseproject.utils.ParameterType;
import uz.itpu.courseproject.utils.UtilWriter;
import uz.itpu.courseproject.viewer.HouseholdView;

import java.util.Collection;

public class KitchenController extends ControllerFactory<Kitchen> implements ParameterType<Kitchen> {
    public KitchenController() {
        super(new KitchenCriteria());
    }

    public void start() {
        HouseholdView.next();
        System.out.print(" >> ");
        String search = UtilWriter.writerInt();
        if (search.equals("1")|| search.equalsIgnoreCase("search")) {
             find();
        } else if (search.equals("2") || search.equalsIgnoreCase("find")) {
             findAll();
        } else {
            throw new IllegalStateException("Unexpected value: " + search);
        }
    }

    @Override
    public void find() {
        boolean loop = true;
        while (loop) {
            HouseholdView.kitchenSearchMenu();
            System.out.print(" >> ");
            String input = UtilWriter.writerInt();
            switch (input) {
                case "1" -> {
                    Collection<Kitchen> brand = ServiceFactory.INSTANCE.getApplianceService().find(criteria.add(brandParameter()));
                    HouseholdView.printCollection(brand);
                }
                case "2" -> {
                    Collection<Kitchen> kitchens = ServiceFactory.INSTANCE.getApplianceService().find(criteria.add(modelParameter()));
                    HouseholdView.printCollection(kitchens);
                }
                case "3" -> {
                    Collection<Kitchen> kitchens = ServiceFactory.INSTANCE.getApplianceService().find(criteria.add(colorParameter()));
                    HouseholdView.printCollection(kitchens);
                }
                case "4" -> {
                    Collection<Kitchen> kitchens = ServiceFactory.INSTANCE.getApplianceService().find(criteria.add(priceParameter()));
                    HouseholdView.printCollection(kitchens);
                }
                case "5" -> {
                    Collection<Kitchen> kitchens = ServiceFactory.INSTANCE.getApplianceService().find(criteria.add(capacityParameter()));
                    HouseholdView.printCollection(kitchens);
                }
                case "6" -> {
                    Collection<Kitchen> kitchens = ServiceFactory.INSTANCE.getApplianceService().find(criteria.add(programmableParameter()));
                    HouseholdView.printCollection(kitchens);
                }
                case "7" -> {
                    start();
                }
                default -> System.out.println("wrong input");
            }

        }
    }

    @Override
    public void findAll() {
        Collection<Kitchen> all = ServiceFactory.INSTANCE.getApplianceService().findAll(criteria.getApplianceType());
        HouseholdView.printCollection(all);
    }

    public Parameter<Kitchen> capacityParameter() {
        String capacity = UtilWriter.writerText("   Enter capacity ");
        return new CapacityParameter(capacity);
    }

    public Parameter<Kitchen> programmableParameter() {
        boolean program = UtilWriter.writerBoolean("    Enter programmable (true or false ) ");
        return new ProgrammableParameter(program);
    }

    @Override
    public Parameter<Kitchen> brandParameter() {
        String brand = UtilWriter.writerText("  Enter Brand ");
        return new BrandKitchenParameter(brand);
    }

    @Override
    public Parameter<Kitchen> colorParameter() {
        String brand = UtilWriter.writerText("  Enter Color ");
        return new ColorKitchenParameter(brand);
    }

    @Override
    public Parameter<Kitchen> modelParameter() {
        String brand = UtilWriter.writerText("  Enter Model ");
        return new ModelKitchenParameter(brand);
    }

    @Override
    public Parameter<Kitchen> priceParameter() {
        double price = UtilWriter.writerDouble("    Enter Price ");
        return new PriceKitchenParameter(price);
    }
}
