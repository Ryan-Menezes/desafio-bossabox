package com.example.desafio_bossabox.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio_bossabox.requests.ToolRequest;
import com.example.desafio_bossabox.responses.ToolResponse;
import com.example.desafio_bossabox.services.ToolService;

@RestController
@RequestMapping("/tools")
public class ToolController {
    @Autowired
    private ToolService toolService;

    @GetMapping
    public ResponseEntity<List<ToolResponse>> findAll(@RequestParam(defaultValue = "") String tag) {
        List<ToolResponse> tools;

        if (tag.isEmpty()) {
            tools = toolService.findAll();
        } else {
            tools = toolService.findByTag(tag);
        }

        return ResponseEntity.ok(tools);
    }

    @PostMapping
    public ResponseEntity<ToolResponse> save(@RequestBody ToolRequest toolRequest) {
        ToolResponse tool = toolService.save(toolRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(tool);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        toolService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
