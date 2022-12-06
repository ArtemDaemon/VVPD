public final class Constants {
    private Constants() {}

    //----------------------------------------------------------------
    //Сообщения
    //----------------------------------------------------------------
    static final String ROWS_MESSAGE = "Введите количество строк матрицы";
    static final String COLS_MESSAGE = "Введите количество столбцов матрицы";
    static final String MULTI_ERROR_MESSAGE = "Для умножения количество столбцов первой матрицы и " +
            "количество строк второй должны совпадать";
    static final String ADD_SUB_ERROR_MESSAGE = "Матрицы должны иметь одинаковую размерность";
    static final String INT_ERROR_MESSAGE = "Введите целое число!";
    static final String DOUBLE_ERROR_MESSAGE = "Введите число";
    static final String DIVIDER = "////////////////////////////////";
    static final String EQUALS_MESSAGE = "Матрицы равны";
    static final String NOT_EQUALS_MESSAGE = "Матрицы не равны";
    static final String EXIT_MESSAGE = "Удачи!";
    static final String INVALID_MENU_ITEM = "Выберите корректный пункт меню";
    static final String X_MESSAGE = "Введите число, на которое следует умножить матрицы";

    //----------------------------------------------------------------
    //Фильтры
    //----------------------------------------------------------------
    static final boolean POSITIVE_VALUE = true;
    static final boolean ANY_VALUE = false;

    //----------------------------------------------------------------
    //Меню
    //----------------------------------------------------------------
    static final int MENU_INPUT = 1;
    static final int MENU_TRANSPOSE = 2;
    static final int MENU_ADD = 3;
    static final int MENU_SUB = 4;
    static final int MENU_MULTI = 5;
    static final int MENU_EQUALS = 6;
    static final int MENU_MULTI_X = 7;
    static final int MENU_EXIT = 0;
}
