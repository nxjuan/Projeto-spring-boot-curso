package com.example.curso.services;

import com.example.curso.models.Tasks;
import com.example.curso.models.Users;
import com.example.curso.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public Tasks findById(Long id){
        Optional<Tasks> task =  this.taskRepository.findById(id);
        return task.orElseThrow(
                () -> new RuntimeException(
                    "Tarefa não Encontrada! id: " + id + ", tipo: " + Tasks.class.getName()
                )
        );
    }
    @Transactional
    public Tasks create(Tasks obj){
        Users user = this.userService.findById(obj.getUser().getId());
        obj.setId(null);
        obj.setUser(user);
        obj = this.taskRepository.save(obj);
        return obj;
    }

    public Tasks update(Tasks obj){
        Tasks newObj = findById(obj.getId());
        newObj.setDescription(obj.getDescription());
        return this.taskRepository.save(newObj);
    }
    public void delete(Long id){
        findById(id);
        try {
            this.taskRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException(
                    "Não é possivel excluir pois há entidades relacionadas!"
            );
        }
    }
}
