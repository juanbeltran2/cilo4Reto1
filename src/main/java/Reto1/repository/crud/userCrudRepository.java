package Reto1.repository.crud;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import Reto1.model.User;

public interface userCrudRepository extends CrudRepository <User, Integer> {
    
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}
