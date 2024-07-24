package xyz.daffarandika.note_api.auth.model;

import jakarta.persistence.*;
import lombok.*;
import xyz.daffarandika.note_api.auth.dto.SignupRequest;

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

    @Column(unique = true)
    private String username;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private Date createdAt;

    @Column
    private Date deletedAt;

    @Column
    private String roles;

    public User(String username, String name, String email, String password, Date createdAt, String roles) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.roles = roles;
    }

    public User(SignupRequest request) {
        this.username = request.getUsername();
        this.name = request.getName();
        this.email = request.getEmail();
        this.password = request.getPassword();
        this.createdAt = request.getCreatedAt();
        this.roles = request.getRoles();
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
