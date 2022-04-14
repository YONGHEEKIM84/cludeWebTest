package pnp.cluoudWebStudy.cluoudWeb.domain;

import lombok.Getter;
import pnp.cluoudWebStudy.cluoudWeb.dto.UserForm;

import javax.persistence.*;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long user_id;

    @Column(length = 20, nullable = false)
    private String code;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String password;

    public User(UserForm userForm) {
        this.code = userForm.getCode();
        this.email = userForm.getEmail();
        this.name = userForm.getName();
        this.password = userForm.getPassword();
    }

    public static User createUser(UserForm userForm){
        return new User(userForm);
    }

}
