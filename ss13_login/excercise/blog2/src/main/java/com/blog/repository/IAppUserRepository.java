package com.blog.repository;

import com.blog.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String userName);
}
