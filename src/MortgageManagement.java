import java.util.ArrayList;
import java.util.Scanner;

public class MortgageManagement {

    public static void main(String[] args) {
        // Create ArrayList to store houses
        ArrayList<House> houseList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            // Display menu options
            System.out.println("\nWelcome Real Estate Listings Management");
            System.out.println("1. Add Property with Address and Price");
            System.out.println("2. Add Property with Full Details");
            System.out.println("3. Display All Houses");
            System.out.println("4. Update House Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Option 1: Add Property with Address and Price
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    houseList.add(new House(address, price));
                    System.out.println("property with address and price added");
                    break;

                case 2:
                    // Option 2: Add Property with Full Details
                    System.out.print("Enter Address: ");
                    address = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    price = scanner.nextDouble();
                    System.out.print("Enter Down Payment: ");
                    double downPayment = scanner.nextDouble();
                    System.out.print("Enter Mortgage Rate: ");
                    double mortgageRate = scanner.nextDouble();
                    houseList.add(new House(address, price, downPayment, mortgageRate));
                    break;

                case 3:
                    // Option 3: Display All Houses
                    if (houseList.isEmpty()) {
                        System.out.println("No houses to display.");
                    } else {
                        for (House house : houseList) {
                            house.printHouseDetails();
                            System.out.println();
                        }
                    }
                    break;

                case 4:
                    // Option 4: Update House Details
                    System.out.print("Enter the address of the house to update: ");
                    address = scanner.nextLine();
                    boolean found = false;

                    for (House house : houseList) {
                        if (house.getAddress().equalsIgnoreCase(address)) {
                            found = true;
                            System.out.print("Enter new Price: ");
                            house.setPrice(scanner.nextDouble());
                            System.out.print("Enter new Down Payment: ");
                            house.setDownPayment(scanner.nextDouble());
                            System.out.print("Enter new Mortgage Rate: ");
                            house.setMortgageRate(scanner.nextDouble());
                            System.out.println("House details updated successfully.");
                            house.printHouseDetails();
                            System.out.println();
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("House not found.");
                    }
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

