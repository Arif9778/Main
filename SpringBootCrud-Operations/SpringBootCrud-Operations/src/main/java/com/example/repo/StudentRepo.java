package com.example.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {

	/*@Query(value = "select * from students where id=?1", nativeQuery = true)
	public Student deleteStudentById(Integer id);
	*/
} 
