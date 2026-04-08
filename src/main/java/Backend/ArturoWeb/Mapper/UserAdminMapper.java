package Backend.ArturoWeb.Mapper;

import Backend.ArturoWeb.DTO.UserAdminRequestDTO;
import Backend.ArturoWeb.DTO.UserAdminResponseDTO;
import Backend.ArturoWeb.Entity.UserAdmin;

public class UserAdminMapper {

    public static UserAdmin toEntity(UserAdminRequestDTO dto) {
        UserAdmin user = new UserAdmin();
        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        return user;
    }

    public static UserAdminResponseDTO toDTO(UserAdmin user) {
        return new UserAdminResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}