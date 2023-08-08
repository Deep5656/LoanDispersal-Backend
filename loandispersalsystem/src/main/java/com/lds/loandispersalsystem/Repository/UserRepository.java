package com.lds.loandispersalsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lds.loandispersalsystem.Entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    
}
