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
public class Faculty extends Person {

    private String department;

    public Faculty(String id, String name, String address, String phone, String email, String department,
            List<String> courseIds) {
        super(id, name, address, phone, email, courseIds);
        this.department = department;
    }
}
