package com.example.lms.controller;

import com.example.lms.dto.ApiResponseWrapper;
import com.example.lms.model.Topic;
import com.example.lms.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topics")
@RequiredArgsConstructor
@Tag(name = "Topic Management", description = "API для работы с темами")
public class TopicController {
    private final TopicService topicService;

    @PostMapping("/courses/{courseId}")
    @Operation(summary = "Добавить тему в курс")
    public ResponseEntity<ApiResponseWrapper<Topic>> addTopicToCourse(
            @PathVariable Long courseId,
            @RequestBody Topic topic
    ) {
        return ResponseEntity.ok(ApiResponseWrapper.success(
                topicService.addTopicToCourse(courseId, topic))
        );
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить тему по ID")
    public ResponseEntity<ApiResponseWrapper<Topic>> getTopic(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponseWrapper.success(topicService.getTopicById(id)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить тему")
    public ResponseEntity<ApiResponseWrapper<Void>> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.ok(ApiResponseWrapper.success(null));
    }
}