package Backend.ArturoWeb.Mapper;

import Backend.ArturoWeb.DTO.ArtistRequestDTO;
import Backend.ArturoWeb.DTO.ArtistResponseDTO;
import Backend.ArturoWeb.Entity.Artist;

public class ArtistMapper {

    public static Artist toEntity(ArtistRequestDTO dto) {
        Artist artist = new Artist();
        artist.setName(dto.name());
        artist.setBiography(dto.biography());
        artist.setProfileImage(dto.profileImage());
        artist.setInstagram(dto.instagram());
        artist.setEmail(dto.email());
        return artist;
    }

    public static ArtistResponseDTO toDTO(Artist artist) {
        return new ArtistResponseDTO(
                artist.getId(),
                artist.getName(),
                artist.getBiography(),
                artist.getProfileImage(),
                artist.getInstagram(),
                artist.getEmail()
        );
    }
}