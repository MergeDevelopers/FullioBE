package com.merge.fullio.service.record;

import com.merge.fullio.DTO.record.RecordRequest;
import com.merge.fullio.DTO.record.RecordsResDTO;
import com.merge.fullio.exception.BaseResponseStatus;
import com.merge.fullio.exception.clienterror._400.EntityNotFoundException;
import com.merge.fullio.model.records.Category;
import com.merge.fullio.model.records.Records;
import com.merge.fullio.repository.CategoryRepository;
import com.merge.fullio.repository.RecordsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecordsService {

    private final RecordsRepository recordsRepository;
    private final CategoryRepository categoryRepository;

    public void createRecords(RecordRequest recordRequest, Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new EntityNotFoundException(BaseResponseStatus.ENTITY_NOT_FOUND)
        );
        Records records = new Records(recordRequest, category);
        recordsRepository.save(records);
    }
    @Transactional
    public void updateRecords(RecordRequest recordRequest, Long recordId) {
        Records records = recordsRepository.findById(recordId).orElseThrow(
                () -> new EntityNotFoundException(BaseResponseStatus.ENTITY_NOT_FOUND)
        );

        records.updateRecords(recordRequest);
    }

    @Transactional
    public void changeCategory(Long recordId, Long categoryId){
        Records records = recordsRepository.findById(recordId).orElseThrow(
                () -> new EntityNotFoundException(BaseResponseStatus.ENTITY_NOT_FOUND)
        );
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new EntityNotFoundException(BaseResponseStatus.ENTITY_NOT_FOUND)
        );

        records.changeCategory(category);
    }

    @Transactional
    public void deleteRecord(Long recordId) {
        Records records = recordsRepository.findById(recordId).orElseThrow(
                () -> new EntityNotFoundException(BaseResponseStatus.ENTITY_NOT_FOUND)
        );
        recordsRepository.delete(records);
    }

    public RecordsResDTO getRecordsFromId(Long recordId){
        Records records = recordsRepository.findById(recordId).orElseThrow(
                () -> new EntityNotFoundException(BaseResponseStatus.ENTITY_NOT_FOUND)
        );

        return RecordsResDTO.builder()
                .id(records.getId())
                .categoryId(records.getCategory().getId())
                .title(records.getTitle())
                .content(records.getContent())
                .createdAt(records.getCreatedAt())
                .build();
    }

    public List<RecordsResDTO> getRecordsListFromCategoryId(Long categoryId){
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new EntityNotFoundException(BaseResponseStatus.ENTITY_NOT_FOUND)
        );

        return recordsRepository.findAllByCategory(category).stream().map(record -> RecordsResDTO.builder()
                        .id(record.getId())
                        .categoryId(record.getCategory().getId())
                        .title(record.getTitle())
                        .content(record.getContent())
                        .createdAt(record.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }

}
