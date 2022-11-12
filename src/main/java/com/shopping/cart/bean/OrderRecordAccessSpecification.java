package com.shopping.cart.bean;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;

public class OrderRecordAccessSpecification implements Specification<Order>{


	    private Order filter;
		private LocalDateTime dateMin;
		private LocalDateTime dateMax;

	    public OrderRecordAccessSpecification(Order filter, LocalDateTime dateMin, LocalDateTime dateMax) {
	        super();
	        this.filter = filter;
			this.dateMin=dateMin;
			this.dateMax=dateMax;
	    }

	    public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> cq,
	            CriteriaBuilder cb) {

	        Predicate p = cb.disjunction();

	        if (dateMax !=null && dateMin !=null) {
	            p.getExpressions().add(
	                    cb.and(
								cb.lessThanOrEqualTo(
										root.get("orderDate"), dateMax
								),
								cb.greaterThanOrEqualTo(
										root.get("orderDate"), dateMin
								)
						)
				);
	        }
	        return p;
	    }
	}

