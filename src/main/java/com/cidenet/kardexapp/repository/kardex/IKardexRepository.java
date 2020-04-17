package com.cidenet.kardexapp.repository.kardex;

import com.cidenet.kardexapp.model.entities.KardexEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKardexRepository extends JpaRepository<KardexEntity, Integer> {
}
