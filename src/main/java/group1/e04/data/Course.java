package group1.e04.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private String id;
    private String name;
    private String credit;
    private String facultyName;
    private int maxStudent;
    private int currentStudent;
}
