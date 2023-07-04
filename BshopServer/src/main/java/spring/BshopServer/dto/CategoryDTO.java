package spring.BshopServer.dto;

import lombok.Data;
import spring.BshopServer.entity.Product;

import java.time.LocalDate;
import java.util.List;

@Data
public class CategoryDTO {
    private Integer id;
    private String name;
    private LocalDate createdDate;
    private LocalDate updatedAt;
    private List<ProductDTO> product;

    @Data
    public static class ProductDTO {
        private Integer id;
        private String name;
        private double price;
        private double salePrice;
        private String thumbnailUrl;
        private String description;
        private Product.Ram ram;
        private LocalDate createdDate;
        private LocalDate updatedAt;
    }
}
