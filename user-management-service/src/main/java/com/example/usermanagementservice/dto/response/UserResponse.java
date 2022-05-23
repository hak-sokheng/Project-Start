package com.example.usermanagementservice.dto.response;
import com.example.usermanagementservice.entity.AuditEntity;
import com.example.usermanagementservice.entity.UserEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Hak Sokheng
 * Date     : 3/21/2022, 2:09 PM
 * Email    : sokheng.hak@prasac.com.kh
 */
@Data
public class UserResponse extends AuditEntity implements Serializable{

    private static final long serialVersionUID = 3564850512367259151L;
    private long id;
    private String nameEn;
    private String nameKh;
    private String password;
    private String email;
    private boolean status;
    private Date created_date;

    public UserResponse(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.nameEn = userEntity.getNameEn();
        this.nameKh = userEntity.getNameKh();
        this.email = userEntity.getEmail();
        this.password = userEntity.getPassword();
        this.status = userEntity.isStatus();
        this.created_date = userEntity.getCreated_date();
    }
}
