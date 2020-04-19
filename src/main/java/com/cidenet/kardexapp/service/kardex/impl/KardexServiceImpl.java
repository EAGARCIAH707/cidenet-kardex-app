package com.cidenet.kardexapp.service.kardex.impl;

import com.cidenet.kardexapp.commons.converter.KardexConverter;
import com.cidenet.kardexapp.commons.domains.generic.KardexDTO;
import com.cidenet.kardexapp.model.entities.InEntity;
import com.cidenet.kardexapp.model.entities.KardexEntity;
import com.cidenet.kardexapp.model.entities.OutEntity;
import com.cidenet.kardexapp.model.entities.ProductEntity;
import com.cidenet.kardexapp.repository.kardex.impl.KardexRepositoryFacade;
import com.cidenet.kardexapp.service.kardex.IKardexService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public KardexEntity updateKardexFromIn(InEntity inEntity, KardexEntity kardexEntity) throws NotFoundException {
        kardexEntity.setQuantity(kardexEntity.getQuantity() + inEntity.getQuantity());
        kardexEntity.setTotalCost(inEntity.getTotalValue() + kardexEntity.getTotalCost());
        kardexEntity.setUnitCost(kardexEntity.getTotalCost() /
                (kardexEntity.getQuantity() == 0 ? 1 : kardexEntity.getQuantity()));
        return saveKardex(kardexEntity);
    }

    @Override
    public KardexEntity updateKardexFromOut(OutEntity outEntity, KardexEntity kardexEntity) throws NotFoundException {
        kardexEntity.setQuantity(kardexEntity.getQuantity() - outEntity.getQuantity());
        kardexEntity.setTotalCost(kardexEntity.getTotalCost() - outEntity.getTotalValue());
        kardexEntity.setUnitCost(kardexEntity.getTotalCost() /
                (kardexEntity.getQuantity() == 0 ? 1 : kardexEntity.getQuantity()));
        return saveKardex(kardexEntity);
    }

    @Override
    public KardexEntity saveKardex(KardexEntity kardexEntity) throws NotFoundException {
        Optional<KardexEntity> kardex = kardexRepository.save(kardexEntity);
        if (kardex.isPresent()) {
            return kardex.get();
        } else {
            throw new NotFoundException("Unable to update resource<KardexEntity>");
        }
    }

    @Override
    public List<KardexEntity> findAll() {
        return kardexRepository.findAll();
    }
}