package pw2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Human> people = new ArrayList<>();
        people.add(new Human(40, "Anya", "Kruglova", LocalDate.of(2002, 12, 29), 45));
        people.add(new Human(19, "Dasha", "Krendikova", LocalDate.of(2004, 1, 31), 47));
        people.add(new Human(56, "Dimas", "Ivanov", LocalDate.of(1956, 10, 11), 103));
        people.add(new Human(31, "Igor", "Ivanova", LocalDate.of(1955, 2, 24), 31));

        System.out.println("Список: ");
        Stream<Human> stream = people.stream();
        stream.forEach(System.out::println);

        System.out.println("Сортировка по имени в обратном порядке: ");
        Stream<Human> stream1 = people.stream();
        stream1.sorted(Comparator.comparing(Human::getFirstName).reversed()).forEach(System.out::println);

        System.out.println("Фильтрация по возрасту больше, чем 20: ");
        Stream<Human> stream2 = people.stream();
        stream2.filter(human -> human.getAge() > 20).forEach(System.out::println);

        System.out.println("Выбор первых трех элементов списка: ");
        Stream<Human> stream3 = people.stream();
        stream3.limit(3).forEach(System.out::println);

        System.out.println("Конкатенация имен в строку: ");
        Stream<Human> stream4 = people.stream();
        String str=stream4.map(Human::getFirstName).reduce("", (a,b) -> (a+" "+b).trim());
        System.out.println(str);
    }
}
