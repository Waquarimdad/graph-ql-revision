package com.java.graph_ql_revision.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AiResponse {
    private String title;
    private String description;
    private int year;
}
