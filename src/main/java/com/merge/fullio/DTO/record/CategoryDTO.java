package com.merge.fullio.DTO.record;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private long id;

    private String categoryName;

    private int location;

    private List<CategoryDTO> subCategories = new ArrayList<>();
}
