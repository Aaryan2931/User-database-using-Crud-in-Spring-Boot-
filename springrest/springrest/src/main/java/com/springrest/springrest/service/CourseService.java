package com.springrest.springrest.service;

import com.springrest.springrest.dto.CourseDelete;
import com.springrest.springrest.dto.CourseUpdateInput;
import com.springrest.springrest.dto.request.CourseInput;
import com.springrest.springrest.entities.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCourses();

    Course getCourse(long courseId);

    Course addCourse(CourseInput course);

    List<Course> updateCourse(CourseUpdateInput courseUpdateInput);

//    public static List<Course> deleteCourse(CourseDelete courseUpdateInput);

    List<Course> deleteCourse(CourseDelete courseDelete);
}

