package spring.BshopServer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring.BshopServer.dto.ProductDTO;
import spring.BshopServer.entity.Product;
import spring.BshopServer.form.createForm.ProductCreateForm;
import spring.BshopServer.form.updateForm.ProductUpdateForm;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    ProductDTO findById(Integer id);

    String create(ProductCreateForm form);

    String update(ProductUpdateForm form, Integer id);

    String deleteById(Integer id);

    String deleteAll(List<Integer> ids);
}
