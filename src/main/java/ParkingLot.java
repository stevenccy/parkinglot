import java.util.List;

public class ParkingLot{

    private int maxNoOfLot;
    private List<Car> cars;

    public void park(Car c){

        if(cars.indexOf(c) >= 0){
            System.out.println("Car already parked");
        }
        if(cars.size() < maxNoOfLot){
            cars.add(c);
        }
        else{
            System.out.println("car pool is full");
        }


    }

    public void unPark(Car c){
        if(cars.indexOf(c) < 0){
            System.out.println("Car does exist");
        }
        else {
            cars.remove(c);
        }
    }

    public void setMaxNoOfLot(int maxNoOfLot) {
        this.maxNoOfLot = maxNoOfLot;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}