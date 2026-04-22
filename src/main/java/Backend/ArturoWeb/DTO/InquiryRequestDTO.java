package Backend.ArturoWeb.DTO;

import Backend.ArturoWeb.Enum.InquiryStatus;

public record InquiryRequestDTO(
        String name,
        String email,
        String message,
        Long artworkId,
        InquiryStatus status
) {
}