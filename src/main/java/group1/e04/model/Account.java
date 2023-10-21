package group1.e04.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    
    private String username;
    private String password;
    private Role role;

    public enum Role {
        STUDENT, FACULTY, ADMIN;
    }
}
