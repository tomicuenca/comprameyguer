package com.tomicuenca.comprameyguer.repository;

import com.tomicuenca.comprameyguer.entity.KeyboardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeyboardRepository extends CrudRepository<KeyboardEntity,Long> {
    List<KeyboardEntity> findAll();
}
