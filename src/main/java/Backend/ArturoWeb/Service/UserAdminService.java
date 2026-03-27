package Backend.ArturoWeb.Service;

import Backend.ArturoWeb.Entity.UserAdmin;
import Backend.ArturoWeb.Repository.UserAdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAdminService {

    private final UserAdminRepository repository;

    public UserAdminService(UserAdminRepository repository) {
        this.repository = repository;
    }

    // GET ALL
    public List<UserAdmin> getAllUsers() {
        return repository.findAll();
    }

    // GET BY ID
    public Optional<UserAdmin> getUserById(Long id) {
        return repository.findById(id);
    }

    // CREATE
    public UserAdmin createUser(UserAdmin user) {
        return repository.save(user);
    }

    // UPDATE
    public UserAdmin updateUser(Long id, UserAdmin userDetails) {
        return repository.findById(id).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setRole(userDetails.getRole());
            user.setCreatedAt(userDetails.getCreatedAt());
            return repository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // DELETE
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}