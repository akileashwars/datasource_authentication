package com.example.demo.repository;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	/*
	 * @Query( value = "SELECT * FROM user u WHERE u.user_id = :userId", nativeQuery
	 * = true ) Optional<User> findByName(@Param(value = "userId") String userId);
	 */
	User findByUserName(String userName);
}