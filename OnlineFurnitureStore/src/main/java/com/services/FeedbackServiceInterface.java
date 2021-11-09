package com.services;
import java.util.List;

import com.entity.Review;
import com.exception.CustomerFeedbackException;

public interface FeedbackServiceInterface {
Review addReview(Review review) throws CustomerFeedbackException;
	
	Review updateReview(int feedbackId,Review review) throws CustomerFeedbackException;

	Review viewReview(int feedbackId) throws CustomerFeedbackException;

	List<Review> viewAllReview() throws CustomerFeedbackException;

}
