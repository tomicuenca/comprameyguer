package com.tomicuenca.comprameyguer.repository;

import com.tomicuenca.comprameyguer.entity.KeyboardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyboardRepository extends CrudRepository<KeyboardEntity,Long> {
}
