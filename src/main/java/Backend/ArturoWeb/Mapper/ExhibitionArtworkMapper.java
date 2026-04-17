package Backend.ArturoWeb.Mapper;

import Backend.ArturoWeb.DTO.ExhibitionArtworkResponseDTO;
import Backend.ArturoWeb.Entity.ExhibitionArtwork;

public class ExhibitionArtworkMapper {

    public static ExhibitionArtworkResponseDTO toResponseDTO(ExhibitionArtwork exhibitionArtwork) {
        return new ExhibitionArtworkResponseDTO(
                exhibitionArtwork.getId(),
                exhibitionArtwork.getExhibition().getId(),
                exhibitionArtwork.getArtwork().getId()
        );
    }
}