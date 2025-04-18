package com.example.lms.service;

import com.example.lms.model.Student;
import com.example.lms.repository.StudentRepository;
import com.example.lms.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ProblemRepository problemRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public Student addSolvedProblem(Long studentId, Long problemId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.getSolvedProblems().add(
                problemRepository.findById(problemId)
                        .orElseThrow(() -> new RuntimeException("Problem not found"))
        );
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}