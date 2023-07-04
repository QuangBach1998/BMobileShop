package spring.BshopServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.BshopServer.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    boolean existsByName(String name);
}
