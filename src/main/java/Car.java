public class Car {
    private String carLicense;
    private String status;

    public Car(String carLicense, String status) {
        this.carLicense = carLicense;
        this.status = status;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }
}
