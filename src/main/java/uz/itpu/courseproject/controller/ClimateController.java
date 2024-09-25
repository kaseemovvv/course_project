package uz.itpu.courseproject.controller;

import uz.itpu.courseproject.DAO.criteria.ClimateControlCriteria;
import uz.itpu.courseproject.DAO.parameter.*;
import uz.itpu.courseproject.model.ClimateControl;
import uz.itpu.courseproject.service.ServiceFactory;
import uz.itpu.courseproject.utils.ParameterType;
import uz.itpu.courseproject.utils.UtilWriter;
import uz.itpu.courseproject.viewer.HouseholdView;

import java.util.Collection;



public class ClimateController extends ControllerFactory<ClimateControl> implements ParameterType<ClimateControl> {

    public ClimateController() {
        super(new ClimateControlCriteria());
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
    public void find() {
        boolean loop = true;
        while (loop) {
            HouseholdView.climateControlSerarchMenu();
            String input = UtilWriter.writerInt();
            switch (input) {
                case "1" -> {
                    Collection<ClimateControl> byBrand = ServiceFactory.INSTANCE.getApplianceService().find(criteria.add(brandParameter()));
                    HouseholdView.printCollection(byBrand);
                }
                case "2" -> {
                    Collection<ClimateControl> kitchens = ServiceFactory.INSTANCE.getApplianceService().find(criteria.add(modelParameter()));
                    HouseholdView.printCollection(kitchens);
                }
                case "3" -> {
                    Collection<ClimateControl> kitchens = ServiceFactory.INSTANCE.getApplianceService().find(criteria.add(colorParameter()));
                    HouseholdView.printCollection(kitchens);
                }
                case "4" -> {
                    Collection<ClimateControl> kitchens = ServiceFactory.INSTANCE.getApplianceService().find(criteria.add(priceParameter()));
                    HouseholdView.printCollection(kitchens);
                }
                case "5" -> {
                    Collection<ClimateControl> climateControls = ServiceFactory.INSTANCE.getApplianceService().find(criteria.add(hasRemoteControlParameter()));
                    HouseholdView.printCollection(climateControls);
                }
                case "6" -> {
                    start();
                }
                default -> {
                    System.out.println("wrong input");
                }
            }

        }

    }

    private Parameter<ClimateControl> hasRemoteControlParameter() {
        boolean remoteControl = UtilWriter.writerBoolean("  Enter Remote Controller (true or false)");
        return new RemoteControlParameter(remoteControl);
    }

    @Override
    public void findAll() {
        Collection<ClimateControl> all = ServiceFactory.INSTANCE.getApplianceService().findAll(criteria.getApplianceType());
        HouseholdView.printCollection(all);

    }

    @Override
    public Parameter<ClimateControl> brandParameter() {
        String brand = UtilWriter.writerText("  Enter Brand ");
        return new BrandClimateControlParameter(brand);
    }

    @Override
    public Parameter<ClimateControl> colorParameter() {
        String brand = UtilWriter.writerText("  Enter Color ");
        return new ColorClimateControlParameter(brand);
    }

    @Override
    public Parameter<ClimateControl> modelParameter() {
        String brand = UtilWriter.writerText("  Enter Model ");
        return new ModelClimateControlParameter(brand);
    }

    @Override
    public Parameter<ClimateControl> priceParameter() {
        double price = UtilWriter.writerDouble("    Enter Price ");
        return new PriceClimateControlParameter(price);
    }

}
