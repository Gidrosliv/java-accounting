import java.util.ArrayList;
import java.util.HashMap;

/**
 * Класс движоек системы, который считывает отчеты из папки /resources.
 * Свойства: <b>monthReports</b>,  <b>yearReports</b>.
 */
public class Engine {
    /**
     * monthReports хранит информацию о считанных отчетах.
     */
    private HashMap<Integer, ArrayList<MonthlyData>> monthReports = new HashMap<>();
    /**
     * yearReports хранит информацию о  годовых отчетах.
     */
    private HashMap<Integer, ArrayList<YearlyData>> yearReports = new HashMap<>();


    /**
     * Метод считывания месячных отчетов в monthReports. По условиям ТЗ - работаем только с 3-мя месацами.
     */
    public void inputMonthReport() {
        for (int i = 1; i < 4; i++) {
            String month = FileReader.readFileContentsOrNull("resources/m.20210" + i + ".csv");

            if (month != null) {
                monthReports.put(i, FileReader.splitMonthRow(month));
            } else {
                System.err.println("Возможно файл  был поврежден");
                return;
            }
        }
        System.out.println("Готово. Месячные отчеты считаны. Что дальше?");
    }

    /**
     * Метод считывания годового отчета в yearReports. По условиям ТЗ - работаем только в пределах одного года.
     */
    public void inputYearReport() {
        String year = FileReader.readFileContentsOrNull("resources/y.2021.csv");

        if (year != null) {
            yearReports.put(2021, FileReader.splitYearRow(year));
        } else {
            System.err.println("Возможно файл  был поврежден");
        }
        System.out.println("Готово. Годовые отчеты считаны. Что дальше?");
    }

    /**
     * Метод cравнения месячных отчетов с годовым.
     */
    public void compare() {
        if (monthReports.isEmpty() || yearReports.isEmpty()) {
            System.err.println("Считайте все месячные и годовой отчет.");
            return;
        }

        int montExpenses = countMonthExp();
        int monthIncomes = countMonthInc();
        int yearExpenses = countYearExp();
        int yearIncomes = countYearInc();

        if (montExpenses != yearExpenses) {
            System.err.println("Опачки.Ошибка в разделе трат. Обратите внимание на месяц:" + getNameMonth(1));
        }

        if (monthIncomes != yearIncomes) {
            System.err.println("Опачки.Ошибка в разделе Расходов. Обратите внимание на месяц:" +
                    getNameMonth(1));
        }
        System.out.println("Сверка произведена успешно. Ошибок не найдено");
    }


    /**
     * Метод суммирует расходы по месяцам за весь год.
     *
     * @return Возвращает сумму расходов за все месяцы, в формате целого числа.
     */
    public int countYearExp() {
        int sumYearExp = 0;

        for (ArrayList<YearlyData> report : yearReports.values()) {
            for (YearlyData parametrs : report) {
                if (parametrs.isExpense()) {
                    sumYearExp = sumYearExp + parametrs.getAmount();
                }
            }
        }
        return sumYearExp;
    }

    /**
     * Метод суммирует доходы по месяцам за весь год.
     *
     * @return Возвращает сумму дохода, в формате целого числа.
     */
    public int countYearInc() {
        int yearInc = 0;

        for (ArrayList<YearlyData> report : yearReports.values()) {
            int monthIncome;

            for (YearlyData parametrs : report) {
                if (!parametrs.isExpense()) {
                    monthIncome = parametrs.getAmount();
                    yearInc = yearInc + monthIncome;
                }
            }
        }
        return yearInc;
    }

    /**
     * Метод считает траты по месяцам.
     *
     * @return Возаращает сумму трат за все доступные месяцы, в формате целого числа.
     */
    public int countMonthExp() {
        int montExp = 0;

        for (ArrayList<MonthlyData> report : monthReports.values()) {

            int sumExp = 0;
            int sum;
            for (MonthlyData param : report) {
                if (param.isExpense()) {
                    sum = param.getQnty() * param.getPrice();
                    sumExp = sum + sumExp;
                }
            }
            montExp = montExp + sumExp;
        }
        return montExp;
    }

    /**
     * Метод считает доходы по месяцам и суммирует их.
     *
     * @return Возвращает значение данных по месяцам, в формате целого числа.
     */
    public int countMonthInc() {
        int monthInc = 0;

        for (ArrayList<MonthlyData> report : monthReports.values()) {
            int sumInc = 0;
            int sum;
            for (MonthlyData param : report) {
                if (!param.isExpense()) {
                    sum = param.getQnty() * param.getPrice();
                    sumInc = sum + sumInc;
                }
            }
            monthInc = monthInc + sumInc;
        }
        return monthInc;
    }

