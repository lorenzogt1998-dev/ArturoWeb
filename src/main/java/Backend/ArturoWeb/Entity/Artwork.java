package Backend.ArturoWeb.Entity;

import Backend.ArturoWeb.Enum.ArtworkStatus;
import jakarta.persistence.*;
import lombok.Data;
//voy a cambiar esto para que me deje hace commit
import java.util.Date;

@Entity
@Table
public class Artwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Date year;
    private String technique;
    private String imageUrl;
    private Long categoryId;
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    private ArtworkStatus status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public ArtworkStatus getStatus() {
        return status;
    }
    public void setStatus(ArtworkStatus status){
        this.status = status;
    }

    public Artwork(Long id, String title, String description, Date year, String technique, String imageUrl, Long categoryId, Date createdAt, ArtworkStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
        this.technique = technique;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
        this.createdAt = createdAt;
        this.status = status;
    }

    public Artwork() {
    }
}
