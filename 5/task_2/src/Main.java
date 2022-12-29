import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        var buffer = new LinkedList<Integer>();
        var size = 10;

        var producer = new Thread(() -> {
            for (int i = 0; i < 100; i++){
                synchronized (buffer) {
                    if (buffer.size() == size) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    buffer.add(i);
                    buffer.notifyAll();
                }
            }
        }, "producer");

        var consumer = new Thread(() -> {
            while (true){
                synchronized (buffer){
                   if (buffer.size() == 0) {
                       try {
                           buffer.wait();
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }
                   }
                   System.out.println(buffer.poll());
                   buffer.notifyAll();
                }
            }

        }, "consumer");

        producer.start();
        consumer.start();

    }
}