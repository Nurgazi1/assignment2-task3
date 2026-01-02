import java.util.ArrayList;
import java.util.Scanner;


public class FleetApp {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("1. Print all vehicles");
            System.out.println("2. Add new car");
            System.out.println("3. Add new bus");
            System.out.println("4. Show total yearly insurance fees");
            System.out.println("5. Show vehicles older than N years");
            System.out.println("6. Perform service for all vehicles");
            System.out.println("7. Quit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    printAllVehicles();
                    break;
                case 2:
                    addNewCar();
                    break;
                case 3:
                    addNewBus();
                    break;
                case 4:
                    showTotal();
                    break;
                case 5:
                    showOlder();
                    break;
                case 6:
                    perfomeService();
                    break;
                case 7:
                    quiet();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private void quiet() {
        System.exit(0);
    }

    private void perfomeService() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the list.");
            return;
        }

        for (Vehicle i : vehicles) {
            if (i instanceof Servicable s) {
                s.performService();
            }
        }
    }

    private void showOlder() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the list.");
        }
        else {
            System.out.println("Enter current year:");
            int currentYear = sc.nextInt();

            System.out.println("Enter N (years):");
            int N = sc.nextInt();

            boolean found = false;

            for (Vehicle v : vehicles) {
                if (v.getAge(currentYear) > N) {
                    System.out.println(v);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No vehicles older than " + N + " years.");
            }
        }
    }

    private void showTotal() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the list.");
        }
        double total = 0;

        for (Vehicle i : vehicles) {
            total += i.calculateInsuranceFee();
        }
        System.out.println("Total Insurance Fee: " + total);


    }

    private void addNewBus() {
        sc.nextLine();

        System.out.print("Enter model: ");
        String model = sc.nextLine();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        System.out.print("Enter base price: ");
        double basePrice = sc.nextDouble();

        System.out.print("Passenger capacity: ");
        int capacity = sc.nextInt();

        System.out.print("Has body injury insurence? (true/false)");
        boolean insurance = sc.nextBoolean();

        Bus bus = new Bus(model, year, basePrice, capacity, insurance);
        vehicles.add(bus);

        System.out.println("Success!");
    }

    private void addNewCar() {
        sc.nextLine();

        System.out.println("Choose car model:");
        String model = sc.nextLine();

        System.out.println("Enter year:");
        int year = sc.nextInt();

        System.out.println("Enter base price:");
        double basePrice = sc.nextDouble();

        System.out.println("Has airbugs (true/false):");
        boolean hasAirbugs = sc.nextBoolean();

        System.out.println("Number of doors:");
        int numbrOfDoors = sc.nextInt();

        Car car = new Car(model, year, basePrice, hasAirbugs, numbrOfDoors);
        vehicles.add(car);
        System.out.println("Success!");
    }

    private void printAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the list.");
        }
        else {
            for (Vehicle i : vehicles) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        new FleetApp().run();
    }


}

