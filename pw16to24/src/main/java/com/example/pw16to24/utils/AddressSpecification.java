package com.example.pw16to24.utils;

import com.example.pw16to24.models.Address;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.Attribute;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class AddressSpecification implements Specification<Address> {
    private final String criteria;

    @Override
    public Predicate toPredicate(Root<Address> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        for (Attribute<? super Address, ?> attribute : root.getModel().getAttributes()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(criteriaBuilder.toString(root.get(attribute.getName()))), "%" + criteria.toLowerCase() + "%"));
        }
        return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
    }
}