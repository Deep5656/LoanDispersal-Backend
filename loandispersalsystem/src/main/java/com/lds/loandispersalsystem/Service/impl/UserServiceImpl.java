package com.lds.loandispersalsystem.Service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lds.loandispersalsystem.Entity.User;
import com.lds.loandispersalsystem.Exception.ResourceNotFoundException;
import com.lds.loandispersalsystem.Repository.UserRepository;
import com.lds.loandispersalsystem.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User createUser(User user) throws Exception {
        Integer intval = restTemplate.getForObject("http://localhost:9091/eligible",Integer.class);
        user.setEligible(intval);
       
        if(user.getEligible() == 1){
            System.out.println("User is Eligble");
            userRepository.save(user);
            return user;
        }else{
            System.out.println("User is Not Eligble");
            throw new Exception("User is not Eligble"); 
        }  
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User getUser(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with given ID does Not Exist" + userId));
        return user;
    }

    @Override
    public void deleteUser(int userId) {
       this.userRepository.deleteById(userId);
    }

    @Override
    public User update(User user) {
       return userRepository.save(user);
    }

}
