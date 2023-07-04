package spring.BshopServer.dto;

import lombok.Data;
import spring.BshopServer.entity.Account;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class AccountDTO {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private Account.Role role;
    private LocalDate createdDate;
    private LocalDateTime updatedAt;
}
