package com.lds.loandispersalsystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lds.loandispersalsystem.Entity.User;
import com.lds.loandispersalsystem.Service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    // create user
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) throws Exception {
        User createUser = this.userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }

    // get user
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> allUsers = this.userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(allUsers);
    }

    // get single user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable("userId") int userId) {
        User user = this.userService.getUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    // update user
    @PutMapping("{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("userId") int userId) throws Exception {
        User user2 = this.userService.getUser(userId);
      
        user2.setAge(user.getAge());
        user2.setAmount(user.getAmount());
        user2.setIncome(user.getIncome());
        user2.setCreditHistory(user.getCreditHistory());
        user2.setDetails(user.getDetails());
        user2.setEligible(user.getEligible());
        user2.setName(user.getName());

        User updateUser = this.userService.update(user2);

        return ResponseEntity.status(HttpStatus.OK).body(updateUser);
    }

    // delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> delete(@PathVariable("userId") int userId) {
        this.userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
