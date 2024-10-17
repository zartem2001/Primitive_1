import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;
        menu();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1 -> {
                    System.out.println("Введите сумму дохода");
                    String earning = scanner.nextLine();
                    int money = Integer.parseInt(earning);
                    earnings += money;
                }
                case 2 -> {
                    System.out.println("Введите сумму расходов");
                    String spending = scanner.nextLine();
                    int spend = Integer.parseInt(spending);
                    spendings += spend;
                }
                case 3 -> {
                    int tax = taxEarningMinusSpending(earnings, spendings);
                    int tax2 = taxEarning(spendings);
                    if (tax <= tax2) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + tax + " рублей ");
                        System.out.println("Налог на другой системе: " + tax2);
                        System.out.println("Экономия: " + (tax2 - tax) + " рублей ");
                    } else {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + tax2 + " рублей ");
                        System.out.println("Налог на другой системе: " + tax);
                        System.out.println("Экономия: " + (tax- tax2) + " рублей ");
                    }
                }
            }
        }

    }

    private static void menu() {
        System.out.println("Выберите операцию и введите её номер:");
        System.out.println("1. Добавить новый доход");
        System.out.println("2. Добавить новый расход");
        System.out.println("3. Выбрать систему налогообложения");
        System.out.println("Введите `end` для завершения программы");
    }

    private static int taxEarningMinusSpending(int earning, int spending) {
        int tax = (earning - spending) * 15 / 100;
        return Math.max(tax, 0);
    }

    private static int taxEarning(int earning) {
        int tax = earning * 6 / 100;
        return Math.max(tax, 0);
    }
}