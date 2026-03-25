package com.tomicuenca.comprameyguer.repository;

import com.tomicuenca.comprameyguer.entity.MouseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MouseRepository extends CrudRepository<MouseEntity, Long> {
    List<MouseEntity> findAll();
}
