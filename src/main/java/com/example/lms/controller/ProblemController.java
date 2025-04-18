package com.example.lms.controller;

import com.example.lms.dto.ApiResponseWrapper;
import com.example.lms.model.Problem;
import com.example.lms.service.ProblemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/problems")
@RequiredArgsConstructor
@Tag(name = "Problem Management", description = "API для работы с задачами")
public class ProblemController {
    private final ProblemService problemService;

    @PostMapping("/topics/{topicId}")
    @Operation(summary = "Добавить задачу в тему")
    public ResponseEntity<ApiResponseWrapper<Problem>> addProblemToTopic(
            @PathVariable Long topicId,
            @RequestBody Problem problem
    ) {
        return ResponseEntity.ok(ApiResponseWrapper.success(
                problemService.addProblemToTopic(topicId, problem))
        );
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить задачу по ID")
    public ResponseEntity<ApiResponseWrapper<Problem>> getProblem(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponseWrapper.success(problemService.getProblemById(id)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить задачу")
    public ResponseEntity<ApiResponseWrapper<Void>> deleteProblem(@PathVariable Long id) {
        problemService.deleteProblem(id);
        return ResponseEntity.ok(ApiResponseWrapper.success(null));
    }
}