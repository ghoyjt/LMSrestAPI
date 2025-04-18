package com.example.lms.service;

import com.example.lms.model.Course;
import com.example.lms.model.Topic;
import com.example.lms.repository.CourseRepository;
import com.example.lms.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public Topic addTopicToCourse(Long courseId, Topic topic) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("Course not found"));
        topic.setCourse(course);
        return topicRepository.save(topic);
    }

    public Topic getTopicById(Long id) {
        return topicRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Topic not found"));
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}