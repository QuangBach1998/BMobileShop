package spring.BshopServer.form;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import spring.BshopServer.validation.AccountExistsByUsername;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class AuthChangePasswordForm {
    @NotBlank(message = "{AccountForm.username.NotBlank}")
    @Length(max = 50, message = "{AccountForm.username.Length}")
    @AccountExistsByUsername
    private String username;

    @NotBlank(message = "{AccountForm.password.NotBlank}")
    @Length(max = 32, message = "{AccountForm.password.Length}")
    private String password;
}
