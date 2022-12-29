import Cars.CarCreateException;
import Cars.PassengerCar;
import Cars.TransmissionType;
import Cars.Truck;
import Garage.Garage;

public class Main {
    public static void main(String[] args) throws Exception, CarCreateException {
        var garage = new Garage(3);

        garage.addCar(new PassengerCar("Toyota", "black", 120.0, TransmissionType.Automatic, 100.0, 4));
        garage.addCar(new PassengerCar("Volvo", "red", 150.0, TransmissionType.Automatic, 100.0, 4));
        garage.addCar(new Truck("Volvo", "black", 100.0, TransmissionType.Mechanical, 300.0, 5000));
        System.out.println(garage.orderByTypeCount());
        System.out.println(garage.showCarsSortedByPrice());
    }
}