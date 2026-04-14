package Backend.ArturoWeb.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String biography;
    private String profileImage;
    private String instagram;
    private String email;

    public Artist() {
    }

    public Artist(Long id, String name, String biography, String profileImage, String instagram, String email) {
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.profileImage = profileImage;
        this.instagram = instagram;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBiography() {
        return biography;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}