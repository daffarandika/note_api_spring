package xyz.daffarandika.note_api.auth.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "users_id_seq", allocationSize = 1)
    private Integer id;

    private String username;

    private String name;

    private String email;

    private String password;

    private Date createdAt;

    private Date deletedAt;

    private String roles;

    public User(String username, String name, String email, String password, Date createdAt, String roles) {
        System.out.println("<=> NEW USER");
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.roles = roles;
    }

    public User() {}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
