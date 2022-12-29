public class PrintObserver implements Observer {
    public void onChanged(ObservableStringBuilder builder, String changeDescription) {
        System.out.println("Object " + builder.hashCode() + " was changed — " + changeDescription + "] \n" +
                builder.toString());
    }
}
