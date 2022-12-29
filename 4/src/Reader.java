import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Reader {
    private String name;
    private String surname;
    private String patronymic;
    private int readers_ticket;
    private String faculty;
    private String phone_number;
    private String dob;

    public Reader(String name, String surname, String patronymic, String faculty, String phone_number, String dob){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.faculty = faculty;
        this.phone_number = phone_number;
        this.dob = dob;
        this.readers_ticket = (int) (Math.random() * 10000);
    }

    /* По условию задачи нет нужды создавать геттеры и сеттеры, поэтому опускаем их. */

    public String takeBook(int amount){
        return String.format("%s взял книги в количестве: %s.", surname + ' ' + name.charAt(0) + '.' + patronymic.charAt(0) + '.', amount);
    }

    public String takeBook(String... book){
        return String.format("%s взял книги в количестве: %s. " +
                "Названия книг: %s.", surname + ' ' + name.charAt(0) + '.' + patronymic.charAt(0) + '.', book.length, Arrays.toString(book));
    }
    public String takeBook(Book... book){
        return String.format("%s взял книги в количестве: %s. " +
                "Названия книг: %s. ", surname + ' ' + name.charAt(0) + '.' + patronymic.charAt(0) + '.', book.length, Arrays.toString(book));
    }

    public String returnBook(int amount){
        return String.format("%s вернул книги в количестве: %s.", surname + ' ' + name.charAt(0) + '.' + patronymic.charAt(0) + '.', amount);
    }

    public String returnBook(String... book){
        return String.format("%s вернул книги в количестве: %s. " +
                "Названия книг: %s.", surname + ' ' + name.charAt(0) + '.' + patronymic.charAt(0) + '.', book.length, Arrays.toString(book));
    }

    public String returnBook(Book... book){
        return String.format("%s вернул книги в количестве: %s. " +
                "Названия книг: %s", surname + ' ' + name.charAt(0) + '.' + patronymic.charAt(0) + '.', book.length, Arrays.toString(book));
    }

    public String toString(){
        return String.format("[ФИО: %s, факультет: %s, номер чит.билета: %s, номер телефона: %s, дата рождения: %s.]", surname + ' ' + name.charAt(0) + '.' + patronymic.charAt(0) + '.', faculty, readers_ticket, phone_number, dob);
    }
}
