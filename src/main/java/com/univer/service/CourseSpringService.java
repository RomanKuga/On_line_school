package com.univer.service;

import com.univer.baseEntity.CourseEntity;
import com.univer.repository.CourseSpringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseSpringService {
    private final CourseSpringRepository courseSpringRepository;
@Autowired
    public CourseSpringService(CourseSpringRepository courseSpringRepository) {
        this.courseSpringRepository = courseSpringRepository;
    }

    @Transactional
    public List<CourseEntity> allCourse(){
    return courseSpringRepository.findAll();
    }
    public CourseEntity findById(Long id) {
        return courseSpringRepository.findById(id).orElse(null);
    }

    public CourseEntity addUser(CourseEntity user) {
        return courseSpringRepository.save(user);
    }

}
