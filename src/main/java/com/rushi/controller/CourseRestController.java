package com.rushi.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.rushi.entity.CourseEntity;
import com.rushi.service.CourseService;

@RestController
public class CourseRestController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody CourseEntity courseEntity){
		String status = courseService.upsert(courseEntity);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<CourseEntity> getCourse(@PathVariable Integer id){
		CourseEntity byId = courseService.getById(id);
		return new ResponseEntity<>(byId,HttpStatus.OK);
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<CourseEntity>> getAllCourses(){
	List<CourseEntity> allcourses = courseService.getAllCourses();
	return new ResponseEntity<>(allcourses,HttpStatus.OK);
	}
	
	@PutMapping("/course")
	public ResponseEntity<String> updateCourse(@RequestBody CourseEntity courseEntity){
		String update = courseService.upsert(courseEntity);
		return new ResponseEntity<>(update,HttpStatus.OK);
	}
	
	@DeleteMapping("/course/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable Integer id){
		String delete = courseService.deleteById(id);
		return new ResponseEntity<>(delete,HttpStatus.OK);
	}

}
