package Backend.ArturoWeb.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "categories") // cambio para commit 2
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String description;

    //  constructor

    public Category(Long id, String name, String description) {
        this.id = id;
        this.name = name;

        this.description = description;
    }

    public Category() {
    }

    // getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}




