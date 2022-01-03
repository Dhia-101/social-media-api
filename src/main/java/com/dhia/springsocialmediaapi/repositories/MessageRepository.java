package com.dhia.springsocialmediaapi.repositories;

import com.dhia.springsocialmediaapi.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findBySender(Long senderId);
}
