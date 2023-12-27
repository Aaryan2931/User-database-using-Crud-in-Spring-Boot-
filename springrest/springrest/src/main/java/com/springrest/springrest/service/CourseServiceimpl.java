package com.springrest.springrest.service;
import com.springrest.springrest.dto.CourseDelete;
import com.springrest.springrest.dto.CourseUpdateInput;
import com.springrest.springrest.dto.request.CourseInput;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.repository.CourseRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceimpl implements CourseService {

    private final CourseRepo courseRepo;

    List<Course> list;
    public CourseServiceimpl(CourseRepo courseRepo){
        this.courseRepo = courseRepo;
        list= new ArrayList<>();
        list.add(new Course(12,"JAVA","Programing Language"));
        list.add(new Course(256,"Spring Boot","Rest Api"));

    }
    @Override
    public List<Course> getCourses() {
//        TODO Auto-generated method stub
        return list;
    }

    @Override //Get by CourseID Method
    public Course getCourse(long courseId) {
        Course c = null;
        for (Course course:list)
        {
            if(course.getId()==courseId)
            {
                c=course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(CourseInput courseInput) {
        Course c = new Course();
        c.setTitle(courseInput.getTitle());
        c.setDescription(courseInput.getDescription());
        return c;
    }


    public List<Course> updateCourse(CourseUpdateInput courseUpdateInput){
        Long courseId = courseUpdateInput.getCourseId();
        String title = courseUpdateInput.getTitle();
        String description = courseUpdateInput.getDescription();


        for (int i=0; i<list.size(); i++){
            Course course = list.get(i);
            long id = course.getId();
            if(id == courseId){
                course.setDescription(description);
                course.setTitle(title);
            }
        }
        return list;
    }

    @Override
    public List<Course> deleteCourse(@NotNull CourseDelete courseDelete) {
//        list.remove(courseId);
//        return courseId ;
//    }
        Long courseId = courseDelete.getCourseId();
        for (int i = 0; i < list.size(); i++) {
            Course course = list.get(i);
            long id = course.getId();
            if (id == courseId) {
                list.remove(course);
                break;
            }
        }
      return list;
    }
}

