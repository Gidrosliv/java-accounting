/**
 * Класс хранит инфомрацию о конкретной трате, конкретного месяца.
 * Свойства: <b>name</b>,  <b>isExpense</b>, <b>qnty</b>,  <b>price</b>.
 */
public class MonthlyData {
    /**
     * Поле имя
     */
    String name;
    /**
     * Поле доход/расход
     */
    boolean isExpense;
    /**
     * Поле количество
     */
    int qnty;
    /**
     * Поле цены
     */
    int price;


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

}