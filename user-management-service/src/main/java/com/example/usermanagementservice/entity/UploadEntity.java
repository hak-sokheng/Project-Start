package com.example.usermanagementservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Hak Sokheng
 * Date     : 5/14/2021, 4:05 PM
 * Email    : sokheng.hak@prasac.com.kh
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "upload_file")
@EqualsAndHashCode(callSuper = true)
public class UploadEntity extends AuditEntity {

    @Id
    @Column(name = "upload_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "path")
    private String path;

    @Column(name = "status")
    private Boolean status;
}
