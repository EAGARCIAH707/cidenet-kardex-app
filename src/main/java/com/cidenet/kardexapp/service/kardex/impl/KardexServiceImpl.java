package com.cidenet.kardexapp.service.kardex.impl;

import com.cidenet.kardexapp.commons.converter.KardexConverter;
import com.cidenet.kardexapp.commons.domains.generic.KardexDTO;
import com.cidenet.kardexapp.model.entities.KardexEntity;
import com.cidenet.kardexapp.model.entities.ProductEntity;
import com.cidenet.kardexapp.repository.kardex.impl.KardexRepositoryFacade;
import com.cidenet.kardexapp.service.kardex.IKardexService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KardexServiceImpl implements IKardexService {
    private final KardexRepositoryFacade kardexRepository;
    private final KardexConverter kardexConverter;

    public KardexServiceImpl(KardexRepositoryFacade kardexRepositoryFacade, KardexConverter kardexConverter) {
        this.kardexRepository = kardexRepositoryFacade;
        this.kardexConverter = kardexConverter;
    }

    @Override
    public KardexDTO createKardexDTO(ProductEntity productEntity) {
        return kardexConverter.converterProductToKardexDTO(productEntity);
    }

    @Override
    public Optional<KardexEntity> createProdutc(KardexDTO kardexDTO) {
        return kardexRepository.save(kardexConverter.converterKardexDTOToKardexEntity(kardexDTO));
    }

    @Override
    public Optional<KardexEntity> createKardexFromProduct(ProductEntity productEntity) {
        return createProdutc(createKardexDTO(productEntity));
    }

    @Override
    public KardexEntity findKardexById(Integer kardexId) throws NotFoundException {
        Optional<KardexEntity> kardex = kardexRepository.findById(kardexId);
        if (kardex.isPresent()) {
            return kardex.get();
        } else {
            throw new NotFoundException("resource not found <KardexEntity>");
        }
    }
}