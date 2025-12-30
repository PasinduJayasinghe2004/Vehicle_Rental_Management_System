import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VehicleTableGUI extends JFrame {
        private JTable myTable;
        private VehicleTableModel tableModel;
        private ArrayList<Vehicle> vehicles;

        public VehicleTableGUI(ArrayList<Vehicle> vehicles){
            this.setTitle("City vehicle Rental-Fleet Management");

            this.vehicles=vehicles;
            tableModel=new VehicleTableModel(vehicles);
            myTable=new JTable(tableModel);

            setBounds(20,20,1000,600);//Set the size of a frame
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            myTable.setAutoCreateRowSorter(true);//Enable Sorting

            JScrollPane scrollPane = new JScrollPane(myTable);//add scroll pane to table
            scrollPane.setPreferredSize(new Dimension(950,500));

            JButton statsButton =new JButton("Fleet static");

            //Add event handler to the stats button
            statsButton.addActionListener(new ActionListener() {
               @Override
                public void actionPerformed(ActionEvent e){
                   showFleetStatistics();
               }
            });


        }
        private void showFleetStatistics(){
            int carCount=0;
            int motorcycleCount=0;
            int vanCount=0;
            double totalRevenue=0;
            int availablecount=0;

            for(Vehicle vehicle:vehicles){
                if(vehicle instanceof Car){
                    carCount++;
                }else if(vehicle instanceof Motorcycle){
                    motorcycleCount++;

                }else if (vehicle instanceof Van){
                    vanCount++;
                }
                totalRevenue+=vehicle.getDailyRate();

                if(vehicle.isAvailable()){
                    availablecount++;
                }
            }
            String message="_______Fleet Statistic____\n\n"+"Total Cars:  "+carCount+"\n"+"Total Motorcycle: "+motorcycleCount+"\n"+"TotalVans: "+vanCount+"\n"+
                    "Total vehicle: "+vehicles.size()+"\n"+"Available vehicle"+availablecount+"\n"+
                    String.format("Potential Daily revenue: $%.2f",totalRevenue);

            JOptionPane.showMessageDialog(this,message,"Fleet Statics",JOptionPane.INFORMATION_MESSAGE);


        }

}
