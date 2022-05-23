package com.example.usermanagementservice.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Created by Hak Sokheng
 * Date     : 5/19/2021, 2:31 PM
 * Email    : sokheng.hak@prasac.com.kh
 */
@Data
public class TesterRequest implements Serializable {

    @NotBlank
    private String staffId;

    @NotBlank
    private String name;

    private String nameKh;

    private Boolean status;
}
