package com.cidenet.kardexapp.service.out;

import com.cidenet.kardexapp.commons.domains.generic.OutDTO;
import com.cidenet.kardexapp.commons.exceptions.SystemException;
import com.cidenet.kardexapp.model.entities.KardexEntity;
import javassist.NotFoundException;

public interface IOutService {
    OutDTO createOut(OutDTO outDTO) throws SystemException, NotFoundException;

    OutDTO calculateValues(OutDTO outDTO, KardexEntity kardex);
}
