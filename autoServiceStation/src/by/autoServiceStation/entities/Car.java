package by.autoServiceStation.entities;


public class Car {
    private String make;
    private String model;
    private int year;
    private String vin;
    private int clientId;

    public Car() {
    }

    public Car(String make, String model, int year, String vin, int clientId) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
        this.clientId = clientId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", vin='" + vin + '\'' +
                ", clientId=" + clientId +
                '}';
    }
}
