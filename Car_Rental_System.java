package java_projects;
import java.util.Scanner;
import java.util.ArrayList;
/// Car class
class Car {
    private String carId;
    private String model;
    private boolean isAvailable;

    public Car(String carId, String model) {
        this.carId = carId;
        this.model = model;
        this.isAvailable = true; // Default: Car is available
    }

    public String getCarId() {
        return carId;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rentCar() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(model + " has been rented.");
        } else {
            System.out.println(model + " is already rented.");
        }
    }

    public void returnCar() {
        isAvailable = true;
        System.out.println(model + " has been returned.");
    }

    public void displayCar() {
        System.out.println(carId + " | " + model + " | " + (isAvailable ? "Available" : "Rented"));
    }
}

// Car Rental System class
class CarRentalSystem {
    private ArrayList<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void displayAvailableCars() {
        System.out.println("\nAvailable Cars:");
        for (Car car : cars) {
            if (car.isAvailable()) {
                car.displayCar();
            }
        }
    }

    public void rentCar(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && car.isAvailable()) {
                car.rentCar();
                return;
            }
        }
        System.out.println("Car not available for rent.");
    }

    public void returnCar(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && !car.isAvailable()) {
                car.returnCar();
                return;
            }
        }
        System.out.println("Invalid return request.");
    }
}

// Main class for user interaction
public class Car_Rental_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarRentalSystem rentalSystem = new CarRentalSystem();

        // Adding some cars to the system
        rentalSystem.addCar(new Car("1", "Toyota Corolla"));
        rentalSystem.addCar(new Car("2", "Honda Civic"));
        rentalSystem.addCar(new Car("3", "Ford Mustang"));

        while (true) {
            System.out.println("\n---Welcome to Car Rental System ---");
            System.out.println("1. For View Available Cars");
            System.out.println("2. For Rent a Car");
            System.out.println("3. For Return a Car");
            System.out.println("4. For Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    rentalSystem.displayAvailableCars();
                    break;
                case 2:
                    System.out.print("Enter Car ID to Rent: ");
                    String rentId = scanner.next();
                    rentalSystem.rentCar(rentId);
                    break;
                case 3:
                    System.out.print("Enter Car ID to Return: ");
                    String returnId = scanner.next();
                    rentalSystem.returnCar(returnId);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.out.println("thank you for using our service.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }
 }
}
}






