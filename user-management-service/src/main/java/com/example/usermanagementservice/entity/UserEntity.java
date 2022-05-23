package com.example.usermanagementservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Hak Sokheng
 * Date     : 3/21/2022, 1:48 PM
 * Email    : sokheng.hak@prasac.com.kh
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private long id;

    @Column(name = "name_en")
    private String nameEn;

    @Column(name = "name_kh")
    private String nameKh;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private boolean status;

    @Column(name = "created_date")
    private Date created_date;


}
