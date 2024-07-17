package com.example.desafio_bossabox.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio_bossabox.entities.Tool;
import com.example.desafio_bossabox.repositories.ToolRepository;
import com.example.desafio_bossabox.requests.ToolRequest;
import com.example.desafio_bossabox.responses.ToolResponse;

@Service
public class ToolService {
    @Autowired
    private ToolRepository toolRepository;

    public List<ToolResponse> findAll() {
        return toolRepository.findAll().stream().map(tool -> tool.toResponse()).toList();
    }

    public List<ToolResponse> findByTag(String tag) {
        return toolRepository.findByTag(tag).stream().map(tool -> tool.toResponse()).toList();
    }

    public ToolResponse save(ToolRequest toolRequest) {
        Tool tool = toolRepository.save(toolRequest.toModel());

        return tool.toResponse();
    }

    public void deleteById(Long id) {
        toolRepository.deleteById(id);
    }
}
