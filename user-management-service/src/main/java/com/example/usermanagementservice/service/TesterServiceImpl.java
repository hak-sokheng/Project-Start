package com.example.usermanagementservice.service;

import com.example.usermanagementservice.dto.request.TesterRequest;
import com.example.usermanagementservice.dto.response.PaginationResponse;
import com.example.usermanagementservice.dto.response.TesterResponse;
import com.example.usermanagementservice.entity.TesterEntity;
import com.example.usermanagementservice.repository.TesterRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hak Sokheng
 * Date     : 5/17/2022, 11:16 AM
 * Email    : sokheng.hak@prasac.com.kh
 */

@Service
public class TesterServiceImpl implements TesterService {
    private final TesterRepository testerRepository;
    private final EntityManager entityManager;

    public TesterServiceImpl(TesterRepository testerRepository, EntityManager entityManager) {
        this.testerRepository = testerRepository;
        this.entityManager = entityManager;
    }

    @Override
    public TesterResponse createOrUpdateTester(TesterRequest testerRequest, Long id) {
        TesterEntity testerEntity = testerRepository.findById(id).orElse(new TesterEntity());
        testerEntity.setStaffId(testerRequest.getStaffId());
        testerEntity.setName(testerRequest.getName());
        testerEntity.setNameKh(testerRequest.getNameKh());
        testerEntity.setStatus(testerRequest.getStatus());
        testerRepository.save(testerEntity);

        return new TesterResponse(testerEntity);
    }

    @Override
    public TesterResponse findTesterById(Long id) {
        TesterEntity testerEntity = testerRepository.findByIdAndStatusIsTrue(id);
        return new TesterResponse(testerEntity);
    }

    @Override
    public void deleteTester(Long id) {
        testerRepository.deleteById(id);
    }

    @Override
    public PaginationResponse findAllTesterByPagination(String query, Integer page, Integer size) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TesterEntity> criteriaQuery = criteriaBuilder.createQuery(TesterEntity.class);
        Root<TesterEntity> testerEntity = criteriaQuery.from(TesterEntity.class);
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(query)){
            final Predicate predicateEn = criteriaBuilder.like(criteriaBuilder.lower(testerEntity.get("name")), "%" + query + "%");
            final Predicate predicateKh = criteriaBuilder.like(criteriaBuilder.lower(testerEntity.get("nameKh")), "%" + query + "%");
            final Predicate freeText = criteriaBuilder.or(predicateEn, predicateKh);
            predicates.add(freeText);
        }

        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0]))).orderBy(criteriaBuilder.asc(testerEntity.get("id")));
        PaginationResponse pagination = new PaginationResponse(page, size, entityManager.createQuery(criteriaQuery).getResultList().size());
        List<TesterEntity> testerEntities = entityManager.createQuery(criteriaQuery).setFirstResult(pagination.getOffset()).setMaxResults(pagination.getLimit()).getResultList();
        PaginationResponse response = new PaginationResponse(pagination.getTotal(), pagination.getOffset(), pagination.getLimit(), testerEntities);

        return response;
    }

}
