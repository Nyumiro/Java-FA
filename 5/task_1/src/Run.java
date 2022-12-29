public class Run implements Runnable{
    @Override
    public void run() {
        System.out.println("Имя текущего потока: " + Thread.currentThread().getName());
    }
}
