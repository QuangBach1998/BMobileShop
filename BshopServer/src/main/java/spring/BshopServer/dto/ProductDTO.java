package spring.BshopServer.dto;

import lombok.Data;
import org.springframework.cglib.core.Local;
import spring.BshopServer.entity.Product;

import java.time.LocalDate;

@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private double price;
    private double salePrice;
    private String thumbnailUrl;
    private String description;
    private Product.Ram ram;
    private LocalDate createdDate;
    private LocalDate updatedAt;
    private CategoryDTO category;

    @Data
    public static class CategoryDTO {
        private Integer id;
        private String name;
        private LocalDate createdDate;
        private LocalDate updatedAt;
    }

}
