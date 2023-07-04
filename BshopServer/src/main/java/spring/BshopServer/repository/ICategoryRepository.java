package spring.BshopServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.BshopServer.entity.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    boolean existsByName(String name);
}
