package com.guttester.volts_manager.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.guttester.volts_manager.Model.User;
import com.guttester.volts_manager.Service.SUser;

@RestController
@RequestMapping({"/users"})
public class CUser {
   @Autowired
   private SUser serviceUser;

   public CUser() {
   }

   @GetMapping
   public List<User> getAllUsers() {
      return this.serviceUser.findAll();
   }

   @GetMapping("/{id}")
   public ResponseEntity<User> getUserById(@PathVariable UUID id) {
       return serviceUser.findById(id)
               .map(user -> ResponseEntity.ok(user)) 
               .orElseGet(() -> ResponseEntity.notFound().build());
   }

   @PostMapping
   public User createUser(@RequestBody User user) {
      return this.serviceUser.save(user);
   }

   @PutMapping({"/{id}"})
   public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody User updatedUser) {
      Optional<User> existing = this.serviceUser.findById(id);
      if (existing.isPresent()) {
         updatedUser.setId(id);
         return ResponseEntity.ok(this.serviceUser.save(updatedUser));
      } else {
         return ResponseEntity.notFound().build();
      }
   }

   @DeleteMapping({"/{id}"})
   public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
      this.serviceUser.deleteById(id);
      return ResponseEntity.noContent().build();
   }
}