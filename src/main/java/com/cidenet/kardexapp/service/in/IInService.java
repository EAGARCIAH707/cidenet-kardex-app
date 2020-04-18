package com.cidenet.kardexapp.service.in;

import com.cidenet.kardexapp.commons.domains.generic.InDTO;
import com.cidenet.kardexapp.commons.exceptions.SystemException;
import com.cidenet.kardexapp.model.entities.InEntity;

public interface IInService {
    InEntity createIn(InDTO inDTO) throws SystemException;
}