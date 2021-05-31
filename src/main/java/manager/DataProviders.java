package manager;

import models.Car;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> validData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"marsh@gmail.com", "Marsh1234$"});
        list.add(new Object[]{"marsh@gmail.com", "Marsh1234$"});
        list.add(new Object[]{"marsh@gmail.com", "Marsh1234$"});
        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> dataFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
        String line = reader.readLine();
        while (line !=null) {
            String[] split = line.split(",");
            list.add( new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();

        }

        return list.iterator();
    }

    //-------------------------------------------
    @DataProvider
    public Iterator<Object[]> dataCarFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/car.csv")));
        String line = reader.readLine();
        while (line !=null) {
            String[] split = line.split(",");
            list.add( new Object[]{new Car()
                    .withLocation(split[0])
                    .withMake(split[1])
                    .withModel(split[2])
                    .withYear(split[3])
                    .withEngine(split[4])
                    .withFuel(split[5])
                    .withGear(split[6])
                    .withWd(split[7])
                    .withDoors(split[8])
                    .withSeats(split[9])
                    .withCarClass(split[10])
                    .withFuelConsumption(split[11])
                    .withCarRegNum(split[12])
                    .withPrice(split[13])
                    .withDistanceIncluded(split[14])

                    });
            line = reader.readLine();

        }

        return list.iterator();
    }

    }

