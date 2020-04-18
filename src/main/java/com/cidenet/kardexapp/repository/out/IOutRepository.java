package com.cidenet.kardexapp.repository.out;

import com.cidenet.kardexapp.model.entities.OutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOutRepository extends JpaRepository<OutEntity, Integer> {
}
