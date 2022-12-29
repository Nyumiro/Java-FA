public class Task_1 {
    //Дано натуральное число n. Выведите все числа от 1 до n.
        static void printIntegers(int n, int i){
            System.out.println(i);
            if (i < n)
                printIntegers(n, i+1);
        };
    }

