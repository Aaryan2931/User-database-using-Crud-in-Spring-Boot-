package com.springrest.springrest.controller;

import com.springrest.springrest.dto.CourseDelete;
import com.springrest.springrest.dto.CourseUpdateInput;
import com.springrest.springrest.dto.request.CourseInput;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    private final CourseService courseService;

    public MyController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome to courses application";
    }

//   @GetMapping("/save")
//    public Course save(@RequestBody Course course){
//        return CourseService.saveCourse(course);}

    @GetMapping("/courses")
    public List<Course> getCourses() {

        return this.courseService.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody CourseInput course) {

        return this.courseService.addCourse(course);
    }

    @PutMapping("/courses")
    public List<Course> updateCourse(@RequestBody CourseUpdateInput courseUpdateInput) {
        List<Course> courses = courseService.updateCourse(courseUpdateInput);
        return courses;
    }
    @DeleteMapping("/courses/{courseId}")
    public List<Course> deleteCourse(@PathVariable Long courseId) {
        CourseDelete courseDelete = new CourseDelete();
        courseDelete.setCourseId(courseId);

        return courseService.deleteCourse(courseDelete);

    }
}
