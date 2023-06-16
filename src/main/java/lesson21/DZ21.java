package lesson21;

import lesson16.Person;
import lesson16.PersonApi;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class DZ21 {
    public static void main(String[] args) {
        List<Person> personFromApi = PersonApi.getPersonfromApi(10);
        for (Person person : personFromApi) {
            System.out.println(person);
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");

        //Лист Женщин
        List<Person> female = personFromApi.stream()
                .filter(person -> person.getGender().equals("female"))
                .toList();
        female.forEach(System.out::println);

        //Cамая взрослая женщина
        System.out.println("Самая взрослая женщина");
        int maxAgeFemale = female.stream().mapToInt(Person::getAge).max().getAsInt();
        for (Person person1 : female) {
            if (person1.getAge() == maxAgeFemale) {
                System.out.println(person1);
            }
        }


        //Cамая молодая женщина
        System.out.println("Самая молодая женщина");
        int minAgeFemale = female.stream().mapToInt(Person::getAge).min().getAsInt();
        for (Person person1 : female) {
            if (person1.getAge() == minAgeFemale) {
                System.out.println(person1);
            }
        }


        //Количествов списке
        System.out.println("Количество женщин в списке");
        System.out.println(female.stream().distinct().count());


        //Средний возраст
        System.out.println("Средний возраст женщин");
        female.stream().mapToInt(Person::getAge).average().ifPresent(System.out::println);

        //Сумма возростов женщин
        System.out.println("Сумма возростов женщин");
        female.stream().map(Person::getAge)
                .reduce((acc, x) -> (acc + x)).ifPresent(System.out::println);


        //Лист Мужчин
        List<Person> male = personFromApi.stream()
                .filter(person -> person.getGender().equals("male"))
                .toList();

        //Cамый взрослый мужчина
        System.out.println("Самый взрослый мужчина");
        int maxAgeMale = male.stream().mapToInt(Person::getAge).max().getAsInt();
        for (Person person1 : male) {
            if (person1.getAge() == maxAgeMale) {
                System.out.println(person1);
            }
        }


        //Cамый молодой мужчина
        System.out.println("Самый молодой мужчина");
        int minAgeMale = male.stream().mapToInt(Person::getAge).min().getAsInt();
        for (Person person1 : male) {
            if (person1.getAge() == minAgeMale) {
                System.out.println(person1);
            }
        }


        //Количествов списке
        System.out.println("Количество мужчин в списке");
        System.out.println(male.stream().distinct().count());


        //Средний возраст
        System.out.println("Средний возраст мужчин");
        male.stream().mapToInt(Person::getAge).average().ifPresent(System.out::println);

        //Сумма возростов женщин
        System.out.println("Сумма возростов мужчин");
        male.stream().map(Person::getAge)
                .reduce((acc, x) -> (acc + x)).ifPresent(System.out::println);


    }
}
