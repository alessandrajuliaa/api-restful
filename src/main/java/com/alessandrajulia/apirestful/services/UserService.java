package com.alessandrajulia.apirestful.services;

import com.alessandrajulia.apirestful.domain.User;
import com.alessandrajulia.apirestful.dto.UserDTO;
import com.alessandrajulia.apirestful.repository.UserRepository;
import com.alessandrajulia.apirestful.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);
        if(!user.isPresent()){
            throw new ObjectNotFoundException("Objeto não encontrado!");
        }
        return user.get();
    }

    public User insert(User obj){
        return repository.insert(obj);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User obj){
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO obj){
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }
}
