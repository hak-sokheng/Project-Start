package com.example.usermanagementservice.service;
import com.example.usermanagementservice.dto.request.UserRequest;
import com.example.usermanagementservice.dto.response.PaginationResponse;
import com.example.usermanagementservice.dto.response.UserResponse;
import com.example.usermanagementservice.entity.UserEntity;
import com.example.usermanagementservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Hak Sokheng
 * Date     : 3/21/2022, 2:15 PM
 * Email    : sokheng.hak@prasac.com.kh
 */

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final EntityManager entityManager;

    public UserServiceImpl(UserRepository userRepository, EntityManager entityManager) {
        this.userRepository = userRepository;
        this.entityManager = entityManager;
    }

    @Override
    public UserResponse createOrUpdate(UserRequest userRequest, Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(new UserEntity());
        userEntity.setNameEn(userRequest.getNameEn());
        userEntity.setNameKh(userRequest.getNameKh());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setStatus(userRequest.isStatus());
        userEntity.setCreated_date(userRequest.getCreated_date());
        userRepository.save(userEntity);
        return new UserResponse(userEntity);
    }

    @Override
    public UserResponse findUserById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.map(UserResponse::new).orElse(null);
    }

    @Override
    public PaginationResponse findAllUserByPagination(String query, Integer page, Integer size) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
        Root<UserEntity> userEntity = criteriaQuery.from(UserEntity.class);
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(query)){
            final Predicate predicateEn = criteriaBuilder.like(criteriaBuilder.lower(userEntity.get("nameEn")), "%" + query + "%");
            final Predicate predicateKh = criteriaBuilder.like(criteriaBuilder.lower(userEntity.get("nameKh")), "%" + query + "%");
            final Predicate freeText = criteriaBuilder.or(predicateEn, predicateKh);
            predicates.add(freeText);
        }

        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0]))).orderBy(criteriaBuilder.desc(userEntity.get("id")));
        PaginationResponse pagination = new PaginationResponse(page, size, entityManager.createQuery(criteriaQuery).getResultList().size());
        List<UserEntity> userEntities = entityManager.createQuery(criteriaQuery).setFirstResult(pagination.getOffset()).setMaxResults(pagination.getLimit()).getResultList();
        PaginationResponse response = new PaginationResponse(pagination.getTotal(), pagination.getOffset(), pagination.getLimit(), userEntities);
        return response;
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "delete success!";
    }
}
