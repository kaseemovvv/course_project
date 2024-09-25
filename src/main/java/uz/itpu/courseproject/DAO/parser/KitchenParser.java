package uz.itpu.courseproject.DAO.parser;

import uz.itpu.courseproject.model.Kitchen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class KitchenParser implements CsvLineParser<Kitchen> {
    @Override
    public List<Kitchen> getData(String path) {
        List<Kitchen> objs = new ArrayList<>();
        try (FileReader reader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.split(",");
                String brand = split[0];
                String color = split[1];
                int price = Integer.parseInt(split[2]);
                String model = split[3];
                String capacity = split[4];
                boolean isProgrammable = Boolean.parseBoolean(split[5]);
                Kitchen kitchen = new Kitchen(brand, color, price, model, capacity,isProgrammable);
                objs.add(kitchen);
                line = bufferedReader.readLine();
            }
            return objs;
        } catch (IOException e) {
            throw new InvalidParameterException(e.getMessage());
        }
    }
}
