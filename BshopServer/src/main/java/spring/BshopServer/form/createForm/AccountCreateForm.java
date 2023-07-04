package spring.BshopServer.form.createForm;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import spring.BshopServer.entity.Account;

@Data
public class AccountCreateForm {
    @NotBlank(message = "{AccountForm.username.NotBlank}")
    @Length(max = 50, message = "{AccountForm.username.Length}")
    private String username;

    @NotBlank(message = "{AccountForm.password.NotBlank}")
    @Length(max = 60, message = "{AccountForm.password.Length}")
    private String password;

    @NotBlank(message = "{AccountForm.firstName.NotBlank}")
    @Length(max = 50, message = "{AccountForm.firstName.Length}")
    private String firstName;

    @NotBlank(message = "{AccountForm.lastName.NotBlank}")
    @Length(max = 50, message = "{AccountForm.lastName.Length}")
    private String lastName;

    @NotNull(message = "{AccountForm.role.NotNull}")
    private Account.Role role = Account.Role.EMPLOYEE;
}
