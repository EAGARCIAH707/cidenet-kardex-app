package com.cidenet.kardexapp.service.kardex;

import com.cidenet.kardexapp.commons.domains.generic.KardexDTO;
import com.cidenet.kardexapp.model.entities.KardexEntity;
import com.cidenet.kardexapp.model.entities.ProductEntity;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface IKardexService {
    KardexDTO createKardexDTO(ProductEntity productEntity);

    Optional<KardexEntity> createKardex(KardexDTO kardexDTO);

    Optional<KardexEntity> createKardexFromProduct(ProductEntity productEntity);

    KardexDTO findKardexById(Integer kardexId) throws NotFoundException;

    KardexEntity findKardex(Integer kardexId) throws NotFoundException;

    List<KardexEntity> findAll();

    void updateKardex(KardexEntity kardexEntity);
}
