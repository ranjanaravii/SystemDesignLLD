package com.developer.LLD.SplitWise.service;

import com.developer.LLD.SplitWise.model.User;
import com.developer.LLD.SplitWise.repository.UserRepository;

public class UserService {

    public User createUser(String name, String email)
    {
        if(UserRepository.userHashMap.containsKey(email)) {
            return UserRepository.userHashMap.get(email);
        }

        User newUser = new User(name, email);
        UserRepository.userHashMap.put(email, newUser);
        return newUser;
    }

}
