package com.univer.repository;

import com.univer.baseEntity.HomeworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeWorkSpringRepository extends JpaRepository<HomeworkEntity,Long> {
}
