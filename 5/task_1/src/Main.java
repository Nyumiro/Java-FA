public class Main {
    public static void main(String[] args) throws InterruptedException {
        var one = new Thread(new Run());
        var two = new MyThread();
        var three = new Thread(() -> System.out.println("Имя текущего потока: " + Thread.currentThread().getName()));
        one.setName("One");
        two.setName("Two");
        three.setName("Three");

        one.start();
        one.join();

        two.start();
        two.join();

        three.start();

    }
    public static class MyThread extends Thread{
        public void run(){
            System.out.println("Имя текущего потока: " + Thread.currentThread().getName());
        }
    }
}