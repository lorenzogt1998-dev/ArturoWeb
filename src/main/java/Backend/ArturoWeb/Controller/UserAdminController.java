package Backend.ArturoWeb.Controller;

import Backend.ArturoWeb.Entity.UserAdmin;
import Backend.ArturoWeb.Service.UserAdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAdminController {

    private final UserAdminService service;

    public UserAdminController(UserAdminService service) {
        this.service = service;
    }

    // GET ALL
    @GetMapping
    public List<UserAdmin> getAllUsers() {
        return service.getAllUsers();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public UserAdmin getUserById(@PathVariable Long id) {
        return service.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // CREATE
    @PostMapping
    public UserAdmin createUser(@RequestBody UserAdmin user) {
        return service.createUser(user);
    }

    // UPDATE
    @PutMapping("/{id}")
    public UserAdmin updateUser(@PathVariable Long id, @RequestBody UserAdmin user) {
        return service.updateUser(id, user);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }
}