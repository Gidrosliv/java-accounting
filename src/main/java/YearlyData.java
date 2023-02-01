/**
 * Класс хранит инфомрацию о информацию о годе.
 * Свойства: <b>month</b>,  <b>amount</b>, <b>isExpense</b>.
 */
public class YearlyData {
    /**
     * Поле месяц.
     */
    private int month;
    /**
     * Поле сумма.
     */
    private int amount;
    /**
     * Поле доход/расход.
     */
    private boolean isExpense;


    /**
     * Конструктор - создание нового объекта с определенными значениями доходов/расходов за конкретный месяц в году.
     *
     * @param month     - месяц.
     * @param isExpense - трата/ расход.
     * @param amount    - сумма трат/доходов.
     */
    public YearlyData(int month, int amount, boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }

    /**
     * Метод возвращает поле  Amount(трата).
     *
     * @return Метод возвращает поле Amount, в формате int.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Метод возвращает поле isExpense(трата/доход).
     *
     * @return Метод возвращает поле isExpense, в формате boolean.
     */
    public boolean isExpense() {
        return isExpense;
    }

    /**
     * Метод возвращает поле month(месяц).
     *
     * @return Метод возвращает поле month, в формате int.
     */
    public int getMonth() {
        return month;
    }

}