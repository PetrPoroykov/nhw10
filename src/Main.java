import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Address, Integer> costPerAddress = new HashMap<>();

        costPerAddress.put(new Address("Russia", "MSK "), 10);
        costPerAddress.put(new Address("Russia", "SPB"), 20);
        costPerAddress.put(new Address("Russia", "KZN"), 30);
        costPerAddress.put(new Address("USA", "NY"), 100);
        costPerAddress.put(new Address("FRA", "PRS"), 300);

        Scanner scanner = new Scanner(System.in);

        int totalCost = 0;

        Set<String> countriesOfDelivery = new HashSet<>();

        while (true) {
            System.out.println("""
                    Нажмите Enter для того чтобы ввести новый заказ
                    или наберите end и Enter для того чтобы завершить работу
                    """);
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            System.out.println("Заполнение нового заказа.");
            System.out.print("Введите страну: ");
            String country = scanner.nextLine();
            System.out.print("Введите город: ");
            String city = scanner.nextLine();
            System.out.print("Введите вес (кг):  ");
            String weight = scanner.nextLine();

            Address addresDel = new Address(country, city);

            if (costPerAddress.containsKey(addresDel)) {
                int shippingCost = costPerAddress.get(addresDel) * Integer.parseInt(weight);
                totalCost += shippingCost;
                System.out.println("Стоимость доставки составит: " + shippingCost + " руб.");
                countriesOfDelivery.add(country);
            } else {
                System.out.println("Доставки по этому адресу нет");
            }
            System.out.println("Общая стоимость всех доставок: " + totalCost + " руб.");
            System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        }
        System.out.println("Общая стоимость всех доставок: " + totalCost + " руб.");
        System.out.println("Kоличество уникальных стран  куда были оформлены доставки " + countriesOfDelivery.size());
        System.out.println("Программа завершена!");
    }
}

