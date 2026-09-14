package com.java.graph_ql_revision.controller;

import com.java.graph_ql_revision.service.AiService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AiController {
    private final AiService service;

    public AiController(AiService service) {
        this.service = service;
    }

    @MutationMapping
    public Object aiChat(@Argument String prompt,
                             @Argument String conversationId) {
        return service.aiChat(prompt, conversationId);
    }
}
