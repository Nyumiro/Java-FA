package employees;

public class Manager extends Employee {

    public Manager(String name, double ratePerMonth){
        this.id = createId();
        this.name = name;
        this.position = "manager";
        this.salary = salaryCalculation(ratePerMonth);
        employees.add(this);
    }

    public double salaryCalculation(double ratePerMonth) {
        return ratePerMonth;
    }


}

