public class Matrix {
    private int rows, cols;
    private double[][] values;

    /**
     * Конструктор класса из двумерного массива значений
     * @param values Двумерный массив значений
     */
    public Matrix(double[][] values) {
        this.rows = values.length;
        this.cols = values[0].length;
        this.values = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(values[i], 0, this.values[i], 0, cols);
        }
    }

    /**
     * Конструктор класса из значений количества строк и столбцов
     * @param rows Число строк
     * @param cols Число столбцов
     */
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.values = new double[rows][cols];
    }

    /**
     * Метод для форматированного вывода матрицы
     */
    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(values[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Метод для транспонирования матрицы
     * @return Транспонированная матрица
     */
    public Matrix transpose() {
        Matrix result = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.values[j][i] = this.values[i][j];
            }
        }
        return result;
    }

    /**
     * Метод для сложения двух матриц
     * @param matrix Матрица, с элементами которой необходимо сложить элементы текущей
     * @return Матрица - результат сложения
     * @throws RuntimeException Если размерность матриц различается
     */
    public Matrix add(Matrix matrix) throws RuntimeException {
        if (rows != matrix.rows || cols != matrix.cols) throw new RuntimeException(Constants.ADD_SUB_ERROR_MESSAGE);
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.values[i][j] = this.values[i][j] + matrix.values[i][j];
            }
        }
        return result;
    }

    /**
     * Метод для вычитания двух матриц
     * @param matrix Матрица, элементы которой необходимо вычесть из элементов текущей
     * @return Матрица - результат вычитания
     * @throws RuntimeException Если размерность матриц различается
     */
    public Matrix sub(Matrix matrix) throws RuntimeException {
        if (rows != matrix.rows || cols != matrix.cols) throw new RuntimeException(Constants.ADD_SUB_ERROR_MESSAGE);
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.values[i][j] = this.values[i][j] - matrix.values[i][j];
            }
        }
        return result;
    }

    /**
     * Метод для умножения матриц
     * @param matrix Матрица, на которую следует умножить текущую
     * @return Матрица - результат произведения
     * @throws RuntimeException Если число столбцов первой матрицы не совпадает с числом строк второй
     */
    public Matrix multi(Matrix matrix) throws RuntimeException {
        if (cols != matrix.rows) throw new RuntimeException(Constants.MULTI_ERROR_MESSAGE);
        Matrix result = new Matrix(rows, matrix.cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix.cols; j++) {
                for (int k = 0; k < cols; k++) {
                    result.values[i][j] += (values[i][k] * matrix.values[k][j]);
                }
            }
        }
        return result;
    }

    /**
     * Метод для сравнения двух матриц
     * @param matrix Матрица, с которой необходимо сравнить текущую
     * @return Результат сравнения
     */
    public boolean equals(Matrix matrix) {
        if (rows != matrix.rows || cols != matrix.cols) return false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (values[i][j] != matrix.values[i][j]) return false;
            }
        }
        return true;
    }

    /**
     * Метод для умножения текущей матрицы на число
     * @param x Число, на которое необходимо умножить каждый элемент матрицы
     */
    public void multiX(double x) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                values[i][j] = values[i][j] * x;
            }
        }
    }
}
