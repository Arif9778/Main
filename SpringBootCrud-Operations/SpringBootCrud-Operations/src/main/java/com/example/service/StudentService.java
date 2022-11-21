package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo repo;

	public Student saveStudent(Student student) {
		return repo.save(student);

	}

	public List<Student> getAllStudents() {
		return (List<Student>) repo.findAll();
	}

	/*public Student deleteStudent(Integer id) {
		return repo.deleteStudentById(id);
	}*/
	
	public void deleteStudentById(Integer id) {
		repo.deleteById(id);
	}

	public Student updateStudent(Student std) {
		return repo.save(std);
		
	}

}
