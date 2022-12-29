import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Reader[] readers = {
                new Reader("Василий", "Пупкин", "Петрович", "ИТиАБД", "89091235689", "01-01-2001"),
                new Reader("Евгений", "Понасенков", "Николаевич", "ИТиАБД", "89091235349", "13-03-1982"),
                new Reader("Владимир", "Путин", "Владимирович", "ИТиАБД", "88005553535", "07-10-1952")};

        System.out.println(Arrays.toString(readers));

        System.out.println(readers[0].takeBook(4));
        System.out.println(readers[1].takeBook("История России с древнейших времен до наших дней", "50 оттенков серого"));
        System.out.println(readers[2].takeBook(new Book("Война и мир", "Л.Н. Толстой"),
                new Book("Как перестать беспокоиться и начать жить", "Д. Карнеги")));
        System.out.println(readers[2].returnBook(new Book("Война и мир", "Л.Н. Толстой")));
    }
}