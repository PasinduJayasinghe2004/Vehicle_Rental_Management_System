public abstract class Vehicle implements Comparable<Vehicle>{
    private String vehicleId;
    private String brand;
    private String model;
    private double dailyRate;
    private int year;
    private boolean available;

    public Vehicle(String vehicleId,String brand,String model){
        this.vehicleId=vehicleId;
        this.brand=brand;
        this.model=model;
        this.available=true;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    public abstract String getVehicleType();

    @Override
    public int compareTo(Vehicle other){
        return Double.compare(this.dailyRate,other.dailyRate);
    }
    @Override
    public String toString(){
        return vehicleId;
    }

}
