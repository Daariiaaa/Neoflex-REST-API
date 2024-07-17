package com.example.dictionary.controller;

import com.example.dictionary.model.Data;
import com.example.dictionary.model.Dictionary;
import com.example.dictionary.service.DatabaseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5432/insurance")
@RequestMapping("/api")
@RestController
public class DatabaseController {
    private final DatabaseService databaseService;

    @GetMapping("/dictionaries")
    List<Dictionary> getDictionaries() {
        return databaseService.getDictionaries();
    }

    @PostMapping("/dictionaries/records/create")
    Dictionary createDictionary(@RequestBody Dictionary dictionary) {
        return databaseService.createDictionary(dictionary);
    }

    @GetMapping("/dictionaries/records/{id}")
    Dictionary getDictionary(@PathVariable UUID id) {
        return databaseService.getDictionary(id);
    }

    @PutMapping("/dictionaries/records/edit")
    void editDictionary(@RequestBody Dictionary dictionary) {
        databaseService.editDictionary(dictionary);
    }

    @DeleteMapping("/dictionaries/records/delete/{id}")
    void deleteEmployee(@PathVariable UUID id) {
        databaseService.deleteDictionary(id);
    }

    @GetMapping("/data")
    List<Data> getData() {
        return databaseService.getData();
    }

    @PostMapping("/data/records/create")
    Data createDatum(@RequestBody Data data) {
        return databaseService.createDatum(data);
    }

    @GetMapping("/data/records/{id}")
    Data getDatum(@PathVariable UUID id) {
        return databaseService.getDatum(id);
    }

    @PutMapping("/data/records/edit")
    void editDatum(@RequestBody Data data) {
        databaseService.editDatum(data);
    }

    @DeleteMapping("/data/records/delete/{id}")
    void deleteDatum(@PathVariable UUID id) {
        databaseService.deleteDatum(id);
    }
}