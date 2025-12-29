public class Van extends Vehicle{
    private  double cargoCapacity;
    private int numberOfDoors;
    private  boolean isRefrigerated;

    public Van(String vehicleId,String brand,String model){
        super(vehicleId,brand,model);
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public void setRefrigerated(boolean refrigerated) {
        isRefrigerated = refrigerated;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public boolean isRefrigerated() {
        return isRefrigerated;
    }

    @Override
    public String getVehicleType(){
        return "Van";
    }
    @Override
    public String toString(){
        return super.toString()+",Cargo capacity: "+cargoCapacity+ ",Doors: "+numberOfDoors+"Is registered: "+isRefrigerated;
    }

}
