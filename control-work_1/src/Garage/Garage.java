package Garage;

import Cars.Car;

import java.util.ArrayList;
import java.util.HashMap;

public class Garage {
    private int maxCount;
    private ArrayList<Car> cars = new ArrayList<>();

    public Garage(int maxCount) throws GarageCreateException {
        if (maxCount > 0)
            this.maxCount = maxCount;
        else
            throw new GarageCreateException("Некорректное значение максимального количества парковочных мест.");
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void addCar(Car car) throws Exception, GarageParkingException {
        if (cars.size() < maxCount)
            cars.add(car);
        else
            throw new GarageParkingException("Мест нет.");
    }

    public String orderByTypeCount() {
        HashMap<String, Integer> count = new HashMap<>();
        var builder = new StringBuilder();

        for (var car : cars) {
            if (count.containsKey(car.getType()))
                count.put(car.getType(), count.get(car.getType()) + 1);
            else count.put(car.getType(), 1);
        }

        ArrayList<CarTypeCounter> list = new ArrayList<>();
        for (var item : count.keySet()) {
            list.add(new CarTypeCounter(item, count.get(item)));
        }

        list.sort((a, b) -> Integer.compare(b.count, a.count));

        for (var i : list) {
            builder.append(String.format("Тип автомобиля: %s, количество автомобилей данного типа: %s. %n",
                    i.type, i.count));
        }
        return builder.toString();
    }

    public String showCarsSortedByPrice() {
        var builder = new StringBuilder();

        cars.sort((a, b) -> Double.compare(b.getPrice(), a.getPrice()));
        for (var i : cars) {
            builder.append(i.toString()).append("\n");
        }

        return builder.toString();
    }


}
