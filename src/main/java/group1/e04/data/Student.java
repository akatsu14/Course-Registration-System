package group1.e04.data;


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

    public Student(String id, String name, String address, String phone, String email, String _class) {
        super(id, name, address, phone, email);
        this._class = _class;
    }
}
