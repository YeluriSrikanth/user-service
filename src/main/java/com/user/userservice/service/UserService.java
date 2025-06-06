package com.user.userservice.service;


import com.user.userservice.dto.UserDto;
import com.user.userservice.entity.User;
import com.user.userservice.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public ResponseEntity<User> saveuser(User user){
        log.info("");
      //  User user = null;
       return  ResponseEntity.of(Optional.of(userRepo.save(user)));
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }


    public Optional<User> findUser(int id) {
        return userRepo.findById(id);
    }


    public User updateAccountStatus(int userId, double usedAmount) {
        Optional<User> userDetailsFromDB = findUser(userId);
        User user=userDetailsFromDB.get();
        user.setAvailableAmount(user.getAvailableAmount() - usedAmount);
        return userRepo.save(user);
    }
}
