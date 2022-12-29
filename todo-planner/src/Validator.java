import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/** Сгруппированные методы валидации введенных пользователем данных (для работы с Task).
 * Данный функционал вынесен в отдельный класс для упрощения работы с кодовой базой.
 *  */
public class Validator {

    /** Название задания не может быть пустым, состоять только из пробелов и превышать 20 символов.
     * @param title валидируемое название.
     *  */
    static boolean validateTitle(String title){
        return title.length() < 20 && !title.isBlank();
    }

    /** Проверяет, что введенная строка является датой + дата выполнения позже создания задания.
     * @param date валидируемая дата.
     *  */
    static boolean validateCompletionDate(String date) {
        try {
            var completeDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            return completeDate.isAfter(LocalDate.now());
        }
        catch (DateTimeParseException e) {
            return false;
        }
    }

    /** Почему в Java нет встроенных tryParse?
     * @param date валидируемая дата.
     *  */
    static boolean validateDate(String date) {
        try {
            var completeDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            return true;
        }
        catch (DateTimeParseException e) {
            return false;
        }
    }
    /** Осуществляет проверку на число и проверяет наличие задания с таким идентификатором.
     * @param id идентификатор задания.
     *  */
    static boolean validateID(String id, Planner planner){
        try {
            var intID = Integer.parseInt(id);
            return planner.getTask(intID) != null;
        }
        catch (Exception e) {
            return false;
        }
    }
}
