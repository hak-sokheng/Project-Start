package com.example.usermanagementservice.repository;

import com.example.usermanagementservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Hak Sokheng
 * Date     : 3/21/2022, 2:12 PM
 * Email    : sokheng.hak@prasac.com.kh
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
