import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 Класс, представляющий задание\событие.
 Статическое поле idСounter инкрементируется при инициализации новой задачи
 и присваивается ей в качестве уникального идентификатора.

 Размер поля title не может превышать 20 знаков и состоять только из пробелов.
 Поле CompleteDate не может хранить дату, предшествующую дате создания.
 Дата создания хранится в поле createdDate и назначается по системной дате автоматически, изменить его нельзя.
 !Валидация данных происходит в классе Validator!
 */
public class Task {
    private boolean isCompleted = false;
    private static int idCounter;
    private final int ID;
    private final LocalDate CREATION_DATE;
    private LocalDate completionDate;
    private String title;
    private String description;

    private int createId() {
        return ++idCounter;
    }
    /**
     * @param completionDate дата выполнения.
     * @param title название.
     * @param description описание задачи.
     */
    public Task(LocalDate completionDate, String title, String description){
        this.ID = createId();
        this.CREATION_DATE = LocalDate.now();
        this.completionDate = completionDate;
        this.description = description;
        this.title = title;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setCompleteDate(LocalDate date){
        this.completionDate = date;
    }
    public void setCompleted() {
        this.isCompleted = true;
    }
    public boolean getCompleted() {
        return isCompleted;
    }

    public String toString() {
        return String.format("НОМЕР: %s, ДАТА СОЗДАНИЯ: %s, ДАТА ВЫПОЛНЕНИЯ: %s, НАЗВАНИЕ: %s, ОПИСАНИЕ: %s.",
                ID,
                CREATION_DATE.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)), // <- добавлены симпатичные выводы даты создания и выполнения.
                completionDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)),
                title,
                description);
    }

    public int getId() {
        return this.ID;
    }

    public LocalDate getCreatedDate() {
        return CREATION_DATE;
    }

    public LocalDate getCompleteDate() {
        return completionDate;
    }
    public String getTitle(){
        return title;
    }
}
