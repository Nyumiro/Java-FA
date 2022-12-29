import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //1.
       Task_1.printIntegers(10, 1);

        //3.
        System.out.println(Task_3.find(0, 10));

        //2.
        var test = Task_2.generateArray(100000000);
        Arrays.sort(test);

        var simple_search = new Thread(() -> {
            long start = System.nanoTime();
            var result = Task_2.simpleSearch(-123, test);
            long end = System.nanoTime();
            System.out.println(Thread.currentThread().getName()+ " выполнил поиск элемента за " +
                    (end - start) / 1000000. + " мс.");
        }, "simple search");

        var binary_search = new Thread(() -> {
            long start = System.nanoTime();
            var result = Task_2.binarySearch(test, -123, 0, test.length-1);
            long end = System.nanoTime();
            System.out.println(Thread.currentThread().getName()+ " выполнил поиск элемента за " +
                    (end - start) / 1000000. + " мс.");
        }, "binary search");

        simple_search.start();
        binary_search.start();
        simple_search.join();
        binary_search.join();

        //4.
        BinarySearchTree test_tree = new BinarySearchTree() {
            {
                insert(10);
                insert(90);
                insert(73);
                insert(45);
                insert(27);
            }
        };

        System.out.println(test_tree);
        System.out.println(test_tree.search(27));
    }

}