

public class Motorcycle extends Vehicle{
    private String bikeType;
    private int engineCapacity;
    private boolean hasHelmet;

    public Motorcycle(String vehicleId,String brand,String model){
        super(vehicleId,brand,model);

    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void setHasHelmet(boolean hasHelmet) {
        this.hasHelmet = hasHelmet;
    }

    public String getBikeType() {
        return bikeType;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public boolean isHasHelmet() {
        return hasHelmet;
    }
    @Override
    public String getVehicleType(){
        return "Motorcycle";
    }
    @Override
    public String toString(){
        return super.toString()+", Engine: "+engineCapacity+"cc:"+",Helmet Include: "+hasHelmet+",Type: "+bikeType;
    }
}
