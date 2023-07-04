package spring.BshopServer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring.BshopServer.dto.CategoryDTO;
import spring.BshopServer.entity.Category;
import spring.BshopServer.form.createForm.CategoryCreateForm;
import spring.BshopServer.form.updateForm.CategoryUpdateForm;

import java.util.List;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);

    CategoryDTO findById(Integer id);

    String create(CategoryCreateForm form);

    String update(CategoryUpdateForm form, Integer id);

    String deleteById(Integer id);

    String deleteAll(List<Integer> ids);
}
