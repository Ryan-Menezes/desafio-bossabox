package com.example.desafio_bossabox.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.desafio_bossabox.entities.Tool;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {
    @Query(value = "SELECT * FROM tools WHERE tags LIKE %:tag%", nativeQuery = true)
    public List<Tool> findByTag(@Param("tag") String tag);
}
