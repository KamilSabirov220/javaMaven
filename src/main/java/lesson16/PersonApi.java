package lesson16;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class PersonApi {
    public static Person getPersonfromApi(){

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://randomuser.me/api"))
                .GET()
                .build();

        try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                Person person = parseJsonToPerson(response);
                return person;



        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Person parseJsonToPerson(HttpResponse<String> response ) {
        JSONObject object = new JSONObject(response.body())
                .getJSONArray("results").getJSONObject(0);
        Person res = new Person();
        res.setName(object.getJSONObject("name").getString("first"));
        res.setLastName(object.getJSONObject("name").getString("last"));
        res.setCountry(object.getJSONObject("location").getString("country"));
        res.setDate(LocalDateTime.from(ZonedDateTime.parse(object.getJSONObject("dob").getString("date"))));
        res.setUserName(object.getJSONObject("login").getString("username"));
        res.setPassword(object.getJSONObject("login").getString("password"));
        res.setGender(object.getString("gender"));

        return res;
    }

    public static List<Person > getPersonfromApi(int count){

        List<Person> persons = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://randomuser.me/api"))
                .GET()
                .build();

        try {
            for (int i = 0; i < count; i++) {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                Person person = parseJsonToPerson(response);
                persons.add(person);

            }
            return persons;



        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Person> getPersons(int count){

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(String.format("https://randomuser.me/api?results=%d", count)))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            List<Person> persons = jsonParser(response);
            return persons;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Person> jsonParser(HttpResponse<String> response ) {
        List<Person> person = new ArrayList<>();
        int count = new JSONObject(response.body())
                .getJSONObject("info").getInt("results");
        for (int i = 0; i < count; i++) {
            JSONObject object = new JSONObject(response.body())
                    .getJSONArray("results").getJSONObject(i);
            Person res = new Person();
            res.setName(object.getJSONObject("name").getString("first"));
            res.setLastName(object.getJSONObject("name").getString("last"));
            res.setCountry(object.getJSONObject("location").getString("country"));
            res.setDate(LocalDateTime.from(ZonedDateTime.parse(object.getJSONObject("dob").getString("date"))));
            res.setUserName(object.getJSONObject("login").getString("username"));
            res.setPassword(object.getJSONObject("login").getString("password"));

            person.add(res);
        }

        return person;
    }

}
