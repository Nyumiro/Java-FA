import java.time.LocalDate;
import java.util.Scanner;

public class ToDoPlanner {

    public static void main(String[] args) {

        // Добавляем тестовые данные:
        var planner = new Planner() {
            {
                add(new Task(LocalDate.of(2023, 1, 1),
                        "Поход к врачу", "Прием у стоматолога"));
                add(new Task(LocalDate.of(2023, 1, 2),
                        "Поход к врачу", "Прием у гинеколога"));
                add(new Task(LocalDate.of(2023, 2, 3),
                        "Поход к врачу", "Прием у проктолога"));
                add(new Task(LocalDate.of(2023, 2, 4),
                        "Поход к врачу", "Прием у онколога"));
                add(new Task(LocalDate.of(2023, 3, 5),
                        "Поход к врачу", "Прием у офтальмолога"));
                add(new Task(LocalDate.of(2023, 4, 6),
                        "Поход к врачу", "Прием у психиатра"));
            }
        };

        var scanner = new Scanner(System.in);

        System.out.println("""
                \n
                ВАС ПРИВЕТСТВУЕТ ПЛАНИРОВЩИК ЗАДАЧ С ULTRA 🤡 USER-UNFRIENDLY 🤡 ИНТЕРФЕЙСОМ!
               
                Список команд:\s
                 0 -- ПОСМОТРЕТЬ ДЕТАЛЬНУЮ ИНФОРМАЦИЮ О ЗАДАНИИ.
                 1 -- СОЗДАТЬ ЗАДАНИЕ.
                 2 -- УДАЛИТЬ ЗАДАНИЕ.\s
                 3 -- ИЗМЕНИТЬ ЗАДАНИЕ.\s
                 + -- ПОМЕТИТЬ ЗАДАНИЕ ВЫПОЛНЕННЫМ.\s
                 4 -- ПОКАЗАТЬ ВСЕ ЗАДАНИЯ.\s
                 5 -- ОТОБРАЗИТЬ ВСЕ ВЫПОЛНЕННЫЕ ЗАДАНИЯ.
                 6 -- ОТОБРАЗИТЬ ВСЕ НЕВЫПОЛНЕННЫЕ ЗАДАНИЯ.
                 7 -- ОТОБРАЗИТЬ ВСЕ ЗАДАНИЯ (ПО ДАТЕ СОЗДАНИЯ)
                 8 -- ОТОБРАЗИТЬ ВСЕ ЗАДАНИЯ (ПО ДАТЕ ВЫПОЛНЕНИЯ)
                 9 -- ОТОБРАЗИТЬ ВЫПОЛНЕННЫЕ ЗАДАНИЯ (ПО ДАТЕ СОЗДАНИЯ).
                10 -- ОТОБРАЗИТЬ ВЫПОЛНЕННЫЕ ЗАДАНИЯ (ПО ДАТЕ ВЫПОЛНЕНИЯ).
                11 -- ОТОБРАЗИТЬ НЕВЫПОЛНЕННЫЕ ЗАДАНИЯ (ПО ДАТЕ СОЗДАНИЯ).
                12 -- ОТОБРАЗИТЬ НЕВЫПОЛНЕННЫЕ ЗАДАНИЯ (ПО ДАТЕ СОЗДАНИЯ).
                """);

        while (true) {
            System.out.println("Введите команду: ");
            var command = scanner.nextLine();
            switch (command) {
                case "0" -> System.out.println(planner.getTask(ConsoleHelper.show(scanner, planner)).toString());
                case "1" -> planner.add(ConsoleHelper.create(scanner));
                case "2" -> planner.delete(ConsoleHelper.delete(scanner, planner));
                case "+" -> planner.getTask(ConsoleHelper.mark(scanner, planner)).setCompleted();
                case "3" -> ConsoleHelper.edit(scanner, planner);
                case "4" -> ConsoleHelper.showAll(planner);
                case "5" -> ConsoleHelper.showCompleted(planner);
                case "6" -> ConsoleHelper.showUncompleted(planner);
                case "7" -> ConsoleHelper.show_ALL_byCreationDate(planner, scanner);
                case "8" -> ConsoleHelper.show_ALL_byCompletionDate(planner, scanner);
                case "9" -> ConsoleHelper.show_COMPLETED_byCreationDate(planner, scanner);
                case "10" -> ConsoleHelper.show_COMPLETED_byCompletionDate(planner, scanner);
                case "11" -> ConsoleHelper.show_UNCOMPLETED_byCreationDate(planner, scanner);
                case "12" -> ConsoleHelper.show_UNCOMPLETED_byCompletionDate(planner, scanner);
                default -> System.out.println("Неизвестная команда.");
            }
        }
    }
}

