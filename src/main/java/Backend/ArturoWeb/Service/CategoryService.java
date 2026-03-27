package Backend.ArturoWeb.Service;

import Backend.ArturoWeb.Entity.Category;
import Backend.ArturoWeb.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository; //saber que categoryRepository es el puente hacia la base de datos

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {  //trae todas las categorias
        return categoryRepository.findAll(); //findAll trae todo
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id); //trae una categoria especifica
    }

    public Category createCategory(Category category) { //crea una nueva categoria
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category categoryDetails) { //actualiza una categoria existente
        Category category = categoryRepository.findById(id)  //busca la existente
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(categoryDetails.getName());
        category.setDescription(categoryDetails.getDescription()); // cambia algunos valores y guardandolos

        return categoryRepository.save(category); // guarda la categoria actualizada
    }

    public void deleteCategory(Long id) { //elimina una categoria por ID
        categoryRepository.deleteById(id); //deleteById(id) elimina el registro cuyo id sea este
    }
}