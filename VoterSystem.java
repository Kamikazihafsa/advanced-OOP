import java.util.ArrayList;
import java.util.Scanner;

class Voter {
    private String id;
    private String fullName;
    private String location;

    public Voter(String id, String fullName, String location) {
        this.id = id;
        this.fullName = fullName;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + fullName + ", Location: " + location;
    }
}

public class VoterSystem {
    private static ArrayList<Voter> voters = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            System.out.println("\nVoter Registration System");
            System.out.println("1. Register a new voter");
            System.out.println("2. View all registered voters");
            System.out.println("3. Search for a voter by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                continue;
            }
            
            switch (choice) {
                case 1:
                    registerVoter();
                    break;
                case 2:
                    viewAllVoters();
                    break;
                case 3:
                    searchVoterById();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the Voter Registration System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void registerVoter() {
        System.out.println("\nRegister a New Voter");
        
        System.out.print("Enter voter ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        
        System.out.print("Enter location: ");
        String location = scanner.nextLine();
        
        voters.add(new Voter(id, fullName, location));
        System.out.println("Voter registered successfully!");
    }

    private static void viewAllVoters() {
        System.out.println("\nAll Registered Voters");
        
        if (voters.isEmpty()) {
            System.out.println("No voters registered yet.");
        } else {
            for (Voter voter : voters) {
                System.out.println(voter);
            }
        }
    }

    private static void searchVoterById() {
        System.out.println("\nSearch Voter by ID");
        
        System.out.print("Enter voter ID to search: ");
        String searchId = scanner.nextLine();
        
        boolean found = false;
        for (Voter voter : voters) {
            if (voter.getId().equalsIgnoreCase(searchId)) {
                System.out.println("Voter found:");
                System.out.println(voter);
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Voter not found.");
        }
    }
}