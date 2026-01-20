package br.com.angelgranville.controller;

import br.com.angelgranville.entity.ToDo;
import br.com.angelgranville.service.ToDoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ToDoController {
    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @PostMapping("/create")
    List<ToDo> create(@RequestBody @Valid ToDo toDo){
       return toDoService.create(toDo);
    }

    @GetMapping("/")
    List<ToDo> list(){
        return toDoService.list();
    }

    @PutMapping("/update")
    List<ToDo> update(@RequestBody ToDo toDo){
        return toDoService.update(toDo);
    }

    @DeleteMapping("/delete/{id}")
    List<ToDo> delete(@PathVariable("id") Long id){
        return toDoService.delete(id);
    }
}
