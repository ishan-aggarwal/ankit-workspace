package alex;

import java.util.*;

public class HouseDirectory {

    private static final int CAPACITY = 5;
    private static int count;
    private House[] houses;

    public HouseDirectory() {
        this.houses = new House[CAPACITY];
        count = 0;
    }

    public boolean isFull() {
        return (count == CAPACITY);
    }

    public boolean addHouse(House house) {
        if (count == CAPACITY) return false;

        houses[count] = house;
        count++;
        return true;
    }

    public static void printMenu() {
        System.out.println("---Welcome to the Housing App---");
        System.out.println("Here are your options:");
        System.out.println("1. Add a house");
        System.out.println("2. Edit a house");
        System.out.println("3. Delete a house");
        System.out.println("4. Display all houses below a certain price");
        System.out.println("5. Display the house with min price");
        System.out.println("6. Display the house with the max price");
        System.out.println("7. Sort and display the houses by price");
        System.out.println("8. Exit");
        System.out.print("Your input:");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HouseDirectory directory = new HouseDirectory();

        while (true) {
            try{
                printMenu();
                int userInput = scanner.nextInt();

                switch (userInput) {
                    case 1:
                        if (directory.isFull()) {
                            System.out.println("Sorry, the directory is full!");
                            System.out.println("Please try some other option.");
                            continue;
                        } else {
                            System.out.println("Enter the ID:");
                            int id = scanner.nextInt();
                            System.out.println("Enter the price:");
                            double price = scanner.nextDouble();
                            System.out.println("What is the status. Is it available for sale? (yes/no): ");
                            String status = scanner.next();
                            if (!status.equalsIgnoreCase("yes") && !status.equalsIgnoreCase("no")) {
                                System.out.println("Invalid status. Please try again");
                                continue;
                            }
                            House house = new House(id, price, status);
                            directory.addHouse(house);
                            System.out.println("The house has been added in the directory.");
                        }
                        continue;
                    case 2:
                        directory.editHouse(scanner);
                        continue;
                    case 3:
                        directory.deleteHouse(scanner);
                        continue;
                    case 4:
                        System.out.println("Enter the price: ");
                        double price = scanner.nextDouble();
                        directory.diplayHousesBelowPrice(price);
                        System.out.println();
                        continue;
                    case 5:
                        directory.diplayHouseWithMinPrice();
                        continue;
                    case 6:
                        directory.diplayHouseWithMaxPrice();
                        continue;
                    case 7:
                        directory.sortHousesAndPrint();
                        continue;
                    case 8:
                        System.out.println("Bye!!");
                        System.exit(0);
                    default:
                        System.out.println("Enter valid option.");
                        continue;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid Input. Please try again.");
                scanner.next();
                continue;
            }
        }
    }

    private void deleteHouse(Scanner scanner) {
        if (count == 0) {
            System.out.println("Directory is empty. Please add a house.");
        } else {
            System.out.println("Below are the houses in directory");
            printHouses(houses);
            System.out.println("Enter the id of the house which you want to delete:");
            int id = scanner.nextInt();
            boolean deleted = false;
            House[] temp = new House[CAPACITY];
            int index = 0;
            for(int i=0; i<CAPACITY; i++) {
                if(houses[i] != null && houses[i].getId() != id) {
                    temp[index] = houses[i];
                    index++;
                } else if(houses[i] != null && houses[i].getId() == id) {
                    count--;
                    deleted = true;
                }
            }
            this.houses = temp;
            if(!deleted) {
                System.out.println("Invalid Id. Plese try again.");
            } else {
                System.out.println("Deleted the houses having the ID entered by you.");
                System.out.println();
            }
        }
    }

    private void editHouse(Scanner scanner) {
        if (count == 0) {
            System.out.println("Directory is empty. Please add a house.");
        } else {
            System.out.println("Below are the houses in directory");
            printHouses(houses);
            System.out.println("Enter the id of the house which you want to edit:");
            int id = scanner.nextInt();
            boolean changed = false;
            System.out.println("Enter new price: ");
            double price = scanner.nextDouble();

            System.out.println("Enter new status: ");
            String status = scanner.next();
            if (!status.equalsIgnoreCase("yes") && !status.equalsIgnoreCase("no")) {
                System.out.println("Invalid status. Please try again");
            } else {
                for(House house: houses) {
                    if(house!=null && house.getId() == id) {
                        house.setPrice(price);
                        house.setStatus(status);
                        changed = true;
                    }
                }
                if(!changed) {
                    System.out.println("Invalid Id. Plese try again.");
                } else {
                    System.out.println("Edited the houses having the ID entered by you.");
                    System.out.println();
                }
            }
        }
    }

    public void diplayHousesBelowPrice(double price) {
        if (count == 0) {
            System.out.println("Directory is empty. Please add a house.");
        } else {
            System.out.println("Houses below price " + price + " are:");
            for(House house : houses) {
                if(house != null && house.getPrice() < price) {
                    System.out.println(house.toString());
                }
            }
        }
    }

    public void diplayHouseWithMinPrice() {
        if (count == 0) {
            System.out.println("Directory is empty. Please add a house.");
        } else {
            Optional<House> min = Arrays.stream(houses)
                    .filter(house -> house!=null)
                    .min(Comparator.comparing(House::getPrice));
            if (min.isPresent()) {
                System.out.println("House with minimum price is:");
                System.out.println(min.get().toString());;
            }
        }
    }

    public void diplayHouseWithMaxPrice() {
        if (count == 0) {
            System.out.println("Directory is empty. Please add a house.");
        } else {
            Optional<House> max = Arrays.stream(houses)
                    .filter(house -> house!=null)
                    .max(Comparator.comparing(House::getPrice));
            if (max.isPresent()) {
                System.out.println("House with maximum price is:");
                System.out.println(max.get().toString());

            }
        }
    }

    public void sortHousesAndPrint() {
        if (count == 0) {
            System.out.println("Directory is empty. Please add a house.");
        } else {
            houses = Arrays.stream(houses)
                    .filter(house -> house!=null)
                    .sorted(Comparator.comparing(House::getPrice)).toArray(House[]::new);
            System.out.println("House Directory is sorted. They are stored in below order: ");
            printHouses(houses);

            //sorted array size will be reduced by stream api
            //making new array for directory of size same as capacity
            House[] temp = new House[CAPACITY];
            for(int i=0;i<houses.length;i++) {
                temp[i] = houses[i];
            }
            houses = temp;
        }
    }

    private void printHouses(House[] houses) {
        Arrays.stream(houses)
                .filter(house -> house!=null)
                .forEach(house -> System.out.println(house.toString()));
    }
}
