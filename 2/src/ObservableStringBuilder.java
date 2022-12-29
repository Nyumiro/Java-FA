import java.util.HashSet;

public class ObservableStringBuilder implements Observable {
    private final StringBuilder builder;

    public ObservableStringBuilder() {
        builder = new StringBuilder();
    }

    public ObservableStringBuilder(String str) {
        builder = new StringBuilder(str);
    }

    private final HashSet<Observer> observers = new HashSet<>();

    public void add(Observer obj) {
        observers.add(obj);

    }

    private void notifyObservers(String changeDescription) {
        for (var el : observers)
            el.onChanged(this, changeDescription);
    }

    public void remove(Observer obj) {
        observers.remove(obj);
    }

    public void append(char a) {
        builder.append(a);
        notifyObservers("append char " + a);
    }

    public void append(String a) {
        builder.append(a);
        notifyObservers("append string" + ", argument: " + "(" + a + ")");
    }

    public void delete(int start, int end) {
        builder.delete(start, end);
        notifyObservers("delete from" + start + "index to " + end);
    }

    public int length(){
        return builder.length();
    }

    public String toString() {
        return builder.toString();
    }
}
