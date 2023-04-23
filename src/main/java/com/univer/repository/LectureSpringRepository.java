package com.univer.repository;

import com.univer.baseEntity.LectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureSpringRepository extends JpaRepository<LectureEntity,Long> {
}
