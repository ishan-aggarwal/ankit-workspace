import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class InfectionTracking {

    public static int populateArrays(String pathToFile, String[] names, int[] locations, int[] movements,
                                     int[] infections) throws IOException {
        List<List<String>> records = new ArrayList<>();
        int counter = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values != null && values.length == 4) {
                    names[counter] = values[0];
                    locations[counter] = Integer.parseInt(values[1]);
                    movements[counter] = Integer.parseInt(values[2]);
                    infections[counter] = Integer.parseInt(values[3]);
                    counter++;
                } else {
                    return -1;
                }
            }
        } catch (IOException e) {
            throw e;
        }
        return counter;
    }

    public static void updateLocations(int worldSize, int[] locations, int[] movements) {
        for (int i = 0; i < locations.length; i++) {
            locations[i] = locations[i] + movements[i];
            if (locations[i] < 0) {
                locations[i] = locations[i] + worldSize;
            } else if (locations[i] >= worldSize) {
                locations[i] = locations[i] - worldSize;
            }
        }
    }

    public static int[] updateInfections(int worldSize, int[] locations, int[] infections) {
        int numStudentsInfected[] = new int[locations.length];
        Map<Integer, Integer> world = new HashMap<>();
        int tempInfections[] = new int[locations.length];
        //created an empty array of location numbers
        for (int i = 1; i < worldSize; i++) {
            world.put(i, 0);
        }
        //setting each location to 1 if there is any infected person
        for (int i = 0; i < locations.length; i++) {
            if (infections[i] == 1) {
                world.put(locations[i], 1);
            }
        }
        //infecting the person if any person in their location is infected
        for (int i = 0; i < locations.length; i++) {
            if (world.get(locations[i]) != null && world.get(locations[i]) > 0) {
                tempInfections[i] = 1;
            }
        }
        world.clear();
        for (int i = 1; i < worldSize; i++) {
            world.put(i, 0);
        }
        for (int i = 0; i < locations.length; i++) {
            if (infections[i] == 1) {
                world.put(locations[i], world.get(locations[i]) + 1);
            }
        }

        for (int i = 0; i < locations.length; i++) {
            if (tempInfections[i] == 1) {
                infections[i] = world.get(locations[i]);
            }
        }
        return numStudentsInfected;
    }

    public static void print(int input[]) {
        Arrays.stream(input).forEach(i -> System.out.print(" " + i));
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        String names[] = new String[10];
        int locations[] = new int[10];
        int infections[] = new int[10];
        int movements[] = new int[10];
        String filepath = "D:\\ide-code-workspace\\vikas-workbench\\src\\main\\resources\\students_case1.csv";

        populateArrays(filepath, names, locations, movements, infections);
        print(locations);
        updateLocations(4, locations, movements);
        System.out.println("printing updated locations::");
        print(locations);

        populateArrays(filepath, names, locations, movements, infections);
        System.out.println("Locations: ");
        print(locations);
//        System.out.println("Movements: ");
//        print(movements);
//        System.out.println("Infections: ");
//        print(infections);
        System.out.println();

        //updateLocations(4, locations, movements);

//        System.out.println("After update::");
//        System.out.println("Locations: ");
//        print(locations);
//        System.out.println("Movements: ");
//        print(movements);
//        System.out.println("Infections: ");
//        print(infections);
//        System.out.println();


        //System.out.println("printing updated locations::");
        //print(locations);
//        System.out.println();
//        updateInfections(6, locations, infections);
//        System.out.println("printing updated infections::");
//        print(infections);

    }

}