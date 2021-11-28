package Reto1.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Reto1.model.User;
import Reto1.repository.crud.userCrudRepository;

@Repository
public class userRepository {
    @Autowired
    private userCrudRepository usercrudrepository;

    public List <User> getAll(){
        return (List<User>) usercrudrepository.findAll();
    }

    public Optional<User> getUser(int id){
        return usercrudrepository.findById(id);
    }

    public User save(User user){
        return usercrudrepository.save(user);
    }

    public boolean existeEmail(String email){
        Optional<User> usuario = usercrudrepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> autenticarUsuario(String email, String password) {
        return usercrudrepository.findByEmailAndPassword(email, password);
    }

    
}
