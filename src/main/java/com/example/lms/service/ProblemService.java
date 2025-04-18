package com.example.lms.service;

import com.example.lms.model.Problem;
import com.example.lms.model.Topic;
import com.example.lms.repository.ProblemRepository;
import com.example.lms.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProblemService {
    private final ProblemRepository problemRepository;
    private final TopicRepository topicRepository;

    @Transactional
    public Problem addProblemToTopic(Long topicId, Problem problem) {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new NoSuchElementException("Topic not found"));
        problem.setTopic(topic);
        return problemRepository.save(problem);
    }

    public Problem getProblemById(Long id) {
        return problemRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Problem not found"));
    }

    public void deleteProblem(Long id) {
        problemRepository.deleteById(id);
    }
}