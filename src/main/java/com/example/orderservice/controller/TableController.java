package com.example.orderservice.controller;

import com.example.orderservice.exception.TableNotFoundException;
import com.example.orderservice.model.Table;
import com.example.orderservice.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tables")
public class TableController {

    @Autowired
    private TableRepository tableRepository;

    @GetMapping
    public List<Table> findAllTables() {
        return tableRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Table addTable(@RequestBody Table table) {
        return tableRepository.save(table);
    }

    @GetMapping("/{id}")
    public Optional<Table> findTableById(@PathVariable Long id) {
        Optional<Table> table = tableRepository.findById(id);
        if (!table.isPresent()) {
            throw new TableNotFoundException("id - " + id);
        }
        return tableRepository.findById(id);
    }
}
