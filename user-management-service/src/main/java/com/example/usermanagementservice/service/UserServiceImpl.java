package com.example.usermanagementservice.service;
import com.example.usermanagementservice.client.UserRequestc;
import com.example.usermanagementservice.dto.request.UserRequest;
import com.example.usermanagementservice.dto.response.PaginationResponse;
import com.example.usermanagementservice.dto.response.UserResponse;
import com.example.usermanagementservice.entity.UserEntity;
import com.example.usermanagementservice.repository.UserRepository;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collections;
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
    private final RestTemplate restTemplate;

    public UserServiceImpl(UserRepository userRepository, EntityManager entityManager, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.entityManager = entityManager;
        this.restTemplate = restTemplate;
    }

    //post
    @Override
    public UserResponse createUser(UserRequest userRequest, UserRequestc userRequestc) {
        UserEntity userEntity = new UserEntity();

        postPlainJSON(userRequestc);

//        userEntity.setNameEn(userRequest.getNameEn());
//        userEntity.setNameKh(userRequest.getNameKh());
//        userEntity.setEmail(userRequest.getEmail());
//        userEntity.setPassword(userRequest.getPassword());
//        userEntity.setStatus(userRequest.isStatus());
//        userEntity.setCreated_date(userRequest.getCreated_date());
        userRepository.save(userEntity);
        return new UserResponse(userEntity);
    }


    public UserEntity postPlainJSON(UserRequestc userRequestcc){
        String url = "http://localhost:3001/users/post";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        UserRequestc userRequestc = new UserRequestc(
                userRequestcc.getUsername(),userRequestcc.getEmail(),userRequestcc.getPassword(),true);
        HttpEntity<UserRequestc> request = new HttpEntity<>(userRequestc, headers);
//        ResponseEntity<UserResponse> response = restTemplate.postForEntity(url, request, UserResponse.class);
        return restTemplate.postForObject(url, request, UserEntity.class, userRequestcc);
    }

    //update
    @Override
    public UserResponse updateUser(UserRequest userRequest, UserRequestc userRequestc, Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(new UserEntity());

        putPlainJSON(userRequestc,id);

//        userEntity.setNameEn(userRequest.getNameEn());
//        userEntity.setNameKh(userRequest.getNameKh());
//        userEntity.setEmail(userRequest.getEmail());
//        userEntity.setPassword(userRequest.getPassword());
//        userEntity.setStatus(userRequest.isStatus());
//        userEntity.setCreated_date(userRequest.getCreated_date());
        userRepository.save(userEntity);
        return new UserResponse(userEntity);
    }

    public UserEntity putPlainJSON(UserRequestc userRequestcc, Long id){
        String url = "http://localhost:3001/users/{id}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        UserRequestc userRequestc = new UserRequestc(
                userRequestcc.getUsername(),userRequestcc.getEmail(),userRequestcc.getPassword(),true);
        HttpEntity<UserRequestc> request = new HttpEntity<>(userRequestc, headers);
        ResponseEntity<UserEntity> response = this.restTemplate.exchange(url, HttpMethod.PUT, request, UserEntity.class, id);
        return response.getBody();
    }

    //get by Id
    @Override
    public UserResponse findUserById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);

        UserEntity userEntities = getPostsPlainJSON(id);
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userEntity.get().getId());
        userResponse.setPassword(userEntities.getPassword());
        userResponse.setEmail(userEntities.getEmail());
        userResponse.setNameEn(userEntity.get().getNameEn());
        userResponse.setNameKh(userEntity.get().getNameKh());
        userResponse.setCreated_date(userEntity.get().getCreated_date());
        return userResponse;
    }
    public UserEntity getPostsPlainJSON(Long id) {
        String url = "http://localhost:3001/users/{id}";
        return this.restTemplate.getForObject(url, UserEntity.class,id);
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
        deletePost(id);
        userRepository.deleteById(id);
        return "delete success!";
    }

    public void deletePost(Long id) {
        String url = "http://localhost:3001/users/{id}";

        // send DELETE request to delete post with `id` 10
        this.restTemplate.delete(url, id);
    }
}
