package spring.BshopServer.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import spring.BshopServer.dto.CategoryDTO;
import spring.BshopServer.entity.Category;
import spring.BshopServer.form.createForm.CategoryCreateForm;
import spring.BshopServer.form.updateForm.CategoryUpdateForm;
import spring.BshopServer.service.ICategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private ICategoryService service;
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public Page<CategoryDTO> findAll(Pageable pageable) {
        Page<Category> page = service.findAll(pageable);
        List<CategoryDTO> dtos = mapper.map(
                page.getContent(),
                new TypeToken<List<CategoryDTO>>() {
                }.getType()
        );
        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }

    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public String create(@RequestBody CategoryCreateForm form) {
        service.create(form);
        return "Create success";
    }

    @PutMapping("/{id}")
    public String update(@RequestBody CategoryUpdateForm form, @PathVariable("id") Integer id) {
        service.update(form, id);
        return "Update success";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        service.deleteById(id);
        return "Delete success";
    }

    @DeleteMapping
    public String deleteAll(@RequestBody List<Integer> ids) {
        service.deleteAll(ids);
        return "Delete all success";
    }
}
