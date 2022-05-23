package com.example.usermanagementservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tester")
@EqualsAndHashCode(callSuper = true)
public class TesterEntity extends AuditEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "staff_id", unique = true)
    private String staffId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nameKh")
    private String nameKh;

    @Column(name = "status")
    private Boolean status;

}
