package com.luka.webshop.services;

import com.luka.webshop.exceptions.NotFoundException;
import com.luka.webshop.models.dto.User;
import com.luka.webshop.models.entities.UserEntity;
import org.aspectj.weaver.ast.Not;

public interface UserService {

    User findById(Integer id) throws NotFoundException;

    User findUserByUsername(String username) throws NotFoundException;

    Integer findIdByUsername(String username) throws NotFoundException;

    User registerUser(User user)throws  NotFoundException;

    User updateAccStatus(User user)throws NotFoundException;
}
