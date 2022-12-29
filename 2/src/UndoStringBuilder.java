import java.util.Stack;

public class UndoStringBuilder {
    private interface Command {
        void undo();
    }

    private record AppendAndInsert(StringBuilder builder, int old_size, int new_size) implements Command {
        public void undo() {
            builder.delete(old_size, new_size);
        }
    }

    private record Delete(StringBuilder builder, int start, String deleted) implements Command {
        public void undo() {
            builder.insert(start, deleted);
        }
    }

    private record Reverse(StringBuilder builder) implements Command {
        public void undo() {
            builder.reverse();
        }
    }

    private record Replace(StringBuilder builder, int start, int len_new, String replaced) implements Command {
        public void undo() {
            builder.replace(start, start + len_new, replaced);
        }
    }

    private final StringBuilder builder;
    private final Stack<Command> commands = new Stack<>();

    public UndoStringBuilder() {
        builder = new StringBuilder();
    }

    public UndoStringBuilder(String str) {
        builder = new StringBuilder(str);
    }

    public UndoStringBuilder(int length) {
        builder = new StringBuilder(length);
    }

    public UndoStringBuilder(StringBuilder builder) {
        this.builder = builder;
    }

    public String toString() {
        return builder.toString();
    }

    public void undo() {
        if (!commands.empty()) {
            var command = commands.pop();
            command.undo();
        }
    }

    public void append(boolean a) {
        int old_size = builder.length();
        builder.append(a);
        int new_size = builder.length();
        commands.add(new AppendAndInsert(builder, old_size, new_size));
    }

    public void append(char a) {
        int old_size = builder.length();
        builder.append(a);
        int new_size = builder.length();
        commands.add(new AppendAndInsert(builder, old_size, new_size));
    }

    public void append(String a) {
        int old_size = builder.length();
        builder.append(a);
        int new_size = builder.length();
        commands.add(new AppendAndInsert(builder, old_size, new_size));
    }

    public void delete(int start, int end) {
        String deleted = builder.substring(start, end);
        builder.delete(start, end);
        commands.add(new Delete(builder, start, deleted));
    }

    public void deleteCharAt(int index) {
        delete(index, index + 1);
    }

    public void insert(int offset, boolean b) {
        int old_size = builder.length();
        builder.insert(offset, b);
        int new_size = builder.length();
        commands.add(new AppendAndInsert(builder, offset, offset + new_size - old_size));
    }

    public void insert(int offset, char[] str) {
        int old_size = builder.length();
        builder.insert(offset, str);
        int new_size = builder.length();
        commands.add(new AppendAndInsert(builder, offset, offset + new_size - old_size));
    }

    public void reverse() {
        builder.reverse();
        commands.add(new Reverse(builder));
    }

    public void replace(int start, int end, String str) {
        String replaced = builder.substring(start, end);
        builder.replace(start, end, str);
        commands.add(new Replace(builder, start, str.length(), replaced));
    }
}
