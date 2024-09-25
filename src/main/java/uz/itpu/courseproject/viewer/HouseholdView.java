package uz.itpu.courseproject.viewer;

import java.util.Collection;

public class HouseholdView {

    public static void start() {
        System.out.println("""
                    <<<<<<<<<<-------------------->>>>>>>>>>
                        Welcome!
                    Project : 
                    Owner : Kasemov Ravshanbek
                    <<<<<<<<<<-------------------->>>>>>>>>>
                """);
    }

    public static void next() {
        System.out.println("""
                    <<<<<<<<<<-------------------->>>>>>>>>>
                            Choose what you want 
                            search or select all
                            
                        1. search from parameters
                        2. search all
                    <<<<<<<<<<-------------------->>>>>>>>>>
                """);
    }


    public static void printCollection(Collection<?> collection) {
        if (collection.isEmpty()) {
            System.out.println("null");
            return;
        }
        System.out.println("    <<<<<<<<<<-------------------->>>>>>>>>>");
        for (Object o : collection) {
            System.out.println("        "+o);
        }
        System.out.println("    <<<<<<<<<<-------------------->>>>>>>>>>");
    }

    public static void cleaningSearchMenu() {
//        id,brand,color,price,model,isCordless,type

        System.out.println("""
                    <<<<<<<<<<-------------------->>>>>>>>>>
                            Cleanig Products Search
                            
                        1. brand 
                        2. model
                        3. color
                        4. price
                        5. is cord less  
                        6. exit 
                    <<<<<<<<<<-------------------->>>>>>>>>>
                """);

    }

    public static void kitchenSearchMenu() {
//        id,brand,color,price,model,capacity,isProgrammable
        System.out.println("""
                    <<<<<<<<<<-------------------->>>>>>>>>>
                            Kitchen Products Search
                            
                        1. brand 
                        2. model
                        3. color
                        4. price
                        5. capacity
                        6. is programmable  
                        7. exit 
                    <<<<<<<<<<-------------------->>>>>>>>>>
                """);

    }

    public static void climateControlSerarchMenu(){
//        id,brand,color,price,model,hasRemoteControl

        System.out.println("""
                    <<<<<<<<<<-------------------->>>>>>>>>>
                          Climate Control Products Search
                            
                        1. brand 
                        2. model
                        3. color
                        4. price
                        5. has remote control  
                        6. exit 
                    <<<<<<<<<<-------------------->>>>>>>>>>
                """);

    }

    public static void showCategories() {
        System.out.println("""
                    <<<<<<<<<<-------------------->>>>>>>>>>
                        1. Cleaning
                        2. Climate Control
                        3. Kitchen
                    <<<<<<<<<<-------------------->>>>>>>>>>
                """);
    }
}
