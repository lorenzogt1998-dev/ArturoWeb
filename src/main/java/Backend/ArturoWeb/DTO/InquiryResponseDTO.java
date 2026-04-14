package Backend.ArturoWeb.DTO;

import Backend.ArturoWeb.Enum.InquiryStatus;

import java.util.Date;

public record InquiryResponseDTO(
        Long id,
        String name,
        String email,
        String message,
        Long artworkId,
        Date createdAt,
        InquiryStatus status
) {
}