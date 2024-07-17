package com.example.dictionary.service;

import com.example.dictionary.model.Data;
import com.example.dictionary.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DataServiceImpl implements DataService {
    private final DataRepository dataRepository;

    @Override
    public Data createDatum(Data data) {
        return dataRepository.save(data);
    }

    @Override
    public Data getDatum(UUID id) {
        return dataRepository.findById(id).orElse(null);
    }

    @Override
    public void updateDatum(Data data) {
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
