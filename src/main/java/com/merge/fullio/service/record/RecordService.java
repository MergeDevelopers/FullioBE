package com.merge.fullio.service.record;

import com.merge.fullio.repository.CategoryRepository;
import com.merge.fullio.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;
    private final CategoryRepository categoryRepository;

    public void createRecord() {

    }
}
