package Backend.ArturoWeb.Mapper;

import Backend.ArturoWeb.DTO.BlogPostRequestDTO;
import Backend.ArturoWeb.DTO.BlogPostResponseDTO;
import Backend.ArturoWeb.Entity.BlogPost;

public class BlogPostMapper {

    public static BlogPost toEntity(BlogPostRequestDTO dto) {
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(dto.title());
        blogPost.setContent(dto.content());
        blogPost.setImageUrl(dto.imageUrl());
        return blogPost;
    }

    public static BlogPostResponseDTO toDTO(BlogPost blogPost) {
        return new BlogPostResponseDTO(
                blogPost.getId(),
                blogPost.getTitle(),
                blogPost.getContent(),
                blogPost.getImageUrl(),
                blogPost.getCreatedAt()
        );
    }
}