/**
 * Класс хранит инфомрацию о информацию о годе.
 * Свойства: <b>month</b>,  <b>amount</b>, <b>isExpense</b>.
 */
public class YearlyData {
    /**
     * Поле месяц.
     */
    int month;
    /**
     * Поле сумма.
     */
    int amount;
    /**
     * Поле доход/расход.
     */
    boolean isExpense;


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
}