package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/student")
@RestController
public class StudentController {
	
	@Autowired
	StudentService service; 
	
	
	@PostMapping("/save")
	@ApiOperation(value="This method is used to store the information of students")
	@ApiResponses(value= {@ApiResponse(code=200,message="ok"),@ApiResponse(code=404,message="notfound")})
	public ResponseEntity<Student> getAllStudent(@RequestBody Student student){
		Student std= service.saveStudent(student);
		return ResponseEntity.ok().body(std);
	}
	
	@GetMapping("/getAll")
	@ApiOperation(value="This method is used to get all students detail")
	@ApiResponses(value= {@ApiResponse(code=200,message="ok"),@ApiResponse(code=404,message="notfound")})
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> list=service.getAllStudents();
		return ResponseEntity.ok().body(list);
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value="This method is used to delete a particular student by there id")
	@ApiResponses(value= {@ApiResponse(code=200,message="ok"),@ApiResponse(code=404,message="notfound")})
	public ResponseEntity<Void> deleteById(@PathVariable Integer id){
		service.deleteStudentById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping("/update")
	@ApiOperation(value="This method is used to update a data of particular student")
	@ApiResponses(value= {@ApiResponse(code=200,message="ok"),@ApiResponse(code=404,message="notfound")})
	public Student updateStudent(@RequestBody Student std) {
		Student student=service.updateStudent(std);
		return student;
	}

}
