package spring.BshopServer.form.createForm;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import spring.BshopServer.validation.CategoryNotExistsByName;

@Data
public class CategoryCreateForm {
    @NotBlank(message = "{CategoryForm.name.NotBlank}")
    @Length(max = 50, message = "{CategoryForm.name.Length}")
    @CategoryNotExistsByName
    private String name;
}
