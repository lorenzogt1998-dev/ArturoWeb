package Backend.ArturoWeb.Service;

import Backend.ArturoWeb.DTO.ArtistRequestDTO;
import Backend.ArturoWeb.DTO.ArtistResponseDTO;
import Backend.ArturoWeb.Entity.Artist;
import Backend.ArturoWeb.Mapper.ArtistMapper;
import Backend.ArturoWeb.Repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<ArtistResponseDTO> getAllArtists() {
        return artistRepository.findAll()
                .stream()
                .map(ArtistMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ArtistResponseDTO> getArtistById(Long id) {
        return artistRepository.findById(id)
                .map(ArtistMapper::toDTO);
    }

    public ArtistResponseDTO createArtist(ArtistRequestDTO dto) {
        Artist artist = ArtistMapper.toEntity(dto);
        Artist savedArtist = artistRepository.save(artist);
        return ArtistMapper.toDTO(savedArtist);
    }

    public ArtistResponseDTO updateArtist(Long id, ArtistRequestDTO dto) {
        return artistRepository.findById(id).map(artist -> {
            artist.setName(dto.name());
            artist.setBiography(dto.biography());
            artist.setProfileImage(dto.profileImage());
            artist.setInstagram(dto.instagram());
            artist.setEmail(dto.email());

            Artist updatedArtist = artistRepository.save(artist);
            return ArtistMapper.toDTO(updatedArtist);
        }).orElseThrow(() -> new RuntimeException("Artist no encontrado con id: " + id));
    }

    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }
}