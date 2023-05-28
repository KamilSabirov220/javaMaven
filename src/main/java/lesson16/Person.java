package lesson16;

import java.time.LocalDateTime;
import java.util.Objects;

public class Person {
    private String name;
    private String lastName;
    private String country;
    private LocalDateTime date;
    private String userName;
    private String password;

    public Person() {
    }

    public Person(String name, String lastName, String country, LocalDateTime date, String userName, String password) {
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.date = date;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!Objects.equals(name, person.name)) return false;
        if (!Objects.equals(lastName, person.lastName)) return false;
        if (!Objects.equals(country, person.country)) return false;
        if (!Objects.equals(date, person.date)) return false;
        if (!Objects.equals(userName, person.userName)) return false;
        return Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", date=" + date +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
