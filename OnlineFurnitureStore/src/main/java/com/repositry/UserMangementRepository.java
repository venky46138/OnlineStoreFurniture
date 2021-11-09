package com.repositry;
import org.springframework.stereotype.Repository;

import com.entity.FurnitureUser;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface UserMangementRepository extends JpaRepository<FurnitureUser, Integer>{

}
