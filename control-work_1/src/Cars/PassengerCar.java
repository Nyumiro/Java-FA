package Cars;

import Cars.Car;

public class PassengerCar extends Car {
    private final int seatCount;

    public PassengerCar(String brand, String color, double maxSpeed, TransmissionType transmission, double price, int seatCount) throws CarCreateException {
        super(brand, color, maxSpeed, transmission, price);
        if (seatCount > 1)
            this.seatCount = seatCount;
        else
            throw new CarCreateException("Некорректное количества пассажирских мест.");
        this.type = "Passenger";
    }

    public int getSeatCount() {
        return seatCount;
    }

    public String toString() {
        return String.format("Тип: %s, марка: %s, трансмиссия: %s, количество пассажирских мест: %s.", type, brand, transmission, seatCount);
    }
}
