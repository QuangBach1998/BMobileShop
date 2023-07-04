package spring.BshopServer.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import spring.BshopServer.dto.ProductDTO;
import spring.BshopServer.entity.Product;
import spring.BshopServer.form.createForm.ProductCreateForm;
import spring.BshopServer.form.updateForm.ProductUpdateForm;
import spring.BshopServer.service.IProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private IProductService service;

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> page = service.findAll(pageable);
        List<ProductDTO> dtos = mapper.map(
                page.getContent(),
                new TypeToken<List<ProductDTO>>() {
                }.getType()
        );
        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public String create(@RequestBody ProductCreateForm form) {
        service.create(form);
        return "Create Success";
    }

    @PutMapping("/{id}")
    public String update(@RequestBody ProductUpdateForm form, @PathVariable Integer id) {
        service.update(form, id);
        return "Update Success";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        service.deleteById(id);
        return "Delete by id success";
    }

    @DeleteMapping
    public String deleteAll(@RequestBody List<Integer> ids) {
        service.deleteAll(ids);
        return "Delete all success";
    }
}
