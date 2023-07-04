package spring.BshopServer.service.imp;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.BshopServer.dto.CategoryDTO;
import spring.BshopServer.entity.Category;
import spring.BshopServer.form.createForm.CategoryCreateForm;
import spring.BshopServer.form.updateForm.CategoryUpdateForm;
import spring.BshopServer.repository.ICategoryRepository;

import java.util.List;

@Service
public class CategoryService implements spring.BshopServer.service.ICategoryService {
    @Autowired
    private ICategoryRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public CategoryDTO findById(Integer id) {
        return mapper.map(repository.findById(id).orElse(null), CategoryDTO.class);
    }

    @Override
    public String create(CategoryCreateForm form) {
        TypeMap<CategoryCreateForm, Category> typeMap = mapper.getTypeMap(CategoryCreateForm.class, Category.class);
        if (typeMap == null) {
            mapper.addMappings(new PropertyMap<CategoryCreateForm, Category>() {
                @Override
                protected void configure() {
                    skip(destination.getId());
                }
            });
        }
        repository.save(mapper.map(form, Category.class));
        return "Create Success";
    }

    @Override
    public String update(CategoryUpdateForm form, Integer id) {
        form.setId(id);
        repository.save(mapper.map(form, Category.class));
        return "Update Success";
    }

    @Override
    public String deleteById(Integer id) {
        repository.deleteById(id);
        return "Delete by id success";
    }
    @Override
    public String deleteAll(List<Integer> ids){
        repository.deleteAllById(ids);
        return "Delete all success";
    }
}
