package com.example.demo.repository;

import com.example.demo.controller.WebhookResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<WebhookResponse, Integer> {
}
