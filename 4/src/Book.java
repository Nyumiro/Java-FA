public class Book {
    public String name;
    public String author;

    public Book(String name, String author){
        this.name = name;
        this.author = author;
    }

    public String toString(){
        return String.format("%s, автор: %s", this.name, this.author);
    }
}
