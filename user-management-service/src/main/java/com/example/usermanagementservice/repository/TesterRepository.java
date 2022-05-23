package com.example.usermanagementservice.repository;

import com.example.usermanagementservice.entity.TesterEntity;
import com.example.usermanagementservice.util.response.BaseResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by Hak Sokheng
 * Date     : 07/Jun/2021, 2:35 PM
 * Email    : sokheng.hak@prasac.com.kh
 */
@Repository
public interface TesterRepository extends JpaRepository<TesterEntity, Long> {

    TesterEntity findByIdAndStatusIsTrue(Long testerId);

    @Query("SELECT te.id as id, te.staffId as staffId, te.name as name, te.nameKh as nameKh FROM TesterEntity te " +
            "where (te.staffId like %?1% or te.name like %?1% or te.nameKh like %?1%) and te.status = true ")
    List<BaseResponse> findAllMemberAutoComplete(@Param("query") String query);
}
