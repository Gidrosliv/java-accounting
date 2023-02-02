import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Класс считывающий данные из заданной папки.
 */
public class FileReader {
    /**
     * Метод считывающий данные из файла.
     *
     * @param path путь к папке с файслами.
     * @return возвращаем строку из считанных данных.
     */
    static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом." +
                    " Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    /**
     * Метод разбивает моно-строку с полученными значения в строковый массив.
     * Присваиваем данные экземпляру класса MonthlyData.
     *
     * @param someRow строка, которую необходимо разбить по делиметеру.
     * @return массив с данными, за конкретный месяц.
     */
    public static ArrayList<MonthlyData> splitMonthRow(String someRow) {
        ArrayList<MonthlyData> monthReports = new ArrayList<>();
        String[] lines = someRow.split("\n");

        for (int i = 1; i < lines.length; i++) {
            String line1 = lines[i];
            String[] lines2 = line1.split(",");
            MonthlyData monthRep = new MonthlyData(lines2[0], Boolean.parseBoolean(lines2[1]), Integer.parseInt(lines2[3]),
                    Integer.parseInt(lines2[2]));
            monthReports.add(monthRep);
        }
        return monthReports;
    }


    /**
     * Метод разбивает моно-строку с полученными значения в строковый массив.
     * Присваиваем данные экземпляру класса YearlyData.
     *
     * @param someRow строка, которую необходимо разбить по делиметеру.
     * @return массив с данными, за конкретный год.
     */
    public static ArrayList<YearlyData> splitYearRow(String someRow) {
        ArrayList<YearlyData> yearReports = new ArrayList<>();
        String[] lines = someRow.split("\n");

        for (int i = 1; i < lines.length; i++) {
            String line1 = lines[i];
            String[] lines2 = line1.split(",");
            YearlyData yearRep = new YearlyData(Integer.parseInt(lines2[0]), Integer.parseInt(lines2[1]),
                    Boolean.parseBoolean(lines2[2]));
            yearReports.add(yearRep);
        }
        return yearReports;
    }
}