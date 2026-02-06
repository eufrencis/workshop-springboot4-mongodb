package com.nelio.workshopmongo.service;


import com.nelio.workshopmongo.domain.User;
import com.nelio.workshopmongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;


    public List<User> findAll(){
        return repo.findAll();



    }
}
