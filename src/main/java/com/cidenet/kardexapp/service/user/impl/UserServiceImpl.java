package com.cidenet.kardexapp.service.user.impl;

import com.cidenet.kardexapp.repository.user.impl.UserRepositoryFacade;
import com.cidenet.kardexapp.service.user.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepositoryFacade userRespository;

    public UserServiceImpl(UserRepositoryFacade userRespository) {
        this.userRespository = userRespository;
    }
}
