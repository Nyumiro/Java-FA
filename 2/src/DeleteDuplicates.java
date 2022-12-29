import java.util.Collection;
import java.util.HashSet;

public class DeleteDuplicates {
    public static <C> Collection<C> deleteDuplicates(Collection<C> collection) {
        return new HashSet<>(collection);
    }
}
