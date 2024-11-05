package edu.sm.app.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Search {
    private String keyword;
    private String search;
}
