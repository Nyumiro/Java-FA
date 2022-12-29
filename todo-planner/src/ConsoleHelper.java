import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/** Класс, организующий работу с пользовательским вводом.
 * Обеспечивает связь пользователя с функционалом Task и Planner, вызывает валидирующие методы.
 *  */
public class ConsoleHelper {
    static Task create(Scanner scanner){
        var isValid = true;
        var title = "";
        var completeDate = LocalDate.now();
        System.out.println("Введите название задания:");
        do {
            title = scanner.nextLine();
            isValid = Validator.validateTitle(title);
            if (!isValid) System.out.println("Некорректное название задания. Введите название задания:");
        } while (!isValid);
        System.out.println("Введите описание задания:");
        var description = scanner.nextLine();
        System.out.println("Введите дату выполнения (шаблон: dd-MM-yyyy):");
        do {
            var completeDateText = scanner.nextLine();
            isValid = Validator.validateCompletionDate(completeDateText);
            if (isValid) completeDate = LocalDate.parse(completeDateText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            else System.out.println("Некорректная дата выполнения. Введите дату выполнения: ");
        } while (!isValid);
        System.out.println("\u26a1 Задание добавлено.");
        return new Task(completeDate, title, description);
    }
    static int delete(Scanner scanner, Planner planner) {
        var isValid = true;
        var id = 0;
        System.out.println("Введите номер задания, которое хотите удалить:");
        do {
            var delete = scanner.nextLine();
            isValid = Validator.validateID(delete, planner);
            if (!isValid) {
                System.out.println("Некорректный номер задания. Введите номер задания:");
            } else id = Integer.parseInt(delete);
        }
        while (!isValid);
        System.out.println("\u274C Задание удалено.");
        return id;
    }
    static void edit(Scanner scanner, Planner planner) {
        var delete = "";
        System.out.println("Введите номер задания, которое хотите изменить: ");
        while (true) {
            delete = scanner.nextLine();
            if (Validator.validateID(delete, planner)) break;
            System.out.println("Некорректный номер задания. Введите номер задания:");
        }
        var id = Integer.parseInt(delete);
        var task = planner.getTask(id);
        System.out.println("Введите новое название задания:");
        while(true) {
            task.setTitle(scanner.nextLine());
            if (Validator.validateTitle(task.getTitle())) break;
            System.out.println("Некорректное название задания. Введите название задания:");
        }
        System.out.println("Введите новое описание задания:");
        task.setDescription(scanner.nextLine());
        System.out.println("Введите новую дату выполнения (dd-MM-yyyy):");
        while (true) {
            var completeDateText = scanner.nextLine();
            if (Validator.validateCompletionDate(completeDateText)) {
                task.setCompleteDate(LocalDate.parse(completeDateText, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                break;
            }
            System.out.println("Некорректная дата выполнения. Введите дату выполнения:");
        }
        System.out.println("\u270e Задание отредактировано.");
    }

    /** Меняет статус выполнения задания.
     * @return id задания, которое нужно пометить выполненным. **/
    static int mark(Scanner scanner, Planner planner) {
        var isValid = true;
        var id = 0;
        System.out.println("Введите номер задания, которое требуется пометить выполненным: ");
        do {
            var delete = scanner.nextLine();
            isValid = Validator.validateID(delete, planner);
            if (!isValid) {
                System.out.println("Некорректный номер задания. Введите номер задания: ");
            } else id = Integer.parseInt(delete);
        } while (!isValid);
        System.out.println("\u2705 Задание выполнено.");
        return id;
    }

    /** Показать детальную информацию о задании.
     *  */
    static int show(Scanner scanner, Planner planner) {
        var isValid = true;
        var id = 0;
        System.out.println("Введите номер задания для отображения детальной информации: ");
        do {
            var delete = scanner.nextLine();
            isValid = Validator.validateID(delete, planner);
            if (!isValid) {
                System.out.println("Некорректный номер задания. Введите номер задания: ");
            } else id = Integer.parseInt(delete);
        } while (!isValid);
        return id;
    }

    /** Показать все задания.
     *  */
    static void showAll(Planner planner) {
        var tasks = planner.getTasks();
        if (tasks.size() == 0) {
            System.out.println("Нет заданий.");
            return;
        }
        tasks.forEach(task -> System.out.println(task.toString()));
    }

    /** Показать все выполненные задания.
     *  */
    static void showCompleted(Planner planner) {
        var tasks = planner.getCompletedTasks();
        if (tasks.size() == 0) {
            System.out.println("Нет выполненных заданий. ");
            return;
        }
        tasks.forEach(task -> System.out.println(task.toString()));
    }

    /** Показать все невыполненные задания.
     *  */
    static void showUncompleted(Planner planner) {
        var tasks = planner.getUncompletedTasks();
        if (tasks.size() == 0) {
            System.out.println("Нет невыполненных заданий.");
            return;
        }
        tasks.forEach(task -> System.out.println(task.toString()));
    }

    /** Показать все задачи на заданную дату создания.
     *  */
    static void show_ALL_byCreationDate(Planner planner, Scanner scanner) {
        System.out.println("Введите дату (dd-MM-yyyy) создания заданий: ");
        var createDate = "";
        while (true) {
            createDate = scanner.nextLine();
            if (Validator.validateDate(createDate)) break;
            System.out.println("Некорректная дата, попробуйте еще раз: ");
        }
        var date = LocalDate.parse(createDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        var tasks = planner.getAllByCreationDate(date);
        tasks.forEach(task -> System.out.printf(task.toString()));
    }

    /** Показать все задачи на заданную дату выполнения.
     *  */
    static void show_ALL_byCompletionDate(Planner planner, Scanner scanner) {
        System.out.println("Введите дату (dd-MM-yyyy) создания заданий: ");
        var createDate = "";
        while (true) {
            createDate = scanner.nextLine();
            if (Validator.validateDate(createDate)) break;
            System.out.println("Некорректная дата, попробуйте еще раз: ");
        }
        var date = LocalDate.parse(createDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        var tasks = planner.getAllByCompletionDate(date);
        tasks.forEach(task -> System.out.printf(task.toString()));
    }

    /** Показать выполненные задачи на заданную дату создания заданий.
     * Да, вот такое вот крутое название у метода. А что?
     *  */
    static void show_COMPLETED_byCreationDate(Planner planner, Scanner scanner) {
        System.out.println("Введите дату (dd-MM-yyyy) создания заданий: ");
        var createDate = "";
        while (true) {
            createDate = scanner.nextLine();
            if (Validator.validateDate(createDate)) break;
            System.out.println("Некорректная дата, попробуйте еще раз: ");
        }
        var date = LocalDate.parse(createDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        var tasks = planner.getCompletedByCreatedDate(date);
        tasks.forEach(task -> System.out.printf(task.toString()));
    }

    /** Показать выполненные задачи на заданную дату выполнения заданий.
     *  */
    static void show_COMPLETED_byCompletionDate(Planner planner, Scanner scanner) {
        System.out.println("Введите дату (dd-MM-yyyy) выполнения заданий: ");
        var createDate = "";
        while (true) {
            createDate = scanner.nextLine();
            if (Validator.validateDate(createDate)) break;
            System.out.println("Некорректная дата, попробуйте еще раз: ");
        }
        var date = LocalDate.parse(createDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        var tasks = planner.getCompletedByCompletionDate(date);
        tasks.forEach(task -> System.out.println(task.toString()));
    }

    /** Показать невыполненные задачи по дате создания.
     *  */
    static void show_UNCOMPLETED_byCreationDate(Planner planner, Scanner scanner) {
        System.out.println("Введите дату (dd-MM-yyyy) создания заданий: ");
        var createDate = "";
        while (true) {
            createDate = scanner.nextLine();
            if (Validator.validateDate(createDate)) break;
            System.out.println("Некорректная дата, попробуйте еще раз: ");
        }
        var date = LocalDate.parse(createDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        var tasks = planner.getUncompletedByCreatedDate(date);
        tasks.forEach(task -> System.out.println(task.toString()));
    }

    /** Показать невыполненные задачи по дате выполнения.
     *  */
    static void show_UNCOMPLETED_byCompletionDate(Planner planner, Scanner scanner) {
        System.out.println("Введите дату (dd-MM-yyyy) выполнения заданий: ");
        var createDate = "";
        while (true) {
            createDate = scanner.nextLine();
            if (Validator.validateDate(createDate)) break;
            System.out.println("Некорректная дата, попробуйте еще раз: ");
        }
        var date = LocalDate.parse(createDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        var tasks = planner.getUncompletedByCompletionDate(date);
        tasks.forEach(task -> System.out.println(task.toString()));
    }
}
