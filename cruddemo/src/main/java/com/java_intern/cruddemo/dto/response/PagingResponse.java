package com.java_intern.cruddemo.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class PagingResponse<T> {
    int pageSize;
    int currentPage;
    long total;
    List<T> data;
}
