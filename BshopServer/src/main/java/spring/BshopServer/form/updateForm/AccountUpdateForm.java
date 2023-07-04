package spring.BshopServer.form.updateForm;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import spring.BshopServer.entity.Account;
import spring.BshopServer.validation.AccountExistsById;
import spring.BshopServer.validation.AccountNotExistsByUsername;

@Data
public class AccountUpdateForm {
    @NotNull(message = "{AccountForm.id.NotNull}")
    @AccountExistsById
    private Integer id;

    @NotBlank(message = "{AccountForm.username.NotBlank}")
    @Length(max = 50, message = "{AccountForm.username.Length}")
    @AccountNotExistsByUsername
    private String username;

    @NotBlank(message = "{AccountForm.password.NotBlank}")
    @Length(max = 32, message = "{AccountForm.password.Length}")
    private String password;

    @NotBlank(message = "{AccountForm.firstName.NotBlank}")
    @Length(max = 50, message = "{AccountForm.firstName.Length}")
    private String firstName;

    @NotBlank(message = "{AccountForm.lastName.NotBlank}")
    @Length(max = 50, message = "{AccountForm.lastName.Length}")
    private String lastName;

    @NotNull(message = "{AccountForm.role.NotNull}")
    private Account.Role role;
}
