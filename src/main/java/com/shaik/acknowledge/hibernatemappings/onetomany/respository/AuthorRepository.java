package com.shaik.acknowledge.hibernatemappings.onetomany.respository;

import com.shaik.acknowledge.hibernatemappings.onetomany.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
