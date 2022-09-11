package com.nickcassandra.repo;

import com.nickcassandra.entity.Student;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CassandraRepository<Student, Long> {

}
