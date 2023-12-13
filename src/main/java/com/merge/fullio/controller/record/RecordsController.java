package com.merge.fullio.controller.record;

import com.merge.fullio.DTO.record.RecordRequest;
import com.merge.fullio.DTO.record.RecordsResDTO;
import com.merge.fullio.exception.BaseResponseStatus;
import com.merge.fullio.service.record.RecordsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/records")
public class RecordsController {

    private final RecordsService recordsService;

    @GetMapping("/{recordsId}")
    @ResponseStatus(HttpStatus.OK)
    public RecordsResponse<RecordsResDTO> getRecordsFromId(@PathVariable Long recordsId) {
        RecordsResDTO recordsResDTO = recordsService.getRecordsFromId(recordsId);
        return new RecordsResponse<>(recordsResDTO, BaseResponseStatus.GET_SUCCESS);
    }

    @GetMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public RecordsResponse<List<RecordsResDTO>> getRecordsFromCategoryId(@PathVariable Long categoryId){
        List<RecordsResDTO> recordsResDTOList = recordsService.getRecordsListFromCategoryId(categoryId);
        return new RecordsResponse<>(recordsResDTOList, BaseResponseStatus.GET_SUCCESS);
    }

    @PostMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public RecordsResponse<BaseResponseStatus> createRecords(@RequestBody RecordRequest recordRequest, @PathVariable Long categoryId){
        recordsService.createRecords(recordRequest, categoryId);
        return new RecordsResponse<>(BaseResponseStatus.CREATE_SUCCESS);
    }

    @PutMapping("/category/{recordsId}/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public RecordsResponse<BaseResponseStatus> changeCategory(@PathVariable Long recordsId, @PathVariable Long categoryId) {
        recordsService.changeCategory(recordsId, categoryId);
        return new RecordsResponse<>(BaseResponseStatus.UPDATE_SUCCESS);
    }
}
