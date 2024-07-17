package com.example.desafio_bossabox.requests;

import java.util.List;

import com.example.desafio_bossabox.entities.Tool;

public record ToolRequest(
    String title,
    String link,
    String description,
    List<String> tags
) {
    public Tool toModel()
    {
        return new Tool(title, link, description, tags);
    }
}
