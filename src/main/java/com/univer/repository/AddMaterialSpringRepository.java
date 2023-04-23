package com.univer.repository;

import com.univer.baseEntity.AddmaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddMaterialSpringRepository extends JpaRepository<AddmaterialEntity,Long> {
}
