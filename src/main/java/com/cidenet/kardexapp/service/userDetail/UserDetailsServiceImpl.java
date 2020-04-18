package com.cidenet.kardexapp.service.userDetail;

import com.cidenet.kardexapp.model.entities.UserEntity;
import com.cidenet.kardexapp.repository.user.impl.UserRepositoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepositoryFacade userRespository;

    @Autowired
    public UserDetailsServiceImpl(UserRepositoryFacade userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        Optional<UserEntity> optUser = userRespository.findUserByEmail(email);
        if (!optUser.isPresent()) throw new UsernameNotFoundException(email);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(optUser.get().getRoleId().getRole()));
        return new org.springframework.security.core.userdetails.User(optUser.get().getEmail(),
                optUser.get().getPassword(), grantedAuthorities);
    }
}
