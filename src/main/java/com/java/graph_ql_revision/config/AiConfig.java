package com.java.graph_ql_revision.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {
    public ChatMemory chatMemory() {
        InMemoryChatMemoryRepository inMemoryChatMemoryRepository = new InMemoryChatMemoryRepository();

        return MessageWindowChatMemory
                .builder()
                .chatMemoryRepository(inMemoryChatMemoryRepository)
                .maxMessages(10)
                .build();
    }
    @Bean("googleChatClient")
    public ChatClient googleChatClient(GoogleGenAiChatModel googleGenAiChatModel,
                                       ChatMemory chatMemory) {
        MessageChatMemoryAdvisor messageChatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();
        return ChatClient
                .builder(googleGenAiChatModel)
                .defaultAdvisors(messageChatMemoryAdvisor)
                .defaultOptions(GoogleGenAiChatOptions
                        .builder()
                        .model("gemini-3.1-flash-lite")
                        .temperature(0.5)
                        .maxTokens(1000)
                )
                .build();
    }
}
