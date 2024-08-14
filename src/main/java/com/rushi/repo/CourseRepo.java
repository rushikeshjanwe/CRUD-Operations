package com.rushi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rushi.entity.CourseEntity;


public interface CourseRepo extends JpaRepository<CourseEntity, Integer>{

}
