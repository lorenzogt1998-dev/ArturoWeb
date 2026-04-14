package Backend.ArturoWeb.Entity;

import Backend.ArturoWeb.Enum.InquiryStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "inquiries")
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String message;

    private Long artworkId;

    private Date createdAt;

    @Enumerated(EnumType.STRING)
    private InquiryStatus status;

    public Inquiry() {
    }

    public Inquiry(Long id, String name, String email, String message, Long artworkId, Date createdAt, InquiryStatus status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.message = message;
        this.artworkId = artworkId;
        this.createdAt = createdAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public Long getArtworkId() {
        return artworkId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public InquiryStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setArtworkId(Long artworkId) {
        this.artworkId = artworkId;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setStatus(InquiryStatus status) {
        this.status = status;
    }
}