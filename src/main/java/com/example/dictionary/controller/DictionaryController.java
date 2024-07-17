package com.example.dictionary.controller;

import com.example.dictionary.model.Dictionary;
import com.example.dictionary.service.DictionaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5432/insurance")
@RequestMapping("/api")
@RestController
public class DictionaryController {
    private final DictionaryService dictionaryService;

    @GetMapping("/dictionaries")
    List<Dictionary> getDictionaries() {
        return dictionaryService.getDictionaries();
    }

    @PostMapping("/dictionaries/records/create")
    Dictionary createDictionary(@RequestBody Dictionary dictionary) {
        return dictionaryService.createDictionary(dictionary);
    }

    @GetMapping("/dictionaries/records/{id}")
    Dictionary getDictionary(@PathVariable UUID id) {
        return dictionaryService.getDictionary(id);
    }

    @PutMapping("/dictionaries/records/update")
    void updateDictionary(@RequestBody Dictionary dictionary) {
        dictionaryService.updateDictionary(dictionary);
    }

    @DeleteMapping("/dictionaries/records/delete/{id}")
    void deleteDictionary(@PathVariable UUID id) {
        dictionaryService.deleteDictionary(id);
    }
}
