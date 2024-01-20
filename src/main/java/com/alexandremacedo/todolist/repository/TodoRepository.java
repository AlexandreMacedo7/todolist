package com.alexandremacedo.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexandremacedo.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long>{
    
}
