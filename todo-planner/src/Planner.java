import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

/** Класс, который хранит, фильтрует, добавляет и удаляет задания.
 *  */
public class Planner {
    private final ArrayList<Task> TASKS = new ArrayList<>();
    public void add(Task task) {
        TASKS.add(task);
    }
    public void delete(int deleted_task_id) {
        TASKS.removeIf(task -> task.getId() == deleted_task_id);
    }
    public ArrayList<Task> getTasks() {
        return TASKS;
    }
    public ArrayList<Task> getCompletedTasks() {
        return TASKS.stream().filter(Task::getCompleted)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Task> getUncompletedTasks() {
        return TASKS.stream().filter(task -> !task.getCompleted())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Получить задание по идентификатору.
     *
     * @param id идентификатор задания, которое нужно получить.
     * @return Возвращает задание, идентификатор которого совпадает с параметром id.
     */
    public Task getTask(int id) {
        for (var task: TASKS) {
            if (task.getId() == id)
                return task;
        }
        return null;
    }

    /**
     * Фильтрует задачи по дате создания.
     *
     * @param date дата создания заданий.
     * @return Возвращает список из всех задач, дата создания которых совпадает с параметром date.
     */
    public ArrayList<Task> getAllByCreationDate(LocalDate date) {
        return TASKS.stream().filter(task -> task.getCreatedDate().isEqual(date))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Фильтрует задачи по дате выполнения.
     *
     * @param date дата создания заданий.
     * @return Возвращает список из всех задач, дата выполнения которых совпадает с параметром date.
     */
    public ArrayList<Task> getAllByCompletionDate(LocalDate date) {
        return TASKS.stream().filter(task -> task.getCompleteDate().isEqual(date))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Фильтрует задачи по дате и статусу выполнения.
     *
     * @param date дата создания заданий.
     * @return Возвращает список из выполненных задач, дата создания которых совпадает с параметром date.
     */
    public ArrayList<Task> getCompletedByCreatedDate(LocalDate date) {
        return TASKS.stream().filter(task -> task.getCreatedDate().isEqual(date) && task.getCompleted())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Фильтрует задачи по дате и статусу выполнения.
     *
     * @param date дата создания заданий.
     * @return Возвращает список из невыполненных задач, дата выполнения которых совпадает с параметром date.
     */
    public ArrayList<Task> getUncompletedByCreatedDate(LocalDate date) {
        return TASKS.stream().filter(task -> task.getCreatedDate().isEqual(date) && !task.getCompleted())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Фильтрует задачи по дате и статусу выполнения.
     *
     * @param date дата выполнения заданий.
     * @return Возвращает список из выполненных задач, дата выполнения которых совпадает с параметром date.
     */
    public ArrayList<Task> getCompletedByCompletionDate(LocalDate date) {
       return TASKS.stream().filter(task -> task.getCompleteDate().isEqual(date) && task.getCompleted())
               .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Фильтрует задачи по дате и статусу выполнения.
     *
     * @param date дата выполнения заданий.
     * @return Возвращает список из невыполненных задач, дата выполнения которых совпадает с параметром date.
     */
    public ArrayList<Task> getUncompletedByCompletionDate(LocalDate date) {
        return TASKS.stream().filter(task -> task.getCompleteDate().isEqual(date) && !task.getCompleted())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
