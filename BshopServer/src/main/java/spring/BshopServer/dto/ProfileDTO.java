package spring.BshopServer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDTO {
    private int id;
    private String username;
    private String fullName;
    private String role;
}
