public class Task_3 {
    // //Найдите корень уравнения на отрезке [0;10] с
    ////точностью по x не хуже 0.001. Известно, что на этом промежутке корень единственный.
    ////Используйте для этого метод деления отрезка пополам (и рекурсию).

    static double f(double x){
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
    }

    static double find(double x1, double x2){
        if ((x2 - x1) < 0.001)
            return (x1 + x2) / 2;
        var f1 = f(x1);
        var f2 = f(x2);
        var mid = (x1+x2) / 2;
        var fmid = f(mid);

        if(f1 * fmid < 0)
            return find(x1, mid);
        else return find(mid, x2);
    }
}
