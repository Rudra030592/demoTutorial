package com.adarsha.fullstack.todoService;

import com.adarsha.fullstack.Entity.TodoEntity;
import com.adarsha.fullstack.TodoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceTodo {

    @Autowired
    private TodoRepository todoRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<TodoEntity> getTaskList(LocalDate dateTime ) {

        LocalDate today = LocalDate.now();
        //List<TodoDto> todoDtoList = new ArrayList<>();
        List<TodoEntity> todoEntities = null;
        if (dateTime.compareTo(today) <= 0) {
            todoEntities = todoRepository.findAll();

            //convert Entity to Dto
            //todoDtoList = //conversion logic
        }

        return todoEntities;
    }

    public TodoEntity addNewTask(TodoDto todoDto){
        TodoEntity todoEntity= modelMapper.map(todoDto ,TodoEntity.class);
        TodoEntity saveEntity = todoRepository.save(todoEntity);
        return saveEntity;
    }

    @Transactional
    public String deleteTask(Long id){
        todoRepository.deleteById(id);
        return "id deleted" + id;
    }

}
