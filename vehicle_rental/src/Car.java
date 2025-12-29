public class Car extends Vehicle{
    private int numberOfSeats;
    private String fuelType;
    private String transmission;

    public Car(String vehicleId,String brand,String model){
        super(vehicleId,brand,model);
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getTransmission() {
        return transmission;
    }
    @Override
    public String toString(){
        return super.toString()+"Number of Seats: "+numberOfSeats+"\nFuelType :"+fuelType+"\nTransmission: "+transmission;
    }
    @Override
    public String getVehicleType(){
        return "Car";
    }
}
