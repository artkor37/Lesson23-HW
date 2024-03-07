import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private static final String CORRECT_NUMBER = "[\\d()+ -]+";
    private static boolean isContinue = false;
    private static final Set<String> phone = new TreeSet<>();

    public static void main(String[] args) {
        System.out.println("\t*** Программа сохранения телефонных номеров ***" +
                "\nВводите номер в 11-значном или 10-значном формате." +
                "\nКоманда \"print\" распечатывает список номеров, команда \"stop\" завершает работу программы.");

        while (!isContinue) {
            System.out.print("\nВведите номер или команду: ");
            String input = new Scanner(System.in).nextLine().trim();
            inputCheck(input);
        }
    }

    public static void inputCheck(String input) {
        if (input.matches(CORRECT_NUMBER)) {
            String number = input.replaceAll("\\D+", "").trim();
            numberReplace(number);
        } else if (input.equalsIgnoreCase("stop")) {
            System.out.println("Bye-bye");
            isContinue = true;
        } else if (input.equalsIgnoreCase("print")) {
            printAll();
        } else {
            wrongInput();
        }
    }

    public static void add(String phoneNumber) {
        if (phone.contains(phoneNumber)) {
            System.out.println("Номер " + phoneNumber + " уже есть в базе.");
        } else {
            phone.add(phoneNumber);
            System.out.println("Номер " + phoneNumber + " успешно добавлен.");
        }
    }


    public static void numberReplace(String number) {
        if (number.length() == 11 && (number.charAt(0) == '7' || number.charAt(0) == '8')) {
            String phoneNumber = number.replaceAll("(^\\d)(\\d{3})(\\d{3})(\\d{2})(\\d{2})", "+7($2)$3-$4-$5");//number.replaceAll("^\\d", "");
            add(phoneNumber);
        } else if (number.length() == 10) {
            String phoneNumber = number.replaceAll("(\\d{3})(\\d{3})(\\d{2})(\\d{2})", "+7($1)$2-$3-$4");
            add(phoneNumber);
        } else wrongInput();
    }

    public static void printAll() {
        if (phone.isEmpty()) {
            System.out.println("Список пуст!");
            return;
        }
        for (String number : phone) {
            System.out.println("\t" + number);
        }
    }

    public static void wrongInput() {
        System.out.println("Неверный ввод!");
    }

   /* public static void numberValid() {
        isValid = true;
        numCount = 0;
        for (int i = 0; i < phone.length(); i++) {
            if (!CORRECT_NUMBER.contains(String.valueOf(phone.charAt(i)))) {
                isValid = false;
                break;
            }
        }
    }*/

}