    /**
     * Метод выводит месячный отчет на экран.
     */
    public void getMonthReport() {
        if (monthReports.isEmpty()) {
            System.err.println("Cначала необходимо cчитать месячные отчеты.");
            return;
        }
        int count = 1;
        int temp;

        for (ArrayList<MonthlyData> parametr : monthReports.values()) {
            int maxVal = 0;
            int maxSpend = 0;
            int maxValueSpendSum = 0;
            String maxName = null;
            String maxSpendName = null;

            for (MonthlyData x : parametr) {
                if (x.isExpense()) {
                    temp = x.getQnty() * x.getPrice();
                    if (temp > maxVal) {
                        maxVal = temp;
                        maxName = x.getName();
                    }
                } else {
                    maxValueSpendSum = x.getQnty() * x.getPrice();
                    maxSpendName = x.getName();
                    if (maxValueSpendSum > maxSpend) {
                        maxSpend = maxValueSpendSum;
                        maxSpendName = x.getName();
                    }
                }
            }

            System.out.println();
            System.out.println("Месяц: " + getNameMonth(count));
            System.out.println("Cамый прибыльный товар: " + "\"" + maxSpendName + "\"" + " " + maxValueSpendSum +
                    " р.");
            System.out.println("Самая большая трата: " + "\"" + maxName + "\"" + " " + maxVal + " р.");
            count++;
        }
        System.out.println(" ");
        System.out.println("Готово.Что дальше?");

    }


    /**
     * Метод для конвертации цифры в название месяца.
     *
     * @param num целое число, которое необходимо соотнести с текстовым значением месяца.
     * @return Возвращает название месяца в формате String.
     */
    public String getNameMonth(int num) {
        switch (num) {
            case (1):
                return "Январь";
            case (2):
                return "Февраль";
            case (3):
                return "Март";
            default:
                return "такого месяца нет";
        }
    }

    /**
     * Выводит годовой отчёт, который включает:
     * - Рассматриваемый год.
     * - Прибыль по каждому месяцу. Прибыль это разность доходов и расходов.
     * - Средний расход за все месяцы в году.
     * - Средний доход за все месяцы в году.
     */
    public void getYearReport() {
        if (monthReports.isEmpty()) {
            System.err.println("Cначала необходимо считайть годовой отчет.");
            return;
        }
        int year = 2021;

        HashMap<Integer, Integer> expPerMonth = new HashMap<>();
        HashMap<Integer, Integer> profitPerMonth = new HashMap<>();

        System.out.println("Отчёт по " + year + " году");
        System.out.println(" ");


        for (ArrayList<YearlyData> yearlyData : yearReports.values()) {
            for (YearlyData y : yearlyData) {
                if (y.isExpense()) {
                    profitPerMonth.put(y.getMonth(), y.getAmount());
                } else {
                    expPerMonth.put(y.getMonth(), y.getAmount());
                }
            }
        }

        for (int i = 0; i < profitPerMonth.values().size(); i++) {
            System.out.println("Месяц: " + getNameMonth(i + 1) + ". Прибыль: " + profitPerMonth.get(i + 1) +
                    ". Расход: " + expPerMonth.get(i + 1));
            System.out.println();
        }
        System.out.println("Средний расход за все месяцы в году: " + (getAverageExpense(profitPerMonth) + " р."));
        System.out.println("Средний доход за все месяцы в году " + (getAverageIncome(expPerMonth)) + " р.");

        System.out.println(" ");
        System.out.println("Готово.Что дальше?");

    }


    /**
     * Поиск среднего значения в категории прибылл.
     *
     * @param forYear массив данных, включающий прибыль за месяц .
     * @return Возвращает среднее значение прибыли за месяц.
     */
    public int getAverageIncome(HashMap<Integer, Integer> forYear) {
        int avgDohod = 0;

        for (Integer param : forYear.values()) {
            avgDohod = avgDohod + param;
        }
        return avgDohod;
    }

    /**
     * Поиск среднего значения в категории траты.
     *
     * @param forYear массив данных, включающий траты за месяц .
     * @return Возвращает среднее значение трат за месяц.
     */
    private int getAverageExpense(HashMap<Integer, Integer> forYear) {
        int avgSpend = 0;

        for (Integer param : forYear.values()) {
            avgSpend = avgSpend + param;
        }
        return avgSpend;
    }
}
