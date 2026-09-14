package com.java.graph_ql_revision.service;

import com.java.graph_ql_revision.Response.AiResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AiServiceImpl implements AiService {
    private final ChatClient googleChatClient;

    public AiServiceImpl(@Qualifier("googleChatClient") ChatClient googleChatClient) {
        this.googleChatClient = googleChatClient;
    }

    @Override
    public Object aiChat(String prompt, String conversationId) {
        return googleChatClient
                .prompt()
                .advisors(advisorSpec -> advisorSpec.param(
                        ChatMemory.CONVERSATION_ID,
                        "conversationId"
                ))
                .user(promptUserSpec -> promptUserSpec.text(prompt))
                .call()
                .entity(AiResponse.class);
    }
}
