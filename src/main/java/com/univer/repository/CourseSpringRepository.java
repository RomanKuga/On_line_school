package com.univer.repository;

import com.univer.baseEntity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSpringRepository extends JpaRepository<CourseEntity,Long>{

}
