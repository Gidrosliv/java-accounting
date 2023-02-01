import java.util.Scanner;

/**
 * Главный класс. Точка входа в программу. Разворачивает поьзовательское меню.
 *
 * @author Denis Shurakov
 * @version 1.2
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в бухгалтерское приложение!");
        System.out.println("Введите команду, чтобы продолжить");

        int command;
        Engine engine = new Engine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            command = scanner.nextInt();

            switch (command) {
                case (1):
                    engine.inputMonthReport();
                    break;
                case (2):
                    engine.inputYearReport();
                    break;
                case (3):
                    engine.compare();
                    break;
                case (4):
                    engine.getMonthReport();
                    break;
                case (5):
                    engine.getYearReport();
                    break;
                case (0):
                    System.out.println("До новых встреч");
                    scanner.close();
                    return;
                default:
                    System.out.println("Такой команды не существует.");
            }
        }
    }

    /**
     * Метод выводит главное меню на экран.
     */
    private static void printMenu() {
        System.out.println();
        System.out.println("Выберите действие ");
        System.out.println();
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }

}
