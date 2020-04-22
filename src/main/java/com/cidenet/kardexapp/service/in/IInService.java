package com.cidenet.kardexapp.service.in;

import com.cidenet.kardexapp.commons.domains.generic.InDTO;
import com.cidenet.kardexapp.commons.domains.generic.KardexDTO;
import com.cidenet.kardexapp.commons.exceptions.SystemException;
import com.cidenet.kardexapp.model.entities.InEntity;
import com.cidenet.kardexapp.model.entities.KardexEntity;
import javassist.NotFoundException;

public interface IInService {
    InDTO createIn(InDTO inDTO) throws SystemException, NotFoundException;

    InDTO calculateValues(InDTO inDTO, KardexDTO kardex);

    void createInFromKardex(KardexEntity kardexEntity);

    void save(InEntity inEntity);
}
