package spring.BshopServer.form.updateForm;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import spring.BshopServer.validation.CategoryExistsById;
import spring.BshopServer.validation.CategoryNotExistsByName;

@Data
public class CategoryUpdateForm {
    @NotNull(message = "{CategoryForm.id.NotNull}")
    @CategoryExistsById
    private Integer id;

    @NotBlank(message = "{CategoryForm.name.NotBlank}")
    @Length(max = 50, message = "{CategoryForm.name.Length}")
    @CategoryNotExistsByName
    private String name;
}
