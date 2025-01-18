import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;
import java.util.Collections;


class Passenger implements Comparable<Passenger> {
    private String name;
    private String passengerID;
    private int age;
    private String ticketClass;
    private String startPlace;
    private String destination;
    private String seatNumber;

    // Constructor
    public Passenger(String name, String passengerID, int age, String ticketClass, String startPlace, String destination, String seatNumber) {
        this.name = name;
        this.passengerID = passengerID;
        this.age = age;
        this.ticketClass = ticketClass;
        this.startPlace = startPlace;
        this.destination = destination;
        this.seatNumber = seatNumber;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public int getAge() {
        return age;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public String getDestination() {
        return destination;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    // Comparable implementation (default sort by passengerID)
    @Override
    public int compareTo(Passenger other) {
        return this.passengerID.compareTo(other.passengerID);
    }

    // Display passenger details
    public void displayPassengerData() {
        System.out.printf("%-20s %-15s %-5d %-10s %-15s %-15s %-10s\n",
                name, passengerID, age, ticketClass, startPlace, destination, seatNumber);
    }
}

public class PassengerRegistration {
    // Method to input passenger data
    public static Passenger getPassengerData(Scanner scanner) {
        System.out.println("Enter Passenger Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Passenger ID (Aadhar): ");
        String passengerID = scanner.nextLine();

        int age;
        while (true) {
            System.out.print("Age: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age > 0) {
                    break;
                } else {
                    System.out.println("Age must be positive. Please enter again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid age. Please enter a valid number.");
            }
        }

        String ticketClass;
        while (true) {
            System.out.print("Ticket Class (Economy/Business/First): ");
            ticketClass = scanner.nextLine();
            if (ticketClass.equalsIgnoreCase("Economy") || 
                ticketClass.equalsIgnoreCase("Business") || 
                ticketClass.equalsIgnoreCase("First")) {
                break;
            } else {
                System.out.println("Invalid ticket class. Please enter Economy, Business, or First.");
            }
        }

        System.out.print("Start Place: ");
        String startPlace = scanner.nextLine();

        System.out.print("Destination: ");
        String destination = scanner.nextLine();

        System.out.print("Seat Number: ");
        String seatNumber = scanner.nextLine();

        return new Passenger(name, passengerID, age, ticketClass, startPlace, destination, seatNumber);
    }

    // Method to check for unique passenger IDs
    public static boolean areUniqueIDs(List<Passenger> passengers) {
        Set<String> idSet = new HashSet<>();
        for (Passenger passenger : passengers) {
            if (!idSet.add(passenger.getPassengerID())) {
                System.out.println("Duplicate Passenger ID found: " + passenger.getPassengerID());
                return false; // Duplicate found
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Passenger> passengers = new ArrayList<>();

        // Input number of passengers to register
        System.out.print("Enter the number of passengers to register: ");
        int numPassengers;
        while (true) {
            try {
                numPassengers = Integer.parseInt(scanner.nextLine());
                if (numPassengers > 0) {
                    break;
                } else {
                    System.out.println("Number of passengers must be positive. Please enter again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        // Input passenger details
        for (int i = 0; i < numPassengers; i++) {
            System.out.println("\nPassenger " + (i + 1));
            passengers.add(getPassengerData(scanner));
        }

        // Check for unique IDs
        if (!areUniqueIDs(passengers)) {
            System.out.println("Error: Duplicate Passenger IDs found. Please recheck the data.");
            return;
        }

        // Display passenger details
        System.out.println("\nPassenger Details:");
        System.out.printf("%-20s %-15s %-5s %-10s %-15s %-15s %-10s\n",
                "Name", "Passenger ID", "Age", "Class", "Start Place", "Destination", "Seat No.");
        for (Passenger passenger : passengers) {
            passenger.displayPassengerData();
        }

        // Sorting menu
        System.out.println("\nSort by:");
        System.out.println("1. Name\n2. Passenger ID\n3. Age\n4. Ticket Class\n5. Destination");
        System.out.print("Choose an option (1-5): ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice. Exiting.");
            return;
        }

        Comparator<Passenger> comparator;
        switch (choice) {
            case 1:
                comparator = Comparator.comparing(Passenger::getName, String.CASE_INSENSITIVE_ORDER);
                break;
            case 2:
                comparator = Comparator.comparing(Passenger::getPassengerID);
                break;
            case 3:
                comparator = Comparator.comparingInt(Passenger::getAge);
                break;
            case 4:
                comparator = Comparator.comparing(Passenger::getTicketClass);
                break;
            case 5:
                comparator = Comparator.comparing(Passenger::getDestination);
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                return;
        }

        passengers.sort(comparator);

        // Display sorted passenger details
        System.out.println("\nSorted Passenger Details:");
        System.out.printf("%-20s %-15s %-5s %-10s %-15s %-15s %-10s\n",
                "Name", "Passenger ID", "Age", "Class", "Start Place", "Destination", "Seat No.");
        for (Passenger passenger : passengers) {
            passenger.displayPassengerData();
        }

        scanner.close();
    }
}
