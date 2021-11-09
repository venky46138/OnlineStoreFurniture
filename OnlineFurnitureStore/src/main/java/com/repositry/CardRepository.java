package com.repositry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Card;
@Repository
public interface CardRepository extends JpaRepository<Card,Long> {

}
