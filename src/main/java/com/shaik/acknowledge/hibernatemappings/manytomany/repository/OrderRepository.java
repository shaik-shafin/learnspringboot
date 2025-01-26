package com.shaik.acknowledge.hibernatemappings.manytomany.repository;

import com.shaik.acknowledge.hibernatemappings.manytomany.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
