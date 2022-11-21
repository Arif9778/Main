package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Student;
import com.example.repo.StudentRepo;
import com.example.service.StudentService;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StudentServiceTest {
	
	@InjectMocks
	StudentService studentService;
	
	@Mock
	StudentRepo studentRepo;
	
	@Test
	public void saveStudentTest() {
		Student student=new Student(3, "Pawan", "Pune", 7896541236l);
		when(studentRepo.save(student)).thenReturn(student);
		assertEquals(student, studentService.saveStudent(student));
	}
	
	@Test
	public void getAllStudentsTest(){
		List<Student> list=new ArrayList<>();
		list.add(new Student(1, "Sujit","Pune", 9854632154l));
		list.add(new Student(2, "Shivani","Nashik", 8854632154l));
		list.add(new Student(3, "Swarali","Mumbai", 7854632154l));
		
		when(studentRepo.findAll()).thenReturn(list);
		List<Student> studentList=studentService.getAllStudents();
		assertEquals(list, studentList);
		
	}
	
	/*@Test
	public void deleteByIdTest() {
		Student std=new Student(2, "Swapnil", "Pune", 9856321474l);
		studentRepo.save(std);
		studentRepo.deleteById(std.getId());//expexted object
		Student actual=studentService.deleteStudent(std.getId());
		//studentService.deleteStudentById(std.getId());
		assertEquals(null, actual);
	}*/

}
