package com.example.curso.repositories;

import com.example.curso.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long> {

    List<Tasks> findByUser_Id(Long id);

}
