package com.univer.repository;

import com.univer.baseEntity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonSpringRepository extends JpaRepository<PersonEntity,Long> {
}
