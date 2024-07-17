package com.example.dictionary.service;

import com.example.dictionary.model.Data;
import com.example.dictionary.model.Dictionary;

import java.util.List;
import java.util.UUID;

public interface DatabaseService {
    Dictionary createDictionary(Dictionary dictionary);

    Dictionary getDictionary(UUID id);

    void editDictionary(Dictionary dictionary);

    void deleteDictionary(Dictionary dictionary);

    void deleteDictionary(UUID id);

    List<Dictionary> getDictionaries();

    Data createDatum(Data data);

    Data getDatum(UUID id);

    void editDatum(Data data);

    void deleteDatum(Data data);

    void deleteDatum(UUID id);

    List<Data> getData();
}