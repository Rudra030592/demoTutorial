package com.adarsha.fullstack.endpoints;

import com.adarsha.fullstack.Entity.TodoEntity;
import com.adarsha.fullstack.TodoDto;
import com.adarsha.fullstack.todoService.ServiceTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static javax.print.attribute.Size2DSyntax.MM;
import static javax.swing.text.html.HTML.Tag.DD;

@RestController
@RequestMapping("/task")
public class TodoEndpoints {

    @Autowired
    private ServiceTodo serviceTodo;

    @GetMapping("")
    public List<TodoEntity> taskList(@RequestParam String date) throws ParseException {
        //convert in String to Local Date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dt = LocalDate.parse(date,formatter);
        return serviceTodo.getTaskList(dt);
    }


    @PostMapping("")
    public TodoEntity addNewTodo(@RequestBody TodoDto todoDto){
        return  serviceTodo.addNewTask(todoDto);

    }
    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id){
        return serviceTodo.deleteTask(id);
    }

}
