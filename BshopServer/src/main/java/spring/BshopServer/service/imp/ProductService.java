package spring.BshopServer.service.imp;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.BshopServer.dto.ProductDTO;
import spring.BshopServer.entity.Product;
import spring.BshopServer.form.createForm.ProductCreateForm;
import spring.BshopServer.form.updateForm.ProductUpdateForm;
import spring.BshopServer.repository.IProductRepository;

import java.util.List;

@Service
public class ProductService implements spring.BshopServer.service.IProductService {
    @Autowired
    private IProductRepository repository;
    @Autowired
    private ModelMapper mapper;

    public  Page<Product> findAll(Pageable pageable){
        return  repository.findAll(pageable);
    }

    @Override
    public ProductDTO findById(Integer id) {
        return mapper.map(repository.findById(id).orElse(null), ProductDTO.class);
    }

    @Override
    public String create(ProductCreateForm form) {
        TypeMap<ProductCreateForm, Product> typeMap = mapper.getTypeMap(ProductCreateForm.class, Product.class);
        if (typeMap == null) {
            mapper.addMappings(new PropertyMap<ProductCreateForm, Product>() {
                @Override
                protected void configure() {
                    skip(destination.getId());
                }
            });
        }
        repository.save(mapper.map(form, Product.class));
        return "Create Success";
    }

    @Override
    public String update(ProductUpdateForm form, Integer id) {
        form.setId(id);
        repository.save(mapper.map(form, Product.class));
        return "Update Success";
    }

    @Override
    public String deleteById(Integer id) {
        repository.deleteById(id);
        return "Delete by id success";
    }

    @Override
    public String deleteAll(List<Integer> ids) {
        repository.deleteAllById(ids);
        return "Delete all success";
    }
}
