import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Address, Integer> costPerAddress = new HashMap<>();

        costPerAddress.put(new Address("Russia", "Moskow"), 10);
        costPerAddress.put(new Address("Russia", "Spb"), 20);
        costPerAddress.put(new Address("Russia", "Kazan"), 30);
        costPerAddress.put(new Address("USA", "NY"), 100);

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
            int shippingCost;
            boolean flag = true;

            System.out.println("Заполнение нового заказа.");
            System.out.print("Введите страну: ");
            String country = scanner.nextLine();
            System.out.print("Введите город: ");
            String city = scanner.nextLine();
            Address deliveryAddress = new Address(country, city);
            System.out.print("Введите вес (кг):  ");
            String weightString = scanner.nextLine();
            int weight = Integer.parseInt(weightString);

            for (Map.Entry<Address, Integer> addressIntegerEntry : costPerAddress.entrySet()) {
                if (addressIntegerEntry.getKey().equals(deliveryAddress)) {
                    shippingCost = addressIntegerEntry.getValue() * weight;
                    countriesOfDelivery.add(country);
                    System.out.println("Стоимость доставки составит: " + shippingCost + " руб.");
                    totalCost += shippingCost;
                    flag = false;
                    break;
                }
            }
            if (flag) System.out.println("Доставки по этому адресу нет");
            System.out.println("Общая стоимость всех доставок: " + totalCost + " руб.");
            System.out.println("Kоличество уникальных стран были оформлены доставки " + countriesOfDelivery.size());

            System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        }
        System.out.println("Программа завершена!");
    }
}

