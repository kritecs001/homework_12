import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<Address, Integer> costPerAddress = new HashMap<>();
        costPerAddress.put(new Address("Россия", "Казань"), 5);
        costPerAddress.put(new Address("Россия", "Москва"), 15);
        costPerAddress.put(new Address("Россия", "Новосибирск"), 7);
        costPerAddress.put(new Address("Польша", "Варшава"), 78);
        costPerAddress.put(new Address("Польша", "Краков"), 80);
        costPerAddress.put(new Address("Германия", "Берлин"), 150);
        costPerAddress.put(new Address("Франция", "Париж"), 170);

        Set<String> countries = new HashSet<>();
        int totalCost = 0;

        while (true){
            System.out.println("Введите delivery или end");
            if (scanner.nextLine().equals("end")){
                break;
            } else{
                System.out.println("Заполнение нового заказа.");
                System.out.print("Введите страну: ");
                String country = scanner.nextLine();
                System.out.print("Введите город: ");
                String city = scanner.nextLine();
                System.out.print("Введите вес(кг): ");
                int weight = Integer.parseInt(scanner.nextLine());
                Address address = new Address(country,city);
                if (!costPerAddress.containsKey(address)){
                    System.out.println("Доставки по этому адресу нет");
                    continue;
                } else{
                    System.out.println("Стоимость доставки составит: " + weight * costPerAddress.get(address));
                    totalCost += weight * costPerAddress.get(address);
                    countries.add(country);
                    System.out.println("Общая стоимость всех доставок: " + totalCost);
                    System.out.println("Количество уникальных стран: " + countries.size());
                }
            }
        }
    }
}