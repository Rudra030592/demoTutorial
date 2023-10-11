package com.adarsha.fullstack.todoService;

import com.adarsha.fullstack.Entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {

    @Modifying
    @Query("Delete from TodoEntity t where t.id = ?1")
    void deleteById(Long id);
}
