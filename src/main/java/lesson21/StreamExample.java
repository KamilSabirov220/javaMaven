package lesson21;

import lesson16.Person;
import lesson16.PersonApi;

import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Person> personFromApi = PersonApi.getPersonfromApi(10);
        for (Person person : personFromApi) {
            System.out.println(person);
        }
        System.out.println("--------------------------------------------------------------------------------------------");

        //personFromApi.stream().sorted((o1, o2

    }
}

