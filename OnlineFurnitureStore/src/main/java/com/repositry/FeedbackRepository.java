package com.repositry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Review;
@Repository

public interface FeedbackRepository extends JpaRepository<Review,Integer> {
	

}
