package com.example.back.service.serviceiplm;

import com.example.back.domain.entities.User;
import com.example.back.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

//    private final UserVal
    @Override
    public User getByEmailValidation(String email) {
        return null;
    }

    @Override
    public User getByUsernameValidation(String username) {
        return null;
    }

    @Override
    public boolean promoteUser(String id) throws Exception {
        return false;
    }

    @Override
    public boolean demoteUser(String id) throws Exception {
        return false;
    }

    @Override
    public boolean deleteUserById(String id) throws Exception {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
