import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Matrix test1 = new Matrix(new int[][] {{2, 2}, {2, 2}});
        var test2 = new Matrix(new int[][] {{1, 2}, {3, 4}});
        var test3 = 0;


        System.out.println(test1.add(test2).toString());
        System.out.println(test1.subtract(test2).toString());
        System.out.println(test1.multiply(test3).toString());
        System.out.println(test2.transpose().toString());
        System.out.println(test1.multiply(test2).toString());
        System.out.println(test2.exp(5).toString());
        System.out.println(test2.getValue(1,0));

        var test4 = Vector.generateVectors(10);
        System.out.println(Arrays.toString(test4));
    }
}


