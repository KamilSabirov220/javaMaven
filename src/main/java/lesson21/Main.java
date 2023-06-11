package lesson21;

import lesson16.Person;
import lesson16.PersonApi;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> list = PersonApi.getPersonfromApi(10);
        for (Person person : list) {
            System.out.println(person);
        }
        System.out.println("--------------------------------------------------------------------------------------------");

    }
}
