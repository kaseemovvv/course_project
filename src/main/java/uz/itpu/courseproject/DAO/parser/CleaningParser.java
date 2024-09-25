package uz.itpu.courseproject.DAO.parser;

import uz.itpu.courseproject.model.Cleaning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CleaningParser implements CsvLineParser<Cleaning> {
    @Override
    public List<Cleaning> getData(String path) {
        List<Cleaning> objs = new ArrayList<>();
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
                Cleaning cleaning = new Cleaning(brand, color, price, model, hasRemoteControl);
                objs.add(cleaning);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return objs;
    }
}
