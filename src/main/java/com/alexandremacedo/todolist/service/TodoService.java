package com.alexandremacedo.todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.alexandremacedo.todolist.entity.Todo;
import com.alexandremacedo.todolist.repository.TodoRepository;

@Service
public class TodoService {
    

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> list(){
        return todoRepository.findAll(createSortingCriteria());
    }

    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }

    private Sort createSortingCriteria(){
        Sort sort = Sort.by("priority").descending()
        .and(Sort.by("name").ascending());

        return sort;
    }
}
