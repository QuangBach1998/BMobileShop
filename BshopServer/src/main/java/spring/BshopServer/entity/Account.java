package spring.BshopServer.entity;

import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Integer id;

    @Column(name = "username", length = 50, unique = true, nullable = false, updatable = false)
    private String username;

    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Formula("concat(first_name,' ',last_name)")
    private String fullName;

    @Column(name = "role", length = 8, nullable = false)
    @Enumerated(value = EnumType.STRING)
    @ColumnDefault("'EMPLOYEE'")
    private Role role = Role.EMPLOYEE;

    public enum Role {
        ADMIN, EMPLOYEE, MANAGER
    }

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDate createdDate;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDate updatedAt;
}
