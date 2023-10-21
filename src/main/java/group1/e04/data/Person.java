package group1.e04.data;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Person {

    private String id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private List<String> courseIds;

    public Person(String id, String name, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public void addCourse(String id) {
        this.courseIds.add(id);
    }

    public void removeCourse(String id) {
        this.courseIds.remove(id);
    }
}
