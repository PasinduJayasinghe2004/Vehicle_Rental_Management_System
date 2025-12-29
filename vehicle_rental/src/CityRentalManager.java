
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CityRentalManager implements RentalManager{
    private ArrayList<Vehicle> vehicles;
    private int maxCapacity;
    private Scanner input;

    public CityRentalManager(int maxCapacity){
        this.maxCapacity=maxCapacity;
        this.vehicles=new ArrayList<>();
        this.input=new Scanner(System.in);
    }
    @Override
    public boolean runMenu(){
        System.out.println("\n========== City Vehicle Rental System ==========");
        System.out.println("1. Add Vehicle");
        System.out.println("2. Display Vehicles");
        System.out.println("3. Update Daily Rate");
        System.out.println("4. Open GUI");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");

        int choice = input.nextInt();
        input.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addVehicle();
                return false;
            case 2:
                displayVehicles();
                return false;
            case 3:
                updateDailyRate();
                return false;
            case 4:
                runGUI();
                return false;
            case 5:
                System.out.println("Exiting system. Thank you!");
                return true;
            default:
                System.out.println("Invalid choice. Please try again.");
                return false;
        }
    }

    @Override
    public void addVehicle() {
        if (vehicles.size() >= maxCapacity) {
            System.out.println("Fleet is at full capacity.");
            return;
        }
        System.out.println("\n-----Add vehicle-------");
        System.out.println("1.ADD Car");
        System.out.println("2.Add Motorcycle");
        System.out.println("3.Add Van");

        System.out.println("Enter vehicle Type: ");
        int type = input.nextInt();
        input.nextLine();

        System.out.println("Enter vehicle ID : ");
        String id = input.nextLine();

        System.out.println("Enter brand: ");
        String brand = input.nextLine();

        System.out.println("Enter model: ");
        String model = input.nextLine();

        System.out.println("Enter a dailyRate:$ ");
        double rate = input.nextDouble();

        System.out.println("Enter year: ");
        int year = input.nextInt();
        input.nextLine();

        Vehicle vehicle = null;

        switch (type) {
            case 1:
                Car cars = new Car(id, brand, model);
                cars.setDailyRate(rate);
                cars.setYear(year);

                System.out.println("Enter number of seats: ");
                cars.setNumberOfSeats(input.nextInt());
                input.nextLine();

                System.out.println("Enter fuel type(petrol/diesel/electric): ");
                cars.setFuelType(input.nextLine());

                System.out.println("Enter transmission(auto/manual): ");
                cars.setTransmission(input.nextLine());

                vehicle = cars;
                break;

            case 2:
                Motorcycle motorcycle = new Motorcycle(id, brand, model);
                motorcycle.setDailyRate(rate);
                motorcycle.setYear(year);

                System.out.print("Enter engine capacity (cc): ");
                motorcycle.setEngineCapacity(input.nextInt());
                input.nextLine();

                System.out.print("Helmet included? (true/false): ");
                motorcycle.setHasHelmet(input.nextBoolean());
                input.nextLine();

                System.out.print("Enter bike type (Sport/Cruiser/Touring): ");
                motorcycle.setBikeType(input.nextLine());

                vehicle = motorcycle;
                break;

            case 3:
                Van van = new Van(id, brand, model);
                van.setDailyRate(rate);
                van.setYear(year);

                System.out.print("Enter cargo capacity (cubic meters): ");
                van.setCargoCapacity(input.nextDouble());

                System.out.print("Enter number of doors: ");
                van.setNumberOfDoors(input.nextInt());
                input.nextLine();

                System.out.print("Is refrigerated? (true/false): ");
                van.setRefrigerated(input.nextBoolean());
                input.nextLine();

                vehicle = van;
                break;


            default:
                System.out.println("Invalid vehicle type!");
                return;
        }
            vehicles.add(vehicle);
            System.out.println("Vehicle add successfully.");




    }

    @Override
    public void displayVehicles(){
        if(vehicles.isEmpty()){
            System.out.println("\n No vehicles in the fleet.");
            return;
        }
        Collections.sort(vehicles);

        for(Vehicle v: vehicles){
            System.out.println(v);
        }

        System.out.println("\n ------fleet statics----");
        System.out.println("Total vehicles: "+vehicles.size());

        double totalRevenue=0;
        for(Vehicle v:vehicles){
            totalRevenue+=v.getDailyRate();
        }
        System.out.printf("Potential Daily revenue: ",totalRevenue);
    }
    @Override
    public void updateDailyRate(){
        System.out.println("\n --Update Daily Rate----");
        System.out.println("Enter vehicle id: ");
        String Vid=input.nextLine();
        Vehicle foundVehicle=null;
        for(Vehicle v:vehicles){
            if(v.getVehicleId().equalsIgnoreCase(Vid)){
                foundVehicle=v;
                break;
            }
        }
        if(foundVehicle != null){
            System.out.println("\nVehicle Found.");
            System.out.println("Brand: "+foundVehicle.getBrand());
            System.out.println("Model: "+foundVehicle.getModel());
            System.out.println("Current Daily Rate: "+foundVehicle.getDailyRate());
            System.out.println("Type: "+foundVehicle.getVehicleType());

            System.out.println("\n Enter new daily Rate: $");
            double newRate=input.nextDouble();
            input.nextLine();

            foundVehicle.setDailyRate(newRate);
            System.out.println("Update new daily rate.");

        }else{
            System.out.println("Vehicle not found ");
            return;
        }



    }
    @Override
    public void runGUI(){

    }
    public void addVehicleToList(Vehicle vehicle){
        if(vehicles.size()<maxCapacity){
            vehicles.add(vehicle);
        }
    }
    public ArrayList<Vehicle> getVehicles(){
        return vehicles;
    }


}
