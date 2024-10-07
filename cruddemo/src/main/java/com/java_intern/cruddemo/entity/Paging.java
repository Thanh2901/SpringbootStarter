package com.java_intern.cruddemo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class Paging<T> {
    int pageSize;
    int offset;
    int currentPage;
    long total;
    List<T> data;
}
