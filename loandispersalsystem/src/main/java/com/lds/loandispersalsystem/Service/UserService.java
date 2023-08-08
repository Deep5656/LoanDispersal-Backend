package com.lds.loandispersalsystem.Service;

import java.util.List;

import com.lds.loandispersalsystem.Entity.User;

public interface UserService {
    
    //Create user
    User createUser(User user) throws Exception;

    //get all user
    List<User>getAllUsers();

    //get single user
    User getUser(int userId);

    //delete user
    void deleteUser(int userId);

    //update user
    User update(User user);
    
}
