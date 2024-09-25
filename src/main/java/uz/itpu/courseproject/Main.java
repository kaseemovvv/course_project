package uz.itpu.courseproject;

import uz.itpu.courseproject.controller.CleaningController;
import uz.itpu.courseproject.controller.ClimateController;
import uz.itpu.courseproject.controller.ControllerFactory;
import uz.itpu.courseproject.controller.KitchenController;
import uz.itpu.courseproject.model.Household;
import uz.itpu.courseproject.utils.UtilWriter;
import uz.itpu.courseproject.viewer.HouseholdView;

public class Main {
    public static void main(String[] args) {
        HouseholdView.start();
        while (true){
            HouseholdView.showCategories();
            System.out.print("  >> ");
            String choice = String.valueOf(UtilWriter.writerInt());
            switch (choice.toLowerCase()) {
                case "1" :
                    displayController(new CleaningController());
                    break;
                case "2":
                    displayController(new ClimateController());
                    break;
                case "3":
                    displayController(new KitchenController());
                    break;
                default:
                    System.out.println("Wrong choice!");
            }
        }

    }

    private static <A extends Household> void displayController(ControllerFactory<A> controller) {
       controller.start();
    }
}
