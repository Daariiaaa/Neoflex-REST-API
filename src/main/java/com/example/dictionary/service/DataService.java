package com.example.dictionary.service;

import com.example.dictionary.model.Data;

import java.util.List;
import java.util.UUID;

public interface DataService {
    Data createDatum(Data data);

    Data getDatum(UUID id);

    void updateDatum(Data data);

    void deleteDatum(Data data);

    void deleteDatum(UUID id);

    List<Data> getData();
}