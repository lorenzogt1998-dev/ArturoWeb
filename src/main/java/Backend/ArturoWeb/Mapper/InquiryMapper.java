package Backend.ArturoWeb.Mapper;

import Backend.ArturoWeb.DTO.InquiryRequestDTO;
import Backend.ArturoWeb.DTO.InquiryResponseDTO;
import Backend.ArturoWeb.Entity.Inquiry;

public class InquiryMapper {

    public static Inquiry toEntity(InquiryRequestDTO dto) {
        Inquiry inquiry = new Inquiry();
        inquiry.setName(dto.name());
        inquiry.setEmail(dto.email());
        inquiry.setMessage(dto.message());
        inquiry.setArtworkId(dto.artworkId());
        inquiry.setStatus(dto.status());
        return inquiry;
    }

    public static InquiryResponseDTO toDTO(Inquiry inquiry) {
        return new InquiryResponseDTO(
                inquiry.getId(),
                inquiry.getName(),
                inquiry.getEmail(),
                inquiry.getMessage(),
                inquiry.getArtworkId(),
                inquiry.getCreatedAt(),
                inquiry.getStatus()
        );
    }
}