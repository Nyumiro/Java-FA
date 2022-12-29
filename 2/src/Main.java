import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1.
        var test_UndoStringBuilder = new UndoStringBuilder("Жить нужно так, чтобы");
        test_UndoStringBuilder.append(" другие завидовали!");
        System.out.println(test_UndoStringBuilder);
        test_UndoStringBuilder.undo();
        System.out.println(test_UndoStringBuilder);

        // 2
        var test_ObservableStringBuilder = new ObservableStringBuilder("Если волк молчит, то ");
        var test_Observer = new PrintObserver();
        test_ObservableStringBuilder.add(test_Observer);
        test_ObservableStringBuilder.append("лучше его не перебивать.");

        // 5
        var test_text = Files.readString(Path.of("src\\the_lion_and_the_dog.txt"));
        var dict = FrequencyDictionary.get(test_text);
        System.out.println(dict);
    }
}