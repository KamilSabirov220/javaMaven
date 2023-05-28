package lesson16;

public class Main {
    public static void main(String[] args) {
        Person personFromApi = PersonApi.getPersonfromApi();
        System.out.println(personFromApi);

        ///System.out.println(System.getProperty("java.home"));

    }
}
