package lesson16;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
        ///дополнить поля


    return res;
    }
}
