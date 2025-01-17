package com.blogapplication.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer categoryId;

    @NotEmpty
    @Size(min=4 , message = "Min Size of category title is 4")
    private String categoryTitle;

    @NotEmpty
    @Size(min = 10 , message = "min size of category description is 10")
    private String categoryDescription;
}
