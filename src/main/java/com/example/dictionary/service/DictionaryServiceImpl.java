package com.example.dictionary.service;

import com.example.dictionary.model.Dictionary;
import com.example.dictionary.repository.DictionaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DictionaryServiceImpl implements DictionaryService {
    private final DictionaryRepository dictionaryRepository;

    @Override
    public Dictionary createDictionary(Dictionary dictionary) {
        return dictionaryRepository.save(dictionary);
    }

    @Override
    public Dictionary getDictionary(UUID id) {
        return dictionaryRepository.findById(id).orElse(null);
    }

    @Override
    public void updateDictionary(Dictionary dictionary) {
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
}
