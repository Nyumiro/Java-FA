package Cars;

import Cars.Car;

public class Truck extends Car {
    private final double maxWeight;

    public Truck(String brand, String color, double maxSpeed, TransmissionType transmission, double price, double maxWeight) throws CarCreateException {
        super(brand, color, maxSpeed, transmission, price);
        if (maxWeight > 0)
            this.maxWeight = maxWeight;
        else
            throw new CarCreateException("Некорректное значение максимальной грузоперевозимости.");
        this.type = "Truck";
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public String toString() {
        return String.format("Тип: %s, марка: %s, трансмиссия: %s, вместимость (в кг): %s.", type, brand, transmission, maxWeight);
    }
}
