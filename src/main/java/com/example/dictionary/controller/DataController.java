package com.example.dictionary.controller;

import com.example.dictionary.model.Data;
import com.example.dictionary.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5432/insurance")
@RequestMapping("/api")
@RestController
public class DataController {
    private final DataService dataService;

    @GetMapping("/data")
    List<Data> getData() {
        return dataService.getData();
    }

    @PostMapping("/data/records/create")
    Data createDatum(@RequestBody Data data) {
        return dataService.createDatum(data);
    }

    @GetMapping("/data/records/{id}")
    Data getDatum(@PathVariable UUID id) {
        return dataService.getDatum(id);
    }

    @PutMapping("/data/records/update")
    void updateDatum(@RequestBody Data data) {
        dataService.updateDatum(data);
    }

    @DeleteMapping("/data/records/delete/{id}")
    void deleteDatum(@PathVariable UUID id) {
        dataService.deleteDatum(id);
    }

}
