package com.example.authservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Hak Sokheng
 * Date     : 4/25/2022, 3:17 PM
 * Email    : sokheng.hak@prasac.com.kh
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_log_activity")
public class UserLogActivityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "last_login_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginAt;

}
