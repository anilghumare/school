package com.zensar.springbootdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.springbootdemo.entity.Student;
import com.zensar.springbootdemo.service.StudentService;

@RestController
@RequestMapping("/student-api")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// @RequestMapping(value = "/students/{studentId}",method=RequestMethod.GET)
	@GetMapping(value = "/students/{studentId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Student getStudent(@PathVariable("studentId") int studentId) {
		return studentService.getStudent(studentId);
	}

	// @RequestMapping(value = { "/students", "/listOfStudents"
	// },method=RequestMethod.GET)
	@GetMapping(value = { "/students", "/listOfStudents" }, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	// @RequestMapping(value = "/students",method=RequestMethod.POST)
	@PostMapping(value = "/students", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public void insertStudent(@RequestBody Student student) {

		studentService.insertStudent(student);

	}

	// @RequestMapping(value="/students/{studentId}",method=RequestMethod.PUT)
	@PutMapping(value = "/students/{studentId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public void updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student student) {
		studentService.updateStudent(studentId, student);

	}

	// @RequestMapping(value="/students/{studentId}",method=RequestMethod.DELETE)
	@DeleteMapping("/students/{studentId}")
	public void deleteStudent(@PathVariable("studentId") int studentId) {
		studentService.deleteStudent(studentId);
	}

}
