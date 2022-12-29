package employees;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public abstract class Employee {
    private static int id_counter;
    protected int id;
    protected String position;
    protected String name;
    protected double salary;
    protected static final ArrayList<Employee> employees = new ArrayList<>();

    //В задании нет необходимости задавать новую зарплату,
    //новое имя или еще каким-либо образом менять поля, поэтому реализованы только геттеры.
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public abstract double salaryCalculation(double rate);

    protected int createId() {
        return ++id_counter;
    }

    //Реализация подзадачи с печатью необходимых полей объектов-работников.
    public String toString() {
        return String.format("{Id: %s, name: %s, position: %s, salary: %s}", id, name, position, salary);
    }

    public static ArrayList<Employee> list() {
        return employees;
    }

    //Реализация подзадачи с сортировкой по (зарплата, имя).
    public static void sortedList() {
        employees.sort((o1, o2) -> {
            if (o1.getSalary() != o2.getSalary())
                return Double.compare(o2.getSalary(), o1.getSalary());
            else
                return o1.name.compareTo(o2.name);
        });
    }

    public static void writeFile(String path) throws IOException {
        var writer = new FileWriter(path);
        for (var i: employees){
            writer.append(String.format("%s,%s,%s,%s", i.id, i.name, i.position, i.salary));
            writer.append("\n");
        }
        writer.flush();
        writer.close();
    }

    public static void readFile(String path) throws Exception {
        if (!path.contains(".")) throw new FormatFileException("Некорректный формат файла.");
        for (var i : Files.readString(Path.of(path)).split("\n")) {
            var employee = i.split(",");
            if (i.contains("manager")){
                new Manager(employee[1], Double.parseDouble(employee[3]));
            }
            else {
                new Cleaner(employee[1], Double.parseDouble(employee[3])/ 20.8 / 8);
            }
        }
    }
}

