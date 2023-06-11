package lesson21;

import lesson16.Person;
import lesson16.PersonApi;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public class DZ21 {
    public static void main(String[] args) {
        List<Person> personFromApi = PersonApi.getPersonfromApi(10);
        for (Person person : personFromApi) {
            System.out.println(person);
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");

        //Лист Женщин
        List<Person> famale = personFromApi.stream()
                .filter(person -> person.getGender().equals("famale"))
                .toList();
        famale.forEach(System.out::println);

        //Количество


        //Средний возраст


        //Лист Мужчин
        List<Person> male = personFromApi.stream()
                .filter(person -> person.getGender().equals("male"))
                .toList();



    }
}
