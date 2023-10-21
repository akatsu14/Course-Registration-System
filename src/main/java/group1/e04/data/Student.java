package group1.e04.data;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student extends Person {

    private String _class;

    public Student(String id, String name, String address, String phone, String email, String _class,
            List<Course> courses) {
        super(id, name, address, phone, email, courses);
        this._class = _class;
    }
}
