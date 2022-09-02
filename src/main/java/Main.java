import java.util.Scanner;

class Main {

    public static int taxEarnindsMinusSpendings(int earnings, int spendings) {
        int dr = (earnings - spendings) * 15 / 100;
        if (dr >= 0) {
            return dr;
        } else {
            return 0;
        }
    }

    public static int taxEarninds(int earnings) {
        int d = earnings * 6 / 100;
        return d;
    }

    public static String name(String name) {
        return "Наименование компании для которой подбирается налоговая система: \n" + name;
    }

    public static void main(String[] args) {
        System.out.println(name("ООО РОМАШКА"));
        Scanner scanner = new Scanner(System.in);
        int earnings = 0; // доходы
        int spendings = 0; //расходы

        while (true) {
            System.out.println("Выберите операцию и введите ее номер : ");
            System.out.println("1. Добавить новый доход ");
            System.out.println("2. Добавить новый расход ");
            System.out.println("3. Выбрать систему налогооблажения");
            System.out.println("'end' - для завершения работы");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Ввудите сумму дохода");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Ввудите сумму расхода");
                    String moneyStr1 = scanner.nextLine();
                    int money1 = Integer.parseInt(moneyStr1);
                    spendings += money1;
                    break;
                case 3:
                    int d = taxEarninds(earnings);
                    int dr = taxEarnindsMinusSpendings(earnings, spendings);

                    if (d < dr) {
                        System.out.println("Мы советуем вам УСН дохоы ");
                        System.out.println("Ваш налог составит: " + d);
                        System.out.println("Налог на другой системе: " + dr);
                        System.out.println("Экономия: " + (dr - d) + "руб.\n");
                    } else if (d > dr) {
                        System.out.println("Мы советуем вам УСН дохоы -расходы ");
                        System.out.println("Ваш налог составит: " + dr);
                        System.out.println("Налог на другой системе: " + d);
                        System.out.println("Экономия: " + (d - dr) + "руб.\n");
                    } else {
                        System.out.println("Суммы налога равны, можно выбрать любую, " +
                                "либо добавьте еще показатели ля более корректного просчета! \n");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена ! ");
    }
}