package group1.e04.data;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Course {
    
    private String id;
    private String name;
    private String credit;
    private String facultyId;
    private List<String> studentIds;

    public Course(String id, String name, String credit, String faculty_id) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.facultyId = faculty_id;
    }
}
