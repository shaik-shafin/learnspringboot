package com.shaik.acknowledge.hibernatemappings.onetomany.respository;

import com.shaik.acknowledge.hibernatemappings.onetomany.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
