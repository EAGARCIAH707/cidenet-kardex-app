package com.cidenet.kardexapp.repository.in;

import com.cidenet.kardexapp.model.entities.InEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInRepository extends JpaRepository<InEntity, Integer> {
}
