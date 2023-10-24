package com.merge.fullio.model.record;

import com.merge.fullio.DTO.record.CategoryRequest;
import com.merge.fullio.model.WriterEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Category extends WriterEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column
    private int location;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Category> subCategories = new ArrayList<>();

    @OneToMany
    private List<Record> records;

    public void addSubCategory(Category subCategory) {
        subCategories.add(subCategory);
        subCategory.setCategory(this);
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category(String name, int location){
        this.name = name;
        this.location = location;
    }

    public Category(String name, Category category, int location){
        this.name = name;
        this.category = category;
        this.location = location;
    }
}
