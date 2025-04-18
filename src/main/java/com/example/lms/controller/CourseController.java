package com.example.lms.controller;

import com.example.lms.dto.ApiResponseWrapper;
import com.example.lms.model.Course;
import com.example.lms.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
@Tag(name = "Course Management", description = "API для работы с курсами")
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    @Operation(summary = "Создать курс")
    public ResponseEntity<ApiResponseWrapper<Course>> createCourse(@RequestBody Course course) {
        return ResponseEntity.ok(ApiResponseWrapper.success(courseService.createCourse(course)));
    }

    @PostMapping("/{courseId}/enroll/{studentId}")
    @Operation(summary = "Записать студента на курс")
    public ResponseEntity<ApiResponseWrapper<Course>> enrollStudent(
            @PathVariable Long courseId,
            @PathVariable Long studentId
    ) {
        return ResponseEntity.ok(ApiResponseWrapper.success(
                courseService.enrollStudent(courseId, studentId))
        );
    }

    @PostMapping("/{courseId}/unenroll/{studentId}")
    @Operation(summary = "Отписать студента от курса")
    public ResponseEntity<ApiResponseWrapper<Course>> unenrollStudent(
            @PathVariable Long courseId,
            @PathVariable Long studentId
    ) {
        return ResponseEntity.ok(ApiResponseWrapper.success(
                courseService.unenrollStudent(courseId, studentId))
        );
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить курс по ID")
    public ResponseEntity<ApiResponseWrapper<Course>> getCourse(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponseWrapper.success(courseService.getCourseById(id)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить курс")
    public ResponseEntity<ApiResponseWrapper<Void>> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok(ApiResponseWrapper.success(null));
    }
}