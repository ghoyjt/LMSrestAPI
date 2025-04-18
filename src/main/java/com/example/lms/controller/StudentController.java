package com.example.lms.controller;

import com.example.lms.dto.ApiResponseWrapper;
import com.example.lms.model.Student;
import com.example.lms.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Tag(name = "Student Management", description = "API для работы со студентами")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    @Operation(summary = "Создать студента", description = "Регистрация нового студента")
    public ResponseEntity<ApiResponseWrapper<Student>> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(ApiResponseWrapper.success(studentService.createStudent(student)));
    }

    @PatchMapping("/{studentId}/solve/{problemId}")
    @Operation(summary = "Добавить решённую задачу", description = "Отметить задачу как решённую студентом")
    public ResponseEntity<ApiResponseWrapper<Student>> solveProblem(
            @PathVariable Long studentId,
            @PathVariable Long problemId
    ) {
        return ResponseEntity.ok(ApiResponseWrapper.success(
                studentService.addSolvedProblem(studentId, problemId))
        );
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить студента по ID", description = "Получение информации о студенте")
    public ResponseEntity<ApiResponseWrapper<Student>> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponseWrapper.success(studentService.getStudentById(id)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить студента", description = "Удаление учётной записи студента")
    public ResponseEntity<ApiResponseWrapper<Void>> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok(ApiResponseWrapper.success(null));
    }
}