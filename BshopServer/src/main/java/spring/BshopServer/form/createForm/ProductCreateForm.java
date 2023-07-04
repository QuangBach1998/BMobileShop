package spring.BshopServer.form.createForm;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import spring.BshopServer.entity.Product;
import spring.BshopServer.validation.CategoryExistsById;
import spring.BshopServer.validation.ProductNotExistsByName;

@Data
public class ProductCreateForm {
    @NotBlank(message = "{ProductForm.name.NotBlank}")
    @Length(max = 50, message = "{ProductForm.name.Length}")
    @ProductNotExistsByName
    private String name;

    @NotNull(message = "{ProductForm.price.NotNull}")
    @PositiveOrZero(message = "{ProductForm.price.PositiveOrZero}")
    private Double price;

    @NotNull(message = "{ProductForm.salePrice.NotNull}")
    @PositiveOrZero(message = "{ProductForm.salePrice.PositiveOrZero}")
    private Double salePrice;

    @NotBlank(message = "{ProductForm.thumbnailUrl.NotBlank}")
    @Length(max = 255, message = "{ProductForm.thumbnailUrl.Length}")
    private String thumbnailUrl;

    @NotNull(message = "{ProductForm.ram.NotNull}")
    private Product.Ram ram;

    @NotBlank(message = "{ProductForm.description.NotBlank}")
    @Length(max = 1023, message = "{ProductForm.description.Length}")
    private String description;

    @NotNull(message = "{CategoryForm.id.NotNull}")
    @CategoryExistsById
    private Integer categoryId;
}
