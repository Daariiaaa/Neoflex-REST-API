package com.example.dictionary.service;

import com.example.dictionary.model.Data;
import com.example.dictionary.model.Dictionary;
import com.example.dictionary.repository.DataRepository;
import com.example.dictionary.repository.DictionaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class DatabaseServiceImpl implements DatabaseService {
    private final DictionaryRepository dictionaryRepository;

    private final DataRepository dataRepository;

    @Override
    public Dictionary createDictionary(Dictionary dictionary) {
        return dictionaryRepository.save(dictionary);
    }

    @Override
    public Dictionary getDictionary(UUID id) {
        return dictionaryRepository.findById(id).orElse(null);
    }

    @Override
    public void editDictionary(Dictionary dictionary) {
        Dictionary existingDictionary = getDictionary(dictionary.getId());
        if (existingDictionary != null) {
            existingDictionary.setCode(dictionary.getCode());
            existingDictionary.setDescription(dictionary.getDescription());
            dictionaryRepository.save(dictionary);
        } else {
            dictionaryRepository.save(dictionary);
        }
    }

    @Override
    public void deleteDictionary(Dictionary dictionary) {
        dictionaryRepository.delete(dictionary);
    }

    @Override
    public void deleteDictionary(UUID id) {
        if (dictionaryRepository.existsById(id)) {
            dictionaryRepository.deleteById(id);
        }
    }

    @Override
    public List<Dictionary> getDictionaries() {
        return dictionaryRepository.findAll();
    }

    @Override
    public Data createDatum(Data data) {
        return dataRepository.save(data);
    }

    @Override
    public Data getDatum(UUID id) {
        return dataRepository.findById(id).orElse(null);
    }

    @Override
    public void editDatum(Data data) {
        Data existingData = getDatum(data.getId());
        if (existingData != null) {
            existingData.setDictionary(data.getDictionary());
            existingData.setCode(data.getCode());
            existingData.setValue(data.getValue());
            dataRepository.save(data);
        } else {
            dataRepository.save(data);
        }
    }

    @Override
    public void deleteDatum(Data data) {
        dataRepository.delete(data);
    }

    @Override
    public void deleteDatum(UUID id) {
        if (dataRepository.existsById(id)) {
            dataRepository.deleteById(id);
        }
    }

    @Override
    public List<Data> getData() {
        return dataRepository.findAll();
    }
}