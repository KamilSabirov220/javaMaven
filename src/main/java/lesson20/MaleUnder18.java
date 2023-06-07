package lesson20;

import java.time.LocalDateTime;
import java.util.Objects;

public class MaleUnder18 {
    private String name;
    private String lastName;
    private LocalDateTime date;

    public MaleUnder18(String name, String lastName, LocalDateTime date) {
        this.name = name;
        this.lastName = lastName;
        this.date = date;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaleUnder18 that = (MaleUnder18) o;

        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(lastName, that.lastName)) return false;
        return Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + " " + lastName + " " + date;
    }

}
