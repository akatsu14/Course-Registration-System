package group1.e04.data;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {

    private String id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String department;
}
