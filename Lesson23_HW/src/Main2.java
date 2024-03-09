import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main2 {


    private static final String NUMBER_FORMAT_7 = "(^\\d)(\\d{3})(\\d{3})(\\d{2})(\\d{2})";
    private static final String NUMBER_FORMAT_8 = "(\\d{3})(\\d{3})(\\d{2})(\\d{2})";

    private static final Set<String> phone = new TreeSet<>();

    public static void main(String[] args) {
        System.out.println("\t*** Программа сохранения телефонных номеров ***" +
                "\nВводите номер в 11-значном или 10-значном формате." +
                "\nКоманда \"print\" распечатывает список номеров, команда \"stop\" завершает работу программы.");

        while (true) {
            System.out.print("\nВведите номер или команду: ");
            String input = new Scanner(System.in).nextLine();
            if (input.equalsIgnoreCase("stop")) {
                System.out.println("Bye-bye");
                return;
            } else if (input.equalsIgnoreCase("print")) {
                printAll();
            } else {
                numberReplace(input);
            }
        }
    }

    public static void add(String phoneNumber) {
        if (phone.contains(phoneNumber)) {
            System.out.println("Номер " + phoneNumber + " уже есть в базе.");
            return;
        }
        phone.add(phoneNumber);
        System.out.println("Номер " + phoneNumber + " успешно добавлен.");

    }

    public static void numberReplace(String input) {
        String number = input.replaceAll("\\D+", "").trim();
        if (number.length() == 11 && (number.charAt(0) == '7' || number.charAt(0) == '8')) {
            String phoneNumber = number.replaceAll(NUMBER_FORMAT_7, "+7($2)$3-$4-$5");
            add(phoneNumber);
        } else if (number.length() == 10) {
            String phoneNumber = number.replaceAll(NUMBER_FORMAT_8, "+7($1)$2-$3-$4");
            add(phoneNumber);
        } else {
            System.out.println("Неверный ввод!");
        }
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