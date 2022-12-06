import java.util.Scanner;

public class Main {

    //Главное меню
    static final String[] MAIN_MENU = {
            "1 - Ввод матриц",
            "2 - Транспонирование первой матрицы",
            "3 - Сложение матриц",
            "4 - Вычитание второй матрицы из первой",
            "5 - Умножение матриц",
            "6 - Проверка равенства матриц",
            "7 - Умножение всех элементов первой матрицы на число",
            "0 - Выход из программы"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuKey;
        Matrix result;
        Matrix matrix1 = createMatrix(scanner);
        Matrix matrix2 = createMatrix(scanner);

        do {
            for (String menuItem : MAIN_MENU) System.out.println(menuItem);
            matrix1.display();
            System.out.println(Constants.DIVIDER);
            matrix2.display();
            menuKey = getInt(scanner, Constants.ANY_VALUE);
            try {
                switch (menuKey) {
                    case Constants.MENU_INPUT:
                        matrix1 = createMatrix(scanner);
                        matrix2 = createMatrix(scanner);
                        break;
                    case Constants.MENU_TRANSPOSE:
                        matrix1 = matrix1.transpose();
                        break;
                    case Constants.MENU_ADD:
                        result = matrix1.add(matrix2);
                        result.display();
                        break;
                    case Constants.MENU_SUB:
                        result = matrix1.sub(matrix2);
                        result.display();
                        break;
                    case Constants.MENU_MULTI:
                        result = matrix1.multi(matrix2);
                        result.display();
                        break;
                    case Constants.MENU_EQUALS:
                        if (matrix1.equals(matrix2)) System.out.println(Constants.EQUALS_MESSAGE);
                        else System.out.println(Constants.NOT_EQUALS_MESSAGE);
                        break;
                    case Constants.MENU_MULTI_X:
                        System.out.println(Constants.X_MESSAGE);
                        double x = getDouble(scanner);
                        matrix1.multiX(x);
                        break;
                    case Constants.MENU_EXIT:
                        System.out.println(Constants.EXIT_MESSAGE);
                        break;
                    default:
                        System.out.println(Constants.INVALID_MENU_ITEM);
                }
            }
            catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

        }
        while (menuKey != Constants.MENU_EXIT);
    }

    /**
     * Метод для создания матрицы
     * @param scanner Объект класса Scanner для ввода
     * @return Созданный объект класса Matrix
     */
    static Matrix createMatrix(Scanner scanner) {
        System.out.println(Constants.ROWS_MESSAGE);
        int rows = getInt(scanner, Constants.POSITIVE_VALUE);
        System.out.println(Constants.COLS_MESSAGE);
        int columns = getInt(scanner, Constants.POSITIVE_VALUE);
        double[][] values = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("Элемент [%d][%d]: ", i + 1, j + 1);
                values[i][j] = getDouble(scanner);
            }
        }
        return new Matrix(values);
    }

    //----------------------------------------------------------------
    //Служебные методы
    //----------------------------------------------------------------

    /**
     * Метод для получения целочисленного значения
     * @param scanner Объект класса Scanner для ввода
     * @param isPositive Требование для получения только положительных чисел (true/false)
     * @return Целое число
     */
    static int getInt(Scanner scanner, boolean isPositive) {
        String input;
        while (!isValidInt(input = scanner.nextLine(), isPositive)) {
            System.out.println(Constants.INT_ERROR_MESSAGE);
        }
        return Integer.parseInt(input);
    }

    /**
     * Метод для проверки корректности полученного значения
     * @param line Строка, содержащая полученное значение
     * @param isPositive Требование для получения только положительных чисел (true/false)
     * @return Результат проверки корректности полученного значения
     */
    static boolean isValidInt(String line, boolean isPositive) {
        try {
            int result = Integer.parseInt(line);
            return (!isPositive || (result > 0));
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Метод для получения значения с плавающей точкой
     * @param scanner Объект класса Scanner для ввода
     * @return Число с плавающей точкой
     */
    static double getDouble(Scanner scanner) {
        String input;
        while (!isDouble(input = scanner.nextLine())) {
            System.out.println(Constants.DOUBLE_ERROR_MESSAGE);
        }
        return Double.parseDouble(input);
    }

    /**
     * Метод для проверки корректности полученного значения
     * @param line Строка, содержащая полученное значение
     * @return Результат проверки корректности полученного значения
     */
    static boolean isDouble(String line) {
        try {
            Double.parseDouble(line);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}