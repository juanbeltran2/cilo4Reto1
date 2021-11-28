package Reto1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Reto1.model.User;
import Reto1.repository.userRepository;

@Service
public class userService {
    @Autowired
    private userRepository userrepository;

    public List<User> getAll(){
        return userrepository.getAll();
    }

    public Optional<User> getUser(int id){
        return userrepository.getUser(id);        
    }

    public User registrar(User user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return userrepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existeEmail(String email){
        return userrepository.existeEmail(email);
    }

    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userrepository.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
    
}
