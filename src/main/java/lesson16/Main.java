package lesson16;

import java.util.List;

public class Main {
    public static void main(String[] args) {
///        Person personFromApi = PersonApi.getPersonfromApi();
///        System.out.println(personFromApi);

        ///System.out.println(System.getProperty("java.home"));

        List<Person> personFromApi = PersonApi.getPersons(5);
        for (Person person : personFromApi) {
            System.out.println(person);
        }
    }
}
