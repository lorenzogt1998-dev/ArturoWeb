package Backend.ArturoWeb.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exhibition_artworks")
public class ExhibitionArtwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exhibition_id", nullable = false)
    private Exhibition exhibition;

    @ManyToOne
    @JoinColumn(name = "artwork_id", nullable = false)
    private Artwork artwork;

    public ExhibitionArtwork() {
    }

    public ExhibitionArtwork(Long id, Exhibition exhibition, Artwork artwork) {
        this.id = id;
        this.exhibition = exhibition;
        this.artwork = artwork;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exhibition getExhibition() {
        return exhibition;
    }

    public void setExhibition(Exhibition exhibition) {
        this.exhibition = exhibition;
    }

    public Artwork getArtwork() {
        return artwork;
    }

    public void setArtwork(Artwork artwork) {
        this.artwork = artwork;
    }
}