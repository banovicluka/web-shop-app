package com.luka.webshop.services;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.luka.webshop.exceptions.NotFoundException;
import com.luka.webshop.models.dto.Message;

public interface MessageService {

    Message insertMessage(Message message) throws NotFoundException;

    Message findById(Integer id) throws NotFoundException;
}
