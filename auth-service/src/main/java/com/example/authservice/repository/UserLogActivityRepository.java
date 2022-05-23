package com.example.authservice.repository;

import com.example.authservice.entity.UserLogActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Hak Sokheng
 * Date     : 4/25/2022, 3:59 PM
 * Email    : sokheng.hak@prasac.com.kh
 */
@Repository
public interface UserLogActivityRepository extends JpaRepository<UserLogActivityEntity, Long> {
}
