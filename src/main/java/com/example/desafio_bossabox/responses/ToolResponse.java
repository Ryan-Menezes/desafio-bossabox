package com.example.desafio_bossabox.responses;

import java.util.List;

public record ToolResponse(
    Long id,
    String title,
    String link,
    String description,
    List<String> tags
) {}
