package com.example.emtbackend191216.model.dto;

import com.example.emtbackend191216.model.enumerations.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDTO {
    private String name;
    private Category category;
    private Long authorId;
    private Integer availableCopies;

    public BookDTO(String name, Category category, Long authorId, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }
}