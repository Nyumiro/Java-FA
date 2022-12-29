package Cars;//Реализовать класс Cars.Car и дочерние классы отдельных моделей автомобиля.
// Все классы должны содержать атрибуты цвет, максимальная скорость, тип коробки передач, текущая скорость, цена;
// методы start(), stop(), accelerate(int speed).
// Продумать атрибуты и/или методы для отдельных моделей автомобилей.
//
//Защитить классы от изменения данных извне.
//
//Реализуйте класс Garage.Garage, который в себе будет хранить экземпляры автомобилей.
// Атрибуты – максимальная вместимость, какие автомобили и в каком количестве хранятся в гараже.
// Реализуйте методы, которые выводят на консоль построчно автомобили и их количество,
// отсортированных по количеству в гараже, отсортированных по цене автомобиля (если они есть в наличии)

public abstract class Car {
    protected String type;
    protected String brand;
    protected String color;
    protected double maxSpeed;
    protected TransmissionType transmission;
    protected double currentSpeed = 0.0;
    protected Boolean isStarted = false;
    protected double price;

    public Car(String brand, String color, double maxSpeed, TransmissionType transmission, double price) throws CarCreateException {
        this.brand = brand;
        this.color = color;
        if (maxSpeed > 50)
            this.maxSpeed = maxSpeed;
        else
            throw new CarCreateException("Некорректное значение максимальной скорости.");
        this.transmission = transmission;
        if (price >= 0)
            this.price = price;
        else
            throw new CarCreateException("Некорректное значение цены.");
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getIsStarted() {
        return isStarted;
    }

    public void start() {
        isStarted = true;
    }

    public void stop() {
        isStarted = false;
    }

    public void accelerate(int speed) {
        currentSpeed = speed;
    }


}
