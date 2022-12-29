public class Task_2 {
    //Напишите метод, который проверяет, входит ли в массив заданный элемент или нет.
    //Используйте перебор и двоичный поиск для решения этой задачи. Сравните время
    //выполнения обоих решений для больших массивов (например, 100000000 элементов).

    static int simpleSearch(int element, int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == element)
                return i;
        }
        return -1;
    }

    static int binarySearch(int[] array, int element, int left, int right){
        if (right >= left && left <= array.length - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == element)
                return mid;
            if (array[mid] > element)
                return binarySearch(array, left, mid - 1, element);
            return binarySearch(array, mid + 1, right, element);
        }
        return -1;
    }
    static int[] generateArray(int length){
        int[] array = new int[length];
        for (var i = 0; i < length; i ++) {
            array[i] = (int) (Math.random() * 1000);
        }
        return array;
    }
}
