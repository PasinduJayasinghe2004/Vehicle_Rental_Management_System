import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class VehicleTableModel extends AbstractTableModel{
    private String[] columnName={"Vehicle ID","Brand","Model","Daily Rate","Year","Type","Available"};
    private ArrayList<Vehicle> vehicles;

    public VehicleTableModel(ArrayList<Vehicle> vehicles){
        this.vehicles=vehicles;
    }
    @Override
    public int getRowCount(){
        return vehicles.size();
    }
    @Override
    public int getColumnCount(){
        return columnName.length;
    }
    @Override
    public Object getValueAt(int rowIndex,int columnIndex){
        Object temp=null;
        Vehicle vehicle=vehicles.get(rowIndex);
        switch(columnIndex){
            case 0:
                temp=vehicle.getVehicleId();
                break;
            case 1:
                temp=vehicle.getBrand();
                break;
            case 2:
                temp=vehicle.getModel();
                break;
            case 3:
                temp=vehicle.getDailyRate();
                break;
            case 4:
                temp=vehicle.getYear();
                break;
            case 5:
                temp=vehicle.getVehicleType();
                break;
            case 6:
                temp=vehicle.isAvailable() ? "Yes":"NO";
                break;
        }
        return temp;
    }
    @Override
    public String getColumnName(int col){
        return columnName[col];
    }



}
