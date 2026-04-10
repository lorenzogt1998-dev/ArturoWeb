package Backend.ArturoWeb.Service;

import Backend.ArturoWeb.DTO.CategoryRequestDTO;
import Backend.ArturoWeb.DTO.CategoryResponseDTO;
import Backend.ArturoWeb.Entity.Category;
import Backend.ArturoWeb.Mapper.CategoryMapper;
import Backend.ArturoWeb.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public CategoryResponseDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));

        return CategoryMapper.toResponseDTO(category);
    }

    public CategoryResponseDTO createCategory(CategoryRequestDTO requestDTO) {
        Category category = CategoryMapper.toEntity(requestDTO);
        Category savedCategory = categoryRepository.save(category);

        return CategoryMapper.toResponseDTO(savedCategory);
    }

    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO requestDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));

        category.setName(requestDTO.name());
        category.setDescription(requestDTO.description());

        Category updatedCategory = categoryRepository.save(category);

        return CategoryMapper.toResponseDTO(updatedCategory);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}