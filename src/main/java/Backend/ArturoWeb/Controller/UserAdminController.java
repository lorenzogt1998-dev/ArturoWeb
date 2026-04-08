package Backend.ArturoWeb.Controller;

import Backend.ArturoWeb.DTO.UserAdminRequestDTO;
import Backend.ArturoWeb.DTO.UserAdminResponseDTO;
import Backend.ArturoWeb.Entity.UserAdmin;
import Backend.ArturoWeb.Mapper.UserAdminMapper;
import Backend.ArturoWeb.Service.UserAdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserAdminController {

    private final UserAdminService service;

    public UserAdminController(UserAdminService service) {
        this.service = service;
    }

    // GET ALL
    @GetMapping
    public List<UserAdminResponseDTO> getAllUsers() {
        return service.getAllUsers()
                .stream()
                .map(UserAdminMapper::toDTO)
                .collect(Collectors.toList());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public UserAdminResponseDTO getUserById(@PathVariable Long id) {
        UserAdmin user = service.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UserAdminMapper.toDTO(user);
    }

    // CREATE
    @PostMapping
    public UserAdminResponseDTO createUser(@RequestBody UserAdminRequestDTO dto) {
        UserAdmin user = UserAdminMapper.toEntity(dto);
        UserAdmin saved = service.createUser(user);
        return UserAdminMapper.toDTO(saved);
    }

    // UPDATE
    @PutMapping("/{id}")
    public UserAdminResponseDTO updateUser(@PathVariable Long id,
                                           @RequestBody UserAdminRequestDTO dto) {
        UserAdmin user = UserAdminMapper.toEntity(dto);
        UserAdmin updated = service.updateUser(id, user);
        return UserAdminMapper.toDTO(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }
}