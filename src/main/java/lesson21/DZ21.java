package lesson21;

import lesson16.Person;
import lesson16.PersonApi;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
        System.out.print("Cамой взрослой женщине "
                + female.stream().mapToInt(Person::getAge).max()
                + "лет");


        //Cамая молодая женщина
        System.out.print("Cамой молодой женщине "
                + female.stream().mapToInt(Person::getAge).min()
                + "лет");


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
        System.out.print("Cамому взрослому мужчине "
                + male.stream().mapToInt(Person::getAge).max()
                + "лет");


        //Cамый молодой мужчина
        System.out.print("Cамому молодому мужчине "
                + male.stream().mapToInt(Person::getAge).min()
                + "лет");


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
