package Backend.ArturoWeb.Mapper;

import Backend.ArturoWeb.DTO.CategoryRequestDTO;
import Backend.ArturoWeb.DTO.CategoryResponseDTO;
import Backend.ArturoWeb.Entity.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryRequestDTO dto) {
        Category category = new Category();
        category.setName(dto.name());
        category.setDescription(dto.description());
        return category;
    }

    public static CategoryResponseDTO toResponseDTO(Category category) {
        return new CategoryResponseDTO(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }
}