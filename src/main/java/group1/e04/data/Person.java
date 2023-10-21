package group1.e04.data;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {

    private String id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private List<String> courseIds;

    public void addCourse(String courseId) {
        this.courseIds.add(courseId);
    }

    public void removeCourse(String courseId) {
        this.courseIds.remove(courseId);
    }
}
