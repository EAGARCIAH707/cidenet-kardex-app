package com.cidenet.kardexapp.service.kardex.impl;

import com.cidenet.kardexapp.commons.converter.KardexConverter;
import com.cidenet.kardexapp.commons.domains.generic.KardexDTO;
import com.cidenet.kardexapp.model.entities.KardexEntity;
import com.cidenet.kardexapp.model.entities.ProductEntity;
import com.cidenet.kardexapp.repository.kardex.impl.KardexRepositoryFacade;
import com.cidenet.kardexapp.service.kardex.IKardexService;
import javassist.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class KardexServiceImpl implements IKardexService {
    private final KardexRepositoryFacade kardexRepository;
    private final KardexConverter kardexConverter;


    public KardexServiceImpl(KardexRepositoryFacade kardexRepositoryFacade, KardexConverter kardexConverter) {
        this.kardexRepository = kardexRepositoryFacade;
        this.kardexConverter = kardexConverter;

    }

    @Override
    public KardexDTO createKardexDTO(ProductEntity productEntity) {
        log.info("Create kardex of product,{}", productEntity);
        return kardexConverter.converterProductToKardexDTO(productEntity);
    }

    @Override
    public Optional<KardexEntity> createKardex(KardexDTO kardexDTO) {
        log.info("Create kardex of kardex,{}", kardexDTO);
        return kardexRepository.save(kardexConverter.converterKardexDTOToKardexEntity(kardexDTO));
    }

    @Override
    public Optional<KardexEntity> createKardexFromProduct(ProductEntity productEntity) {
        return createKardex(createKardexDTO(productEntity));
    }

    @Override
    public KardexDTO findKardexById(Integer kardexId) throws NotFoundException {
        Optional<KardexEntity> kardex = kardexRepository.findById(kardexId);
        if (kardex.isPresent()) {
            return kardexConverter.converterProdEntityToProdDTO(kardex.get());
        } else {
            log.error("Kardex not found,{}", kardexId);
            throw new NotFoundException("resource not found <KardexEntity>");
        }
    }

    @Override
    public KardexEntity findKardex(Integer kardexId) throws NotFoundException {
        Optional<KardexEntity> kardex = kardexRepository.findById(kardexId);
        if (kardex.isPresent()) {
            return kardex.get();
        } else {
            log.error("Kardex not found,{}", kardexId);
            throw new NotFoundException("Not found Kardex");
        }
    }

    @Override
    public List<KardexEntity> findAll() {
        return kardexRepository.findAll();
    }

    @Override
    public void updateKardex(KardexEntity kardexEntity) {
        log.error("Save kardex,{}", kardexEntity);
        kardexRepository.save(kardexEntity);
    }
}