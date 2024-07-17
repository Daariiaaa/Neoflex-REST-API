package com.example.dictionary.service;

import com.example.dictionary.model.Dictionary;

import java.util.List;
import java.util.UUID;

public interface DictionaryService {
    Dictionary createDictionary(Dictionary dictionary);

    Dictionary getDictionary(UUID id);

    void updateDictionary(Dictionary dictionary);

    void deleteDictionary(Dictionary dictionary);

    void deleteDictionary(UUID id);

    List<Dictionary> getDictionaries();
}