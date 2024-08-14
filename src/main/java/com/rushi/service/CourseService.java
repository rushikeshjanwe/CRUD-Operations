package com.rushi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rushi.entity.CourseEntity;
import com.rushi.repo.CourseRepo;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepo courseRepo;

	public CourseService(CourseRepo courseRepo) {
		this.courseRepo = courseRepo;
	}
	
	public String upsert(CourseEntity courseEntity) {  //Update and Insert 
		courseRepo.save(courseEntity);
		return "Success";
	}
    
	public CourseEntity getById(Integer id) {
		Optional<CourseEntity> byId = courseRepo.findById(id);
		
		if(byId.isPresent()) {
			return byId.get();
		}
		
		return null;
	}
	
	
	public List<CourseEntity> getAllCourses(){
		return courseRepo.findAll();
	}
	
	
	public String deleteById(Integer id) {
		if(courseRepo.existsById(id)) {
			courseRepo.deleteById(id);
			return "Delete Success";
		}
		else {
			return "No Record Found";
		}
	}
	
}
