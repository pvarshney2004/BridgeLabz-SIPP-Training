package Encapsulation_Polymorphism_Interface_AbstractClass;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle implements Insurable {
    private String vehicleNumber;
    private String type;
    protected double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentCost(int days);

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }
}
//Car Class
class Car extends Vehicle {
 private String insurancePolicyNumber;

 public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
     super(vehicleNumber, "Car", rentalRate);
     this.insurancePolicyNumber = insurancePolicyNumber;
 }

 public double calculateRentCost(int days) {
     return days * rentalRate;
 }

 public double calculateInsurance() {
     return 0.05 * rentalRate * 365; // yearly 5% of value
 }

 public String getInsuranceDetails() {
     return "Car Insurance Policy: ****" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
 }
}

//Bike Class
class Bike extends Vehicle {
 private String insurancePolicyNumber;

 public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
     super(vehicleNumber, "Bike", rentalRate);
     this.insurancePolicyNumber = insurancePolicyNumber;
 }

 public double calculateRentCost(int days) {
     return days * rentalRate;
 }

 public double calculateInsurance() {
     return 0.03 * rentalRate * 365;
 }

 public String getInsuranceDetails() {
     return "Bike Insurance Policy: ****" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
 }
}

//Truck Class
class Truck extends Vehicle {
 private String insurancePolicyNumber;

 public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
     super(vehicleNumber, "Truck", rentalRate);
     this.insurancePolicyNumber = insurancePolicyNumber;
 }

 public double calculateRentCost(int days) {
     return days * rentalRate + 500; // additional fixed maintenance charge
 }

 public double calculateInsurance() {
     return 0.08 * rentalRate * 365;
 }

 public String getInsuranceDetails() {
     return "Truck Insurance Policy: ****" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
 }
}

public class VehicleRentalSystem {
	public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("CAR123", 1000, "CARPOLICY1234"),
            new Bike("BIKE456", 300, "BIKEPOLICY5678"),
            new Truck("TRUCK789", 2000, "TRUCKPOLICY9012")
        };

        int rentalDays = 5;

        for (Vehicle v : vehicles) {
            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Vehicle Number: " + v.getVehicleNumber());
            System.out.println("Rental Cost for " + rentalDays + " days: ₹" + v.calculateRentCost(rentalDays));
            System.out.println("Insurance Cost: ₹" + v.calculateInsurance());
            System.out.println(v.getInsuranceDetails());
            System.out.println("-----------------------------");
            System.out.println();
        }
    }
}
