import java.util.Arrays;

public class Matrix {
    private final int[][] DATA;

    public int[] getDimension() {
        return new int[]{DATA.length, DATA.length > 0 ? DATA[0].length : 0};
    }

    public Matrix(int rows, int columns) {
        DATA = new int[rows][columns];
    }

    public Matrix(int[][] data) {
        DATA = data;
    }

    public int getValue(int row, int column) throws MatrixException {
        if (row < 0 || row > getDimension()[0] || column < 0 || column > getDimension()[1])
            throw new MatrixException("Unable to get value. \nMatrix index is invalid.");
        return DATA[row][column];
    }

    public void setValue(int row, int column, int value) throws MatrixException {
        if (row < 0 || row > getDimension()[0] || column < 0 || column > getDimension()[1])
            throw new MatrixException("Unable to set value. \nMatrix index is invalid.");
        DATA[row][column] = value;
    }

    public String toString() {
        return Arrays.deepToString(DATA);
    }

    public Matrix add(Matrix a) throws MatrixException {
        var dimensionOne = getDimension();
        var dimensionTwo = a.getDimension();
        if (dimensionOne[0] != dimensionTwo[0] || dimensionOne[1] != dimensionTwo[1])
            throw new MatrixException("Matrices must have the equal dimension!");
        Matrix result = new Matrix(dimensionOne[0], dimensionOne[1]);
        for (int row = 0; row < dimensionOne[0]; row++)
            for (int column = 0; column < dimensionOne[1]; column++)
                result.setValue(row, column, a.getValue(row, column) + getValue(row, column));
        return result;
    }

    public Matrix subtract(Matrix a) throws Exception {
        var dimensionOne = getDimension();
        var dimentionTwo = a.getDimension();
        if (dimensionOne[0] != dimentionTwo[0] || dimensionOne[1] != dimentionTwo[1])
            throw new MatrixException("Matrices must have the equal dimension!");
        Matrix result = new Matrix(dimensionOne[0], dimensionOne[1]);
        for (int row = 0; row < dimensionOne[0]; row++)
            for (int column = 0; column < dimensionOne[1]; column++)
                result.setValue(row, column, a.getValue(row, column) - getValue(row, column));
        return result;
    }

    public Matrix multiply(int number) throws MatrixException {
        var dimension = getDimension();
        Matrix result = new Matrix(dimension[0], dimension[1]);
        for (int row = 0; row < dimension[0]; row++) {
            for (int column = 0; column < dimension[1]; column++) {
                result.setValue(row, column, getValue(row, column) * number);
            }
        }
        return result;
    }

    public Matrix transpose() throws MatrixException {
        var dimension = getDimension();
        Matrix result = new Matrix(dimension[1], dimension[0]);
        for (int row = 0; row < dimension[0]; row++)
            for (int column = 0; column < dimension[1]; column++)
                result.setValue(column, row, getValue(row, column));
        return result;
    }

    public Matrix multiply(Matrix a) throws MatrixException {
        var dimensionOne = getDimension();
        var dimensionTwo = a.getDimension();
        if (dimensionOne[1] != dimensionTwo[0])
            throw new MatrixException("The number of columns of the first matrix does not match the number of rows of the second!");
        Matrix result = new Matrix(dimensionOne[0], dimensionTwo[1]);
        for (int row = 0; row < dimensionOne[0]; row++)
            for (int column = 0; column < dimensionTwo[1]; column++) {
                // внутренним циклом находим скалярное произведение row-строчки первой матрицы и column-столбцом второй матрицы.
                int res = 0;
                for (int index = 0; index < dimensionOne[1]; index++)
                    res += getValue(row, index) * a.getValue(index, column);

                result.setValue(row, column, res);
            }
        return result;
    }

    public Matrix exp(int degree) throws MatrixException {
        if (degree < 1)
            throw new MatrixException("Degree must be greater than zero.");
        var result = this;
        for (int i = 1; i < degree; i++)
            result = multiply(result);
        return result;
    }
}

class MatrixException extends Exception{
    public MatrixException(String message) {
        super(message);
    }
}
