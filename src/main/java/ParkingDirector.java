import java.util.List;

public class ParkingDirector {
    private List<ParkingBoy> boyList;

    private List<ParkingManager> managerList;

    public ParkingDirector(List<ParkingManager> managerList ,  List<ParkingBoy> boyList){
        this.managerList = managerList;
        this.boyList = boyList;

    }


    public List<ParkingBoy> getBoyList() {
        return boyList;
    }

    public void setBoyList(List<ParkingBoy> boyList) {
        this.boyList = boyList;
    }

    public List<ParkingManager> getManagerList() {
        return managerList;
    }

    public void setManagerList(List<ParkingManager> managerList) {
        this.managerList = managerList;
    }

    public void showReport(List<ParkingManager> managerList, List<ParkingBoy> boyList  ){

        System.out.println("==============Parking Report================");
        System.out.println("Manager : ");
        for(ParkingManager manager : managerList){
            for(ParkingLot lot : manager.getPackLots()){
                for(Car car :lot.getCars()){
                    System.out.println(car.getCarLicense() + "\n");
                }
            }
        }
        System.out.println("Parking Boy : ");
        for(ParkingBoy boy : boyList){
            for(ParkingLot lot : boy.getPackLots()){
                for(Car car :lot.getCars()){
                    System.out.println(car.getCarLicense() + "\n");
                }
            }
        }
        System.out.println("========End of Report=======");


    }
}
