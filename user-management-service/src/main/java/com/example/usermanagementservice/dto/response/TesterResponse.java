package com.example.usermanagementservice.dto.response;
import com.example.usermanagementservice.entity.TesterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Hak Sokheng
 * Date     : 04-Jun-2021, 9:43 pm
 * Email    : sormanos.tob@prasac.com.kh
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TesterResponse implements Serializable {
    private Long id;
    private String staffId;
    private String name;
    private String nameKh;
    private Boolean status;

    public TesterResponse(TesterEntity testerEntity) {
        this.id = testerEntity.getId();
        this.staffId = testerEntity.getStaffId();
        this.name = testerEntity.getName();
        this.nameKh = testerEntity.getNameKh();
        this.status = testerEntity.getStatus();
    }
}
