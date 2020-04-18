package com.cidenet.kardexapp.service.kardex;

import com.cidenet.kardexapp.commons.domains.generic.KardexDTO;
import com.cidenet.kardexapp.model.entities.KardexEntity;
import com.cidenet.kardexapp.model.entities.ProductEntity;
import javassist.NotFoundException;

import java.util.Optional;

public interface IKardexService {
    KardexDTO createKardexDTO(ProductEntity productEntity);

    Optional<KardexEntity> createProdutc(KardexDTO kardexDTO);

    Optional<KardexEntity> createKardexFromProduct(ProductEntity productEntity);

    KardexEntity findKardexById(Integer kardexId) throws NotFoundException;
}
