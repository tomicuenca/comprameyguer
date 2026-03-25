package com.tomicuenca.comprameyguer.repository;

import com.tomicuenca.comprameyguer.entity.MonitorEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MonitorRepository extends CrudRepository<MonitorEntity, Long> {
    List<MonitorEntity> findAll();
}
