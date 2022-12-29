import employees.Employee;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {

        Employee.readFile("employees.csv");

        var employees = Employee.list();

        System.out.println(employees);
        Employee.sortedList();
        System.out.println(employees);

        // Подзадача с выводом имен первых пяти элементов.
        for (int i = 0; i < 6; i++){
            System.out.println(employees.get(i).getName());
        }

        System.out.println("----");

        // Подзадача с выводом id последних трех элементов.
        Collections.reverse(employees);
        for (int i = 0; i < 3; i++){
            System.out.println(employees.get(i).getId());
        }

        Employee.writeFile("employees.txt");

    }
}
