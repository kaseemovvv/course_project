package uz.itpu.courseproject.DAO.parser;

import uz.itpu.courseproject.model.ClimateControl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class ClimateControlParser implements CsvLineParser<ClimateControl> {
    @Override
    public List<ClimateControl> getData(String path) {
        List<ClimateControl> objs = new ArrayList<>();
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
                boolean hasRemoteControl = Boolean.parseBoolean(split[4]);
                ClimateControl climateControl = new ClimateControl(brand, color, price, model, hasRemoteControl);
                objs.add(climateControl);
                line = bufferedReader.readLine();
            }
            return objs;

        } catch (IOException e) {
            throw new InvalidParameterException(e.getMessage());
        }
    }
}
