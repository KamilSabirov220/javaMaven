package lesson20;

import lesson16.Person;
import lesson16.PersonApi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Person> personFromApi = PersonApi.getPersonfromApi(10);
        for (Person person : personFromApi) {
            System.out.println(person);
        }
        System.out.println("--------------------------------------------------------------------------------------------");

/*        List<Person> russian = personFromApi.stream().filter(person -> person.getCountry().equals("Russian"))
                .collect(Collectors.toList());

        List<Integer> collect = personFromApi.stream()
                .map(person -> person.getUserName().length())
                .collect(Collectors.toList());*/

        System.out.println("Женщины старше 20 лет");
        personFromApi.stream().filter(person -> person.getGender().equals("female"))
                .filter(p -> LocalDateTime.now().getYear() - p.getDate().getYear() > 20)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Мужчины младше 18 лет с указанием ФИО и даты рождения");
        List<MaleUnder18> maleUnder = personFromApi.stream()
                .filter(person -> person.getGender().equals("male"))
                .filter(person -> LocalDateTime.now().getYear() - person.getDate().getYear() < 18)
                .map(person -> new MaleUnder18(person.getName(),
                person.getLastName(), person.getDate()))
                .toList();
        maleUnder.forEach(System.out::println);

        System.out.println();

        System.out.println("Люди старше 50 лет");
        List<Person> overFifty = personFromApi.stream().filter(person ->
                        LocalDateTime.now().getYear() - person.getDate().getYear() > 50)
                .toList();
        overFifty.forEach(System.out::println);

        System.out.println();

        System.out.println("Длина ФИО меньше 30 символов");
        List<Person> nameLength = new ArrayList<>();
        for (Person person : personFromApi) {
            if (person.getName().length() + person.getLastName().length() < 30) {
                nameLength.add(person);
            }
        }
        nameLength.forEach(System.out::println);

    }


}

