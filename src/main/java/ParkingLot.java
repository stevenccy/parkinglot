import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParkingLot {

    private int maxNoOfLot;
    private List<Car> cars;

    public ParkingLot() {
        cars = new ArrayList<Car>();
    }

    public void park(Car c) {

        if (hasSameCar(c)) {
            System.out.println("Car already parked");
        } else if (cars.size() < maxNoOfLot) {
            cars.add(c);
        } else {
            System.out.println("car pool is full");
        }


    }

    public boolean hasSameCar(Car c) {
        Car matchedCar = cars.stream().filter(car -> car.getCarLicense().equals(c.getCarLicense())).findAny().orElse(null);
        return Objects.nonNull(matchedCar);
    }

    public void unPark(Car c) {
        if (cars.indexOf(c) < 0) {
            System.out.println("Car does exist");
        } else {
            cars.remove(c);
        }
    }
    
    public int getRemainSpace(){
    	return this.maxNoOfLot - this.cars.size();
    }

    public void setMaxNoOfLot(int maxNoOfLot) {
        this.maxNoOfLot = maxNoOfLot;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}