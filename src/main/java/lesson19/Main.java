package lesson19;

import lesson16.Person;
import lesson16.PersonApi;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
//2 Изененияе

public class Main {
    public static void main(String[] args) {
        List<Person> persons = PersonApi.getPersons(5);
        for (Person person : persons) {
            System.out.println(person);
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
/*        LamdaExample.sortLamda(persons, new Predicato<Person>() {
            @Override
            public boolean test(Person person) {
                return LocalDateTime.now().getYear() - person.getDate().getYear() < 30;
            }
        });*/

        //Слева то что мы перадём (Person person)
        // -> - маг.стрелка
        //Справа результат

/*        LamdaExample.sortLamda(persons,
                (Person person) -> {return LocalDateTime.now().getYear() - person.getDate().getYear() < 30;});

        LamdaExample.sortLamda(persons, p -> LocalDateTime.now().getYear() - p.getDate().getYear() < 30);*/

        LamdaExample.sortLamda(persons, p -> p.getCountry().equals("Iran"),
                pp -> { pp.setCountry("QWE"); System.out.println(pp);},
                p-> p.length()
                    );
    }
}


interface Predicato<T> {
    boolean test(T t);
}

interface Consumerito<T> {
    void accept(T t);
}

class LamdaExample {
    public static void sortLamda(List<Person> list,
                                 Predicato<Person> p,
                                 Consumerito<Person> c,
                                 Function<String, Integer> f
                                ) {
        for (Person person : list) {
            if (p.test(person)) c.accept(person);
            f.apply(person.getCountry());
        }
    }
}
