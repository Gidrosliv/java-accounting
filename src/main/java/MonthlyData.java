/**
 * Класс хранит инфомрацию о конкретной трате, конкретного месяца.
 * Свойства: <b>name</b>,  <b>isExpense</b>, <b>qnty</b>,  <b>price</b>.
 */
public class MonthlyData {
    /**
     * Поле имя
     */
    private String name;
    /**
     * Поле доход/расход
     */
    private boolean isExpense;
    /**
     * Поле количество
     */
    private int qnty;
    /**
     * Поле цены
     */
    private int price;


    /**
     * Конструктор - создание нового объекта с определенными значениями трат.
     *
     * @param name      - производитель.
     * @param isExpense - трата/расход.
     * @param qnty      - количество.
     * @param price     - цена.
     */
    public MonthlyData(String name, boolean isExpense, int qnty, int price) {
        this.name = name;
        this.isExpense = isExpense;
        this.qnty = qnty;
        this.price = price;
    }

    /**
     * Метод возвращает поле name.
     *
     * @return Метод возвращает поле name, в формате String.
     */
    public String getName() {
        return name;
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
     * Метод возвращает поле  Qnty(количество).
     *
     * @return Метод возвращает поле Qnty, в формате int.
     */
    public int getQnty() {
        return qnty;
    }

    /**
     * Метод возвращает поле price(цена).
     *
     * @return Метод возвращает поле price, в формате int.
     */
    public int getPrice() {
        return price;
    }

}