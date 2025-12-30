public class VehicleRentalSystem {
    static void main() {

        CityRentalManager manager = new CityRentalManager(15);

        boolean exit=false;

        while(!exit){
            exit=manager.runMenu();
        }
    }
}
