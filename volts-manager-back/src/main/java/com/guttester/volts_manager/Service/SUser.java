package com.guttester.volts_manager.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guttester.volts_manager.Model.User;
import com.guttester.volts_manager.Repository.RUser;

@Service
public class SUser {

   @Autowired
   private RUser repositoryUser;

   public List<User> findAll() {
      return repositoryUser.findAll();
   }

   public Optional<User> findById(UUID id) {
      return repositoryUser.findById(id);
   }

   public User save(User obj) {
      return repositoryUser.save(obj);
   }

   public void deleteById(UUID id) {
      repositoryUser.deleteById(id);
   }
}