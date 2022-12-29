package employees;

public class Cleaner extends Employee {

    public Cleaner(String name, double ratePerHour){
        this.id = createId();
        this.name = name;
        this.position = "cleaner";
        this.salary = salaryCalculation(ratePerHour);
        employees.add(this);
    }
    public double salaryCalculation(double ratePerHour) {
        return 20.8 * 8 * ratePerHour;
    }

}
